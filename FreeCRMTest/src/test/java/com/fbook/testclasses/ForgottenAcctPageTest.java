package com.fbook.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fbook.qa.pages.CreatePage;
import com.fbook.qa.pages.ForgottenAcctPage;
import com.fbook.qa.pages.LoginPage;
import com.fbook.testbase.TestBase;
import com.fbook.util.TestUtil;
//extends of test base for all sub classes
//ctrl+shift+o to import 
public class ForgottenAcctPageTest extends TestBase{
	
	//1. //declare objects of previous classpages
	LoginPage loginPage;
	CreatePage createpage;
	ForgottenAcctPage forgottenAcctPage;
	String sheetName="forgetAcct";
	//2.//constructor
	public ForgottenAcctPageTest() {
		super();//super class TestBase constuctor is called where defined to read config properties
	}
	//3// in setup() method -initialization()method is called -
	// and objects are created for sub classes(LoginPage,CreatePage,ForgottenAcctPage)
	
	@BeforeMethod
	public void setup()  {
		initialization();
		loginPage =new LoginPage();
		createpage=loginPage.login(prop.getProperty("firstname"),prop.getProperty("lastname"));
		forgottenAcctPage=createpage.clickOnForgottenAcct();
		
		
	}
	//verifying title
	@Test(priority=1)
	public void verifyForgottenAcctPageTitleTest() {
		String forgottenAcctPgtitle=forgottenAcctPage.validateForgottenAcctPageTitle();
		Assert.assertEquals(forgottenAcctPgtitle, "Forgotten Password | Can't Log In | Facebook");
		

}
	//verifying label displayed
	@Test(priority=2)
	public void verifyforgottenAcctPglabelTest() {
		Assert.assertTrue(forgottenAcctPage.verifycorrectForgottenAcctlabel());
	}
	@DataProvider
	public Object[][] getFbTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=3,dataProvider="getFbTestData")
	public void EnteremailidTest(String emailid) {
		forgottenAcctPage.EnterValueinemail(emailid);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
