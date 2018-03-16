package com.fbook.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fbook.qa.pages.CreatePage;
import com.fbook.qa.pages.LoginPage;
import com.fbook.testbase.TestBase;

public class CreatePageTest extends TestBase{
	LoginPage loginPage;
	CreatePage createpage;
	//constructor
	public CreatePageTest() {
		super();//super class constuctor is called
	}
	@BeforeMethod
	public void setup()  {
		initialization();
		loginPage =new LoginPage();
		createpage=loginPage.login(prop.getProperty("firstname"),prop.getProperty("lastname"));
	}
	@Test(priority=1)
	public void verifyCreatePageTitleTest() {
		String createpgtitle=createpage.validateCreatePageTitle();
		Assert.assertEquals(createpgtitle, "Create a Page | Facebook");
		

}
	@Test(priority=2)
	public void verifycreatepagelabelTest() {
		Assert.assertTrue(createpage.verifycorrectcreatepagelabel());
	}
	@Test(priority=3)
	public void clickOnForgottenAcctTest()
	{
		createpage.clickOnForgottenAcct();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}