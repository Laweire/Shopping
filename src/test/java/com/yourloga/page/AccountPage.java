package com.yourloga.page;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yourloga.base.Basework;

public class AccountPage extends Basework{
	
	final static Logger logger = Logger.getLogger(AccountPage.class);
	 
	public AccountPage orders(){
		Lib.clickButton(By.xpath("//*[@id='footer']/div/section[5]/div/ul/li[1]/a"));
		MainPage login = new MainPage();
		login.login();
		
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span"));
		Lib.clickButton(By.xpath("//*[@id='order-list']/tbody/tr/td[7]/a[1]/span"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Order history - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[1]/a/span"));
		return this;
	}
	public AccountPage orders2(){
				
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/span"));
		Lib.clickButton(By.xpath("//*[@id='order-list']/tbody/tr/td[7]/a[1]/span"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Order history - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[1]/a/span"));
		return this;
	}
	public AccountPage credit(){
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[2]/a/span"));
		
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='block-history']/p")));
		logger.info("You have not received any credit slips.");
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[1]/a/span"));
		
		return this;
	}
	public AccountPage addy(){
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[3]/a/span"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Addresses - My Store";
		assertEquals(pageTitle, expactedTitle);
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[1]/a/span"));
		return this;
		
	}
	public AccountPage identity(){
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span"));
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Identity - My Store";
		assertEquals(pageTitle, expactedTitle);
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[1]/a/span"));
		return this;
	}
	public AccountPage wishlist(){
		Lib.clickButton(By.xpath("//*[@id='center_column']/div/div[2]/ul/li/a/span"));
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "My Store";
		assertEquals(pageTitle, expactedTitle);
		
		Lib.enterText(By.xpath("//*[@id='name']"), "LW");
		Lib.clickButton(By.xpath("//*[@id='submitWishlist']/span"));
		Lib.clickButton(By.xpath("//*[@id='mywishlist']/ul/li[1]/a/span"));
		return this;
	}
	public AccountPage acctlw(){
		Lib.clickButton(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span"));
		return this;
	}
}
