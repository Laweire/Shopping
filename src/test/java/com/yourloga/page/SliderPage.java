package com.yourloga.page;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.yourloga.base.Basework;

public class SliderPage extends Basework{
	
	final static Logger logger = Logger.getLogger(SliderPage.class);

	
	public SliderPage ads(){
		Lib.clickButton(By.xpath("//*[@id='homeslider']/li[2]/div/p[2]/button"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	
	public SliderPage ads2(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_top']/ul/li[1]/a/img"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
}
	public SliderPage ads3(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_top']/ul/li[2]/a/img"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	public SliderPage bottomads(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_home']/ul/li[1]/a/img"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	public SliderPage bottomads2(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_home']/ul/li[2]/a/img"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	public SliderPage bottomads3(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_home']/ul/li[3]/a/img"));
		Lib.switchToWindow(1);
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	public SliderPage bottomads4(){
		Lib.clickButton(By.xpath("//*[@id='htmlcontent_home']/ul/li[5]/a/img"));
		Lib.switchToWindow(1);

		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Create and develop your eCommerce website with PrestaShop";
		assertEquals(pageTitle, expactedTitle);
		return this;
	}
	
	public SliderPage topslide(){
		
		Lib.clickButton(By.xpath("//*[@id='header']/div[1]/div/div/a/img"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "My Store";
		assertEquals(pageTitle, expactedTitle);
		return this;
				
	}
	
}
