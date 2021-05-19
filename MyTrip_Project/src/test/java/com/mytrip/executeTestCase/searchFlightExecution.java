package com.mytrip.executeTestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mytrip.pageObjects.pageObejcts_BookYourVacation;

public class searchFlightExecution {
	
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
	
	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.mytrip.com/");
		driver.manage().window().maximize();
		
		pageObejcts_BookYourVacation byv = new pageObejcts_BookYourVacation(driver);
		Robot rb = new Robot(); 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Date date = new Date();
		
		//Used to enter the departure city
		byv.setPlaceFrom("London");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
	
		//Used to enter the return city
		Thread.sleep(2000);
		byv.setPlaceTo("New York");
		Thread.sleep(2000);
		rb.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
				
		//click on date
		driver.findElement(By.xpath("//input[@placeholder=\"Departure\"]")).click();
		Thread.sleep(2000);
		
		//Used to select the date
		WebElement date1 = driver.findElement(By.xpath("//div[contains(text(),'May 2021')]//..//following-sibling::div[@class='DayPicker-Body']//descendant::div[contains(text(),'21')]//."));
		WebElement date2 = driver.findElement(By.xpath("//div[contains(text(),'June 2021')]//..//following-sibling::div[@class='DayPicker-Body']//descendant::div[contains(text(),'10')]"));
		js.executeScript("arguments[0].click();", date1);
		js.executeScript("arguments[0].click();", date2);
		
		byv.searchFlightButton();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Capturing screenshot after searching flights
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File trg = new File("ScreenshotMyTrip\\search_"+dateFormat.format(date)+".jpeg");
		FileUtils.copyFile(src, trg);
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		byv.contactUs();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		byv.hotels();
		
		//Capturing screenshot of hotels
		File hotelsrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File hoteltrg = new File("ScreenshotMyTrip\\hotel_"+dateFormat.format(date)+".jpeg");
		FileUtils.copyFile(hotelsrc, hoteltrg);
		
		//To close all the browser windows
		driver.quit();
		 
		
	}

}
