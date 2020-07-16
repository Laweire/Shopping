package com.yourloga.library;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GlobalLibrary {

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public GlobalLibrary(WebDriver _driver) {
		driver = _driver;

	}

	public GlobalLibrary(WebDriver _driver, String browserType) {
		driver = _driver;
	}

	public WebDriver startChromeBrowser() {
     WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
		driver = new ChromeDriver();// open Chrome browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// wait
																		// time
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// maximum
																			// wait
																			// //
																			// time
		driver.manage().window().maximize(); // maximize

		return driver;
	}

	public WebDriver startFirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		//System.setProperty("webdriver.gecko.driver", "src/test/resources/Driver/geckodriver.exe");
		driver = new FirefoxDriver();// open firefox browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// wait
																		// time
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// maximum
																			// wait
																			// time
		driver.manage().window().maximize(); // maximize

		return driver;
	}

	public WebDriver startSafariBrowser() {
		
		System.setProperty("webdriver.safari.driver", "src/test/resources/Driver/safaridriver.exe");
		driver = new SafariDriver();// open firefox browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// wait
																		// time
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);// maximum
																			// wait
																			// time
		driver.manage().window().maximize(); // maximize

		return driver;
	}

	public void handleCheckBox(By by, boolean isCheck) {
		WebElement checkBoxElem = driver.findElement(by);
		boolean checkBoxState = checkBoxElem.isSelected();

		if (isCheck == true) {
			if (isCheck == true) {

			} else {
				checkBoxElem.click();
			}

		} else {
			if (checkBoxState == true) {
				checkBoxElem.click();

			} else {
			}
		}

	}


	public WebDriver startBrowser(String browserType) {
		if (browserType.toLowerCase().contains("chrome")) {
			driver = startChromeBrowser();
		} else if (browserType.toLowerCase().contains("firefox")) {
			driver = startFirefoxBrowser();
		} else if (browserType.toLowerCase().contains("ie")) {
			driver = startFirefoxBrowser();
		} else if (browserType.toLowerCase().contains("edge")) {
			driver = startFirefoxBrowser();
		} else if (browserType.toLowerCase().contains("safari")) {
			driver = startFirefoxBrowser();
		} else if (browserType.toLowerCase().contains("opera")) {
			driver = startFirefoxBrowser();
		} else {
			System.out.println("you are using:[" + browserType + "]browser,we dont support this browser yet");
			System.out.println("starting defulat browser 'Chrome'");
			driver = startChromeBrowser();

		}
		driver.manage().deleteAllCookies();
		return driver;

	}

	public void selectDropDown(By by, int index) {
		WebElement element = driver.findElement(by);
		Select dropDown = new Select(element);
		dropDown.selectByIndex(index);
	}

	public void selectDropDown(By by, String visibleText) {
		WebElement element = driver.findElement(by);
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(visibleText);
	}

	public void selectDropDown(String attributeValue, By by) {
		WebElement element = driver.findElement(by);
		Select dropDown = new Select(element);
		dropDown.selectByValue(attributeValue);
	}

	public void enterText(By by, String textString) {
		WebElement element = driver.findElement(by);
		element.clear();
		element.sendKeys(textString);
	}
	
	public void enterandsend(By by) {
		WebElement element = driver.findElement(by);
	
		element.sendKeys(Keys.ENTER);
		
	}

	public void clickenterText(By by, String textString) {
		WebElement element1 = driver.findElement(by);
		element1.click();
		//element1.clear();
		element1.sendKeys(textString);
	}

	public void clickButton(By by) {
		WebElement button = driver.findElement(by);
		button.click();
	}

	public void clickHiddenElement(By by) {
		WebElement elem = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", elem);
	}

	public void customWait(double inSecs) {
		try {
			Thread.sleep((long) (inSecs * 1000));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveMouseToElement(WebElement targetElem) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElem).build().perform();

	}

	public void moveMouseToElement(WebElement firstElem, WebElement secElem) {
		Actions action = new Actions(driver);
		action.moveToElement(firstElem).build().perform();
		customWait(1);
		action.moveToElement(secElem).build().perform();
		customWait(1);
	}

	public void highlightElement(By by) {
		for (int i = 0; i < 4; i++) {

			WrapsDriver wrappedElement = (WrapsDriver) by;
			JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();
			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", by,
					"color: red; border: 2px solid yellow");
			customWait(2);

			js.executeScript("arguments[0].setAttribute('style',arguments[1]);", by, "");
			customWait(2);

		}
	}

	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void scrollByVertically(String verticalPixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0," + verticalPixel + ")"); // positive-down.
																// negative-up
	}

	public void scrollByHorizontally(String horizontalPixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(" + horizontalPixel + ",0)");
	}

	public void sendKeyBoard(CharSequence... keysToSend) {
		WebElement webpage = driver.findElement(By.tagName("body"));
		webpage.sendKeys(keysToSend);

	}

	public String getCurrentTime() {
		String finalTime = null;
		Date date = new Date();
		String tempTime = new Timestamp(date.getTime()).toString();
		// System.out.println("time:"+tempTime);
		finalTime = tempTime.replace("-", "").replace(" ", "").replace(":", "").replace(".", "");
		// System.out.println("updated time:"+finalTime);
		return finalTime;

	}

	public String screenCapture(String screenshotFileName) {
		String filePath = null;
		String fileName = null;
		try {
			
			fileName = screenshotFileName+getCurrentTime()+".png"; 
			filePath = "target/screenshots/";
			File tempfile = new File(filePath);
			if (!tempfile.exists()) {
				tempfile.mkdirs();
			}
			filePath = tempfile.getAbsolutePath();
			

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File(filePath +"/"+ fileName)); // portable,network,graphic

		} catch (Exception e) {
			e.printStackTrace();

		}
		return filePath +"/"+ fileName;

	}

	public WebDriver switchToWindow (int index){
		try{
			Set<String> allBrowser = driver.getWindowHandles();
			Iterator<String> iterator = allBrowser.iterator();
			List<String> windowHandles = new ArrayList<String>();
			while (iterator.hasNext()){
				String window = iterator.next();
				windowHandles.add(window);
			}
				
			//switch
			driver.switchTo().window(windowHandles.get(index));
			
		}catch (Exception e) {
			e.printStackTrace();
			
	}	return driver;
			
		}
	
	public WebElement waitforElement (By by){
		WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement element = null;
		element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
		
		return element;
		
	}
	
	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
	

} // closing class
