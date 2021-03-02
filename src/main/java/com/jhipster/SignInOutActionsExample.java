package com.jhipster;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.jhipster.config.SeleniumConfig;

public class SignInOutActionsExample {

	private SeleniumConfig config;
//    private String url = "http://www.baeldung.com/";
//    private String url = "http://localhost:8080";
	private String url = "http://localhost:9000";

	public SignInOutActionsExample() {
		config = new SeleniumConfig();
		config.getDriver().get(url);
	}

	public void closeWindow() {
		this.config.getDriver().close();
	}

	public String getTitle() {
		return this.config.getDriver().getTitle();
	}


//	 ***** ***** ***** ***** *****
//	 Start: sign in actions based on user role
//	 ***** ***** ***** ***** *****
	public void signInAsAdmin() {
		openAccountMenuDropDown();
		clickSignInLink();
		enterSignInCredentialsForAdmin();
		clickSignInButtonOrHitEnterAfterCredentialsEntered();
	}
	
	public void signInAsUser() {
		openAccountMenuDropDown();
		clickSignInLink();
		enterSignInCredentialsForUser();
		clickSignInButtonOrHitEnterAfterCredentialsEntered();
	}
	
//	 ***** ***** ***** ***** *****
//	 End: sign in actions based on user role
//	 ***** ***** ***** ***** *****
	
//	 ***** ***** ***** ***** *****
//	 Start: common sign in/out actions regardless of role, since the UI should be the same
//	 ***** ***** ***** ***** *****
	
	public void signOutRegardlessOfUserRole() {
		openAccountMenuDropDown();
		clickSignOutLink();
	}
	
	private void openAccountMenuDropDown() {
		Actions actions = new Actions(config.getDriver());
		WebElement aboutElement = this.config.getDriver().findElement(By.id("account-menu"));

//		notes: 
//      in baeldung's website, hover over the navbar "About" allows the drop down actions to appear
//        actions.moveToElement(aboutElement).perform(); 

		actions.moveToElement(aboutElement).click().perform();
	}

	private void clickSignInLink() {
//        WebElement element = this.config.getDriver()
//            .findElement(By.partialLinkText("Sign in"));
		WebElement element = this.config.getDriver().findElement(By.id("login"));
		element.click();
	}
	
	private void clickSignInButtonOrHitEnterAfterCredentialsEntered() {
		this.config.getDriver().findElement(By.tagName("form")).submit();
	}
	
	private void clickSignOutLink() {
		WebElement element = this.config.getDriver().findElement(By.id("logout"));
		element.click();
	}
//	 ***** ***** ***** ***** *****
//	 End: common sign in/out actions regardless of role, since the UI should be the same
//	 ***** ***** ***** ***** *****
	
//	 ***** ***** ***** ***** *****
//	 Start: when sign in modal appears, sign in credentials for relevant roles 
//	 ***** ***** ***** ***** *****

	private void enterSignInCredentialsForAdmin() {
		this.config.getDriver().findElement(By.id("username")).click();
		this.config.getDriver().findElement(By.id("username")).sendKeys("admin");
		this.config.getDriver().findElement(By.id("password")).click();
		this.config.getDriver().findElement(By.id("password")).sendKeys("admin");
	}
	
	private void enterSignInCredentialsForUser() {
		this.config.getDriver().findElement(By.id("username")).click();
		this.config.getDriver().findElement(By.id("username")).sendKeys("user");
		this.config.getDriver().findElement(By.id("password")).click();
		this.config.getDriver().findElement(By.id("password")).sendKeys("user");
	}
//	 ***** ***** ***** ***** *****
//	 End: when sign in modal appears, sign in credentials for relevant roles
//	 ***** ***** ***** ***** *****
	
//	 ***** ***** ***** ***** *****
//	 Start: role specific tests(called in Junit tests) to determine appropriate UI elements is present/absent for intended role
//	 ***** ***** ***** ***** *****

	public boolean isAdministrationDropDownAvailable() {
//        return this.config.getDriver().getPageSource().contains("Administration");
		return this.config.getDriver().findElement(By.id("admin-menu")).getText().trim().equals("Administration");
	}
	
	public boolean isAdministrationDropDownMissing() {
//		https://stackoverflow.com/questions/12270092/best-way-to-check-that-element-is-not-present-using-selenium-webdriver-with-java
//		Xolv.io's answer as well as comments suggest determining absence of elements by findElementsAnd assert zero elements present.
		
		return this.config.getDriver().findElements(By.id("admin-menu")).isEmpty();
	}

//	 ***** ***** ***** ***** *****
//	 End: user specific tests(called in Junit tests) to determine appropriate UI elements is present/absent for their role
//	 ***** ***** ***** ***** *****

}
