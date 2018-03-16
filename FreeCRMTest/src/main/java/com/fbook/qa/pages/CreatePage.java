/*
 * Anjula
 */

package com.fbook.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fbook.testbase.TestBase;

public class CreatePage  extends TestBase {
	
	@FindBy(xpath="//h2[@class='uiHeaderTitle']")
    WebElement createpagelabel;
	
	@FindBy(xpath="//a[@href=\"https://www.facebook.com/recover/initiate?lwv=110\"]")
	WebElement forgottenAcct;
	
	public CreatePage() {
		PageFactory.initElements(driver, this);
		
	}
	public String validateCreatePageTitle() {
		return driver.getTitle();
	}
	public boolean verifycorrectcreatepagelabel() {
		return createpagelabel.isDisplayed();
		
	}
	public ForgottenAcctPage clickOnForgottenAcct() {
		forgottenAcct.click();
		return new ForgottenAcctPage();
	}
	
}
