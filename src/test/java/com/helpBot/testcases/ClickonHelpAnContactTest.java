package com.helpBot.testcases;

import org.testng.annotations.Test;

import com.helpBot.baseclass.BaseClass;

import botPages.ClickonHelpAnContact;
import botPages.LoginPage;
import botPages.SigninPage;
import botPages.TitleVerificationPage;

public class ClickonHelpAnContactTest extends BaseClass
{
	TitleVerificationPage test;
	SigninPage signinCheck;
	LoginPage loginPage;
	ClickonHelpAnContact hc;
	
	@Test
	public void clickOnHc() throws Exception
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
		hc.helpAndContact();
	}
}
