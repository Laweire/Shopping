package com.yourloga.test;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.yourloga.base.Basework;
import com.yourloga.page.AccountPage;
import com.yourloga.page.ContactPage;
import com.yourloga.page.InfoPage;
import com.yourloga.page.MainPage;
import com.yourloga.page.SliderPage;

public class SmokeTest extends Basework {

	final static Logger logger = Logger.getLogger(SmokeTest.class);

	MainPage main = new MainPage();
	SliderPage slide = new SliderPage();
	ContactPage contact= new ContactPage();
	InfoPage info= new InfoPage();
	AccountPage acct= new AccountPage();
	
	@Test(enabled = false)
	public void open() {
		main.gotothepage();
	}

	@Test(enabled = false)
	public void sundressorder() {
		main.gotothepage();
		main.categories();
		main.sundress();
	}

	@Test(enabled = false) // order dress and reeact account
	public void ordercheckout() {
		main.gotothepage();
		main.categories();
		main.sundress();
		main.checkoutbtn();
		main.creatac();
		main.addycomfirm();

	}

	@Test(enabled = false) // order dress with exsisting account
	public void checkout() {
		main.gotothepage();
		main.categories();
		main.sundress();
		main.checkoutbtn();
		main.login();
		main.addycomfirm();

	}

	@Test(enabled = false) // sign in
	public void login() {
		main.gotothepage();
		main.signin();

		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Login - My Store";
		assertEquals(pageTitle, expactedTitle);

		main.login();

	}

	@Test(enabled = false) // creat account
	public void create() {
		main.gotothepage();
		main.creatac();
	}

	@Test(enabled = false)
	public void searchdress() {
		main.gotothepage();
		main.search();

		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Search - My Store";
		assertEquals(pageTitle, expactedTitle);

	}

	@Test(enabled = false) //checking cart after putting item
	public void chechingcarts() {

		main.gotothepage();
		main.search();
		main.ordermore();
		main.carts();

		String pageTitle = driver.getTitle();
		logger.info("the title of th epage is " + pageTitle);
		String expactedTitle = "Order - My Store";
		assertEquals(pageTitle, expactedTitle);
	}

	@Test(enabled = false)
	public void topads() {
		main.gotothepage();
		slide.ads();
	}

	@Test(enabled = false)
	public void topads2() {
		main.gotothepage();
		slide.ads2();
	}

	@Test(enabled = false)
	public void topads3() {
		main.gotothepage();
		slide.ads3();

	}
	@Test(enabled = false)
	public void bads() {
		main.gotothepage();
		slide.bottomads();
	}
	@Test(enabled = false)
	public void bads2() {
		main.gotothepage();
		slide.bottomads2();
	}
	@Test(enabled = false)
	public void bads3() {
		main.gotothepage();
		slide.bottomads3();
	}
	@Test(enabled = false)
	public void bads4() {
		main.gotothepage();
		slide.bottomads4();
	}
	@Test(enabled=false)
	public void top(){
		main.gotothepage();
		slide.topslide();
	}
	@Test(enabled=false)//contact page and sending messgae
	public void message(){
		main.gotothepage();
		contact.contact();
		contact.messgae();
		
		WebDriverWait wait= new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='center_column']/p")));
		logger.info("Your message has been successfully sent to our team.");
	}
	@Test(enabled=false)
	public void informtions(){
		main.gotothepage();
		info.delivery();
		info.legalnotice();
		info.terms();
		info.aboutus();
		info.sercure();
		info.outstores();
	}
	@Test(enabled=false)//loginthru account
	public void account(){
		main.gotothepage();
		acct.orders();
		acct.credit();
		acct.addy();
		acct.identity();
		acct.wishlist();
	}
	@Test(enabled=true)//login thru header
	public void account2(){
		main.gotothepage();
		main.signin();
		main.login();
		acct.acctlw();
		acct.orders2();
		acct.credit();
		acct.addy();
		acct.identity();
		acct.wishlist();
	}
}
