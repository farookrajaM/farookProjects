package com.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

// this is a base class

public class BaseClass {

	public static WebDriver d;
	public static Properties p;
	
	public BaseClass() {
		try {
			p=new Properties();
			File f=new File("./src/main/java/com/config/config.properties");
			FileInputStream fi=new FileInputStream(f);
			p.load(fi);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	public static void launching() {
String browserName = p.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium Softwares\\chromedriver.exe");	
			d = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			d = new FirefoxDriver(); 
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get(p.getProperty("url"));
	}
	
	
}
