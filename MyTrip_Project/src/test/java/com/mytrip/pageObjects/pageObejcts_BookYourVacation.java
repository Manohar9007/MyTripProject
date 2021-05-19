package com.mytrip.pageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageObejcts_BookYourVacation {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@aria-activedescendant='react-select-2--value']")
	WebElement from;
	
	@FindBy(xpath = "//input[@aria-activedescendant='react-select-3--value']")
	WebElement to;
	
	@FindBy(xpath = "//input[@value='Search flights']")
	WebElement searchflights;
	
	@FindBy(xpath = "//a[text()='Contact us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//span[text()='Hotels']/..")
	WebElement hotel;
	

	
	public void setPlaceFrom(String placeFrom) {
		
		from.sendKeys(placeFrom);
	}
	
	public void setPlaceTo(String placeTo) {
		
		to.sendKeys(placeTo);
	}
	
	public void searchFlightButton() {
		
		searchflights.click();
	}
	
	public void contactUs() {
		
		contactUs.click();
	}
	
	public void hotels() {
		
		hotel.click();
	}
	
	
	
	public pageObejcts_BookYourVacation(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	

	
}
