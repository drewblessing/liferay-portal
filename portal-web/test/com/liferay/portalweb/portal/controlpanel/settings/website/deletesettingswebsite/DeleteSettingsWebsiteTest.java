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

package com.liferay.portalweb.portal.controlpanel.settings.website.deletesettingswebsite;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class DeleteSettingsWebsiteTest extends BaseTestCase {
	public void testDeleteSettingsWebsite() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Control Panel",
			RuntimeVariables.replace("Control Panel"));
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Portal Settings",
			RuntimeVariables.replace("Portal Settings"));
		selenium.waitForPageToLoad("30000");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//a[@id='_130_websitesLink']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//a[@id='_130_websitesLink']",
			RuntimeVariables.replace("Websites"));
		assertEquals("http://www.liferay.com",
			selenium.getValue("//input[@id='_130_websiteUrl0']"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//button[2]")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("//button[2]", RuntimeVariables.replace("Delete"));
		assertFalse(selenium.isTextPresent("//input[@id='_130_websiteUrl0']"));
	}
}