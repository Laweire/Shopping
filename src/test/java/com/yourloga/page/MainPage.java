package com.yourloga.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.yourloga.base.Basework;



public class MainPage extends Basework {
	
	final static Logger logger = Logger.getLogger(MainPage.class);

	public MainPage gotothepage() {
		try{
			
			driver.get("http://automationpractice.com/index.php");
			String pageTitle = driver.getTitle();
			logger.info("the title of th epage is " + pageTitle);
			String expactedTitle = "My Store";
			assertEquals(pageTitle, expactedTitle);
		}
		catch (Exception e){
			logger.error("Error:",e);
			assertTrue(false);
		}
			return this;
		}
	
	
	public MainPage categories(){
		
		Lib.clickButton(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		
		return this;
	}
	
	public MainPage sundress(){
		
		Lib.clickButton(By.xpath("//*[@id='subcategories']/ul/li[2]/div[1]/a/img"));
		Lib.clickButton(By.xpath("//*[@id='subcategories']/ul/li[3]/div[1]/a/img"));
		
		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Summer Dresses - My Store";
		assertEquals(pageTitle, expactedTitle);
		
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/h5/a"));
		//color
		Lib.clickButton(By.xpath("//*[@id='color_8']"));
		//add to cart
		Lib.clickButton(By.xpath("//*[@id='add_to_cart']/button/span"));
		//proced
		Lib.clickButton(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span"));
		return this;
		
		
	}
	public MainPage checkoutbtn(){
		
		Lib.clickButton(By.xpath("//*[@id='center_column']/p[2]/a[1]/span"));
		return this;
	}
	public MainPage creatac(){
		
		Lib.enterText(By.xpath("//*[@id='email_create']"), "LW@gmail.com");
		Lib.clickButton(By.xpath("//*[@id='SubmitCreate']/span"));
		
		Lib.enterText(By.xpath("//*[@id='customer_firstname']"), "L");
		Lib.enterText(By.xpath("//*[@id='customer_lastname']"), "W");
		Lib.enterText(By.xpath("//*[@id='email']"), "lw@gmail.com");
		Lib.enterText(By.xpath("//*[@id='passwd']"),"123456");
		
		Lib.selectDropDown("6", By.xpath("//*[@id='days']"));
		Lib.selectDropDown("19", By.xpath("//*[@id='months']"));
		Lib.selectDropDown("1997", By.xpath("//*[@id='years']"));
		
		Lib.enterText(By.xpath("//*[@id='address1']"), "9104 bank st");
		Lib.enterText(By.xpath("//*[@id='city']"), "New York");
		Lib.selectDropDown("32", By.xpath("//*[@id='id_state']"));
		Lib.enterText(By.xpath("//*[@id='postcode']"), "10003");
		Lib.enterText(By.xpath("//*[@id='phone_mobile']"), "5719925340");
		Lib.clickButton(By.xpath("//*[@id='submitAccount']/span"));
		return this;
	}
		public MainPage addycomfirm(){
			
		
		//addy
		Lib.clickButton(By.xpath("//*[@id='center_column']/form/p/button/span"));
		
		//term of services
		Lib.clickButton(By.xpath("//*[@id='cgv']"));
		//order
		Lib.clickButton(By.xpath("//*[@id='cart_navigation']/button/span"));
		//back
		Lib.clickButton(By.xpath("//*[@id='center_column']/p[2]/a"));
		//home
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[2]/a/span"));
		return this;
	}
	public MainPage login(){
		
		Lib.enterText(By.xpath("//*[@id='email']"), "lw@gmail.com");
		Lib.enterText(By.xpath("//*[@id='passwd']"), "123456");
		Lib.clickButton(By.xpath("//*[@id='SubmitLogin']/span"));
		return this;
	}
	public MainPage signin(){
		Lib.clickButton(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a"));
	
		return this;
			
	}
	public MainPage search(){
		Lib.enterText(By.xpath("//*[@id='search_query_top']"), "black dress");
		Lib.clickButton(By.xpath("//*[@id='searchbox']/button"));
		
		
		return this;
	}
	public MainPage ordermore(){
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[2]/a[1]/span"));
		Lib.clickButton(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
		Lib.clickButton(By.xpath("//*[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span"));
		Lib.clickButton(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span"));
		
		return this;
	}
	public MainPage carts(){
		Lib.clickButton(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a/b"));
		return this;
		
	}
	
}
