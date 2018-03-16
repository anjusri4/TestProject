package com.fbook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbook.testbase.TestBase;

public class ForgottenAcctPage extends TestBase {
	
	//1.//define page elements
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(xpath="//h2[@class='uiHeaderTitle']")
	WebElement FindUrAcctlabel;
	
	public String emailid;
	
	//2.//initate webelements -initelements
	public ForgottenAcctPage() {
		PageFactory.initElements(driver, this);
	}//Reusable methods that can be used to write testcases
	//3.//get page title(after getting title in this method in test we can 
	//validate that title is as expected 
	public String validateForgottenAcctPageTitle() {
		return driver.getTitle();
		
	}
	//verify label is displayed or not retunring its boolean value in test we can
	//verify that if boolean is true then it is pass
	public boolean verifycorrectForgottenAcctlabel() {
		return FindUrAcctlabel.isDisplayed();
		
	}
	// verify able to Enter value and retunrig its boolean,in test we can
	//verify that if it is able to enter value -true then it is pass
	
	public void EnterValueinemail(String emailid) {
		 email.sendKeys(emailid);
	}
	
	}
