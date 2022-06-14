package com.helpBot.testcases;

import org.testng.annotations.Test;

import com.helpBot.baseclass.BaseClass;

import botPages.ClickonHelpAnContact;
import botPages.LoginPage;
import botPages.SearchPage;
import botPages.SigninPage;
import botPages.TitleVerificationPage;
import botPages.TopicSelect;

public class TopicSelectTest extends BaseClass
{
	TitleVerificationPage test;
	SigninPage signinCheck;
	LoginPage loginPage;
	ClickonHelpAnContact hc;
	SearchPage searchpage;
	TopicSelect ts;
	
	@Test
	public void test() throws Exception
	{
		test=new TitleVerificationPage();
		signinCheck=test.isDisplay();
		signinCheck.signinBtn();
		loginPage=signinCheck.msg();
		loginPage.typeUsername(prop.getProperty("username"));
		loginPage.clickOnContinue();
		loginPage.welcomeMessage();
		loginPage.typePassword(prop.getProperty("password"));
		hc=loginPage.clickOnSignBtn();
		//hc=loginPage.clickOnMayBeLater();
		searchpage=hc.helpAndContact();
		searchpage.clickOnIt();
		ts=searchpage.typeTopic(prop.getProperty("topicId"));
		ts.articleAndChatbot();
	}
}
