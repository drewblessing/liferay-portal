/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.socialofficehome.tasks.task.clicktasksprogressbar100percentcomplete;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewResolveTasksTaskAssignedToMeTest extends BaseTestCase {
	public void testViewResolveTasksTaskAssignedToMe()
		throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.open("/user/joebloggs/so/dashboard/");

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible(
									"//nav/ul/li[contains(.,'Home')]/a/span")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Home"),
					selenium.getText("//nav/ul/li[contains(.,'Home')]/a/span"));
				selenium.clickAt("//nav/ul/li[contains(.,'Tasks')]/a/span",
					RuntimeVariables.replace("Tasks"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Tasks"),
					selenium.getText("//span[@class='portlet-title-default']"));
				assertEquals(RuntimeVariables.replace("Assigned to Me"),
					selenium.getText("link=Assigned to Me"));
				selenium.clickAt("link=Assigned to Me",
					RuntimeVariables.replace("Assigned to Me"));
				selenium.waitForPageToLoad("30000");

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("//td[1]/input")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				boolean showCompleted1Checked = selenium.isChecked(
						"//td[1]/input");

				if (showCompleted1Checked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//td[1]/input",
					RuntimeVariables.replace("Check Show Completed Tasks"));

			case 2:

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (selenium.isVisible("link=Task Description")) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Task Description"),
					selenium.getText("link=Task Description"));
				selenium.clickAt("link=Task Description",
					RuntimeVariables.replace("Task Description"));

				for (int second = 0;; second++) {
					if (second >= 90) {
						fail("timeout");
					}

					try {
						if (RuntimeVariables.replace("Task Description")
												.equals(selenium.getText(
										"//h1[@class='header-title']"))) {
							break;
						}
					}
					catch (Exception e) {
					}

					Thread.sleep(1000);
				}

				assertEquals(RuntimeVariables.replace("Task Description"),
					selenium.getText("//h1[@class='header-title']"));
				assertEquals(RuntimeVariables.replace("Assigned to Joe Bloggs"),
					selenium.getText("//div[@class='task-data assignee']"));
				assertEquals(RuntimeVariables.replace("Resolved"),
					selenium.getText("//div[@class='task-data status']"));
				assertEquals(RuntimeVariables.replace("Normal"),
					selenium.getText("//div[@class='task-data normal']"));
				assertEquals("Reopen",
					selenium.getValue("//input[@value='Reopen']"));

			case 100:
				label = -1;
			}
		}
	}
}