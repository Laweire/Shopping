package com.yourloga.page;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.yourloga.base.Basework;

public class InfoPage extends Basework {

	final static Logger logger = Logger.getLogger(InfoPage.class);
	
	public InfoPage delivery(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[1]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Delivery - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		
		return this;
		
		
	}
	public InfoPage legalnotice(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));	
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[2]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Legal Notice - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		return this;
	}
	public InfoPage terms(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));	
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[3]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Terms and conditions of use - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		return this;
	}
	public InfoPage aboutus(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));	
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[4]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "About us - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		return this;
}
	public InfoPage sercure(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));	
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[5]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Secure payment - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		return this;
}
	public InfoPage outstores(){
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));	
		Lib.clickButton(By.xpath("//*[@id='informations_block_left_1']/div/ul/li[6]/a"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Stores - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		return this;
}
}