package com.yourloga.page;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.yourloga.base.Basework;

public class ContactPage extends  Basework {
	
	final static Logger logger = Logger.getLogger(ContactPage.class);
	
	public ContactPage contact(){
		Lib.clickButton(By.xpath("//*[@id='contact-link']/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Contact us - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		
		return this;
	}
	public ContactPage messgae(){
		Lib.selectDropDown("2", By.xpath("//*[@id='id_contact']"));
		Lib.enterText(By.xpath("//*[@id='email']"), "lw@gmail.com");
		Lib.enterText(By.xpath("//*[@id='id_order']"), "dress");
		
		Lib.enterText(By.xpath("//*[@id='message']"), "need the oder confirmations number");
		Lib.clickButton(By.xpath("//*[@id='submitMessage']/span"));
		
		
		return this;
	}
}
