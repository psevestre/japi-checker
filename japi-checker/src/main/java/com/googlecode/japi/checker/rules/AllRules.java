/*
 * Copyright 2011 William Bernardet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.japi.checker.rules;

import com.googlecode.japi.checker.Reporter;
import com.googlecode.japi.checker.model.JavaItem;

import java.util.ArrayList;
import java.util.List;

public class AllRules implements Rule {

	private List<Rule> rules = new ArrayList<Rule>();

	public AllRules() {
		rules.add(new ChangeKindOfAPIType());
		rules.add(new CheckChangeOfScope());
		rules.add(new CheckClassVersion());
		rules.add(new CheckFieldChangeOfType());
		rules.add(new CheckFieldChangeToFinal());
		rules.add(new CheckFieldChangeToStatic());
		rules.add(new CheckFieldChangeToTransient());
		rules.add(new CheckInheritanceChanges());
		rules.add(new CheckMethodChangedToAbstract());
		rules.add(new CheckMethodChangedToFinal());
		rules.add(new CheckMethodChangedToStatic());
		rules.add(new CheckMethodExceptions());
		rules.add(new CheckRemovedField());
		rules.add(new CheckRemovedMethod());
		rules.add(new CheckSerialVersionUIDField());
		rules.add(new ClassChangedToAbstract());
		rules.add(new ClassChangedToFinal());
	}

	@Override
	public void checkBackwardCompatibility(Reporter reporter,
										   JavaItem reference, JavaItem newItem) {
		for (Rule rule : rules) {
			rule.checkBackwardCompatibility(reporter, reference, newItem);
		}
	}

}
