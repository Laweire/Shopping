package com.yourloga.base;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.yourloga.library.GlobalLibrary;

public class Basework {
	
	/***
	 * 
	 * @author Lawira Date: 07/07/2020
	 */
	
		final static Logger logger = Logger.getLogger(Basework.class);

		public static WebDriver driver;
		public static GlobalLibrary Lib;
		public ExtentHtmlReporter reporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		@BeforeClass
		public void extentReportSetUp(){
			
			reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReport/myReport.html");
			reporter.config().setDocumentTitle("Testing Report");
			reporter.config().setReportName("Smoke test report");
			reporter.config().setTheme(Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Hostname", "LAPTOP-FEM2N9O");
			extent.setSystemInfo("Testername", "lawira");
			extent.setSystemInfo("OS", "Windowsm 10");
			
			
		}

		@BeforeMethod // this method will run before every single test method
		public void set_up() {
			try {
				logger.info("Start a single test...");
				Lib = new GlobalLibrary(driver);
				driver =Lib.startBrowser("Chrome");
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			}
			
			
			
		}

		@AfterMethod // this method will run after every single test OR after test
						// method fails
		public void tearDown(ITestResult result) {
			logger.info("End a single test...");
			try {
				if (ITestResult.FAILURE == result.getStatus()) {
					// capture screenshot here
				Lib.screenCapture(result.getName());
				}

				Thread.sleep(5 * 1000);

				// if(driver.getWindowHandles().size() > 0) {
				// driver.close(); // closing the browser
				// }

			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			}
		}

		@AfterClass // this method will run after all the tests are completed
		public void afterAllTests() {
			
			extent.flush();
			try {
				if (driver != null) {
					driver.quit();
				}
			} catch (Exception e) {
				logger.error("Error: ", e);
				assertTrue(false);
			}
		}
		
	}


