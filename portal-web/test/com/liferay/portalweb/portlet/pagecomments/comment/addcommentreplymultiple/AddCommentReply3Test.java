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

package com.liferay.portalweb.portlet.pagecomments.comment.addcommentreplymultiple;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddCommentReply3Test extends BaseTestCase {
	public void testAddCommentReply3() throws Exception {
		selenium.open("/web/guest/home/");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("link=Page Comments Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Page Comments Test Page",
			RuntimeVariables.replace("Page Comments Test Page"));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace("Post Reply"),
			selenium.getText("//div[3]/div[3]/div/div[2]/ul/li[1]/span/a/span"));
		selenium.clickAt("//div[3]/div[3]/div/div[2]/ul/li[1]/span/a/span",
			RuntimeVariables.replace("Post Reply"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"//textarea[@name='_107_postReplyBody3']")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isVisible("//textarea[@name='_107_postReplyBody3']"));
		selenium.type("//textarea[@name='_107_postReplyBody3']",
			RuntimeVariables.replace("PC Comment Reply3"));
		selenium.clickAt("xPath=(//input[@value='Reply'])[4]",
			RuntimeVariables.replace("Reply"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (RuntimeVariables.replace(
							"Your request processed successfully.")
										.equals(selenium.getText(
								"//div[@class='lfr-message-response portlet-msg-success']"))) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertEquals(RuntimeVariables.replace(
				"Your request processed successfully."),
			selenium.getText(
				"//div[@class='lfr-message-response portlet-msg-success']"));
		assertEquals(RuntimeVariables.replace("PC Comment"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[1]"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply1"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[2]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[2]",
				"in reply to"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply2"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[3]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[3]",
				"in reply to"));
		assertEquals(RuntimeVariables.replace("PC Comment Reply3"),
			selenium.getText(
				"xPath=(//div[@class='lfr-discussion-message'])[4]"));
		assertTrue(selenium.isPartialText(
				"xPath=(//div[@class='lfr-discussion-posted-on'])[4]",
				"in reply to"));
	}
}