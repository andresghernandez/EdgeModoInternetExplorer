package com.compatibilidad.drivers;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import org.joda.time.Seconds;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class Driver {
	static WebDriver driverWeb;

	/*private Driver() {
		System.setProperty("webdriver.edge.driver", "src\\test\\resources\\drivers\\msedgedriver.exe");
		EdgeOptions edgeOptions = new EdgeOptions();
		boolean incognito = true;
		boolean headlesMode = false;
		if (headlesMode) {
			List<String> args = Arrays.asList("--window-size=1280,800","--headless");
            Map<String, Object> map = new HashMap<>();
            map.put("args", args);
            edgeOptions.setCapability("ms:edgeOptions", map);
		} else if (incognito) {
            List<String> args = Arrays.asList("--inPrivate");
            Map<String, Object> map = new HashMap<>();
            map.put("args", args);
            edgeOptions.setCapability("ms:edgeOptions", map);
		}
		edgeOptions.setCapability("acceptInsecureCerts",true);
		driverWeb = new EdgeDriver(edgeOptions);
		driverWeb.manage().window().maximize();
		driverWeb.manage().deleteAllCookies();
		driverWeb.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}*/
	
/*private Driver() {
		System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer.exe");
		InternetExplorerOptions ieOptions = new InternetExplorerOptions();
		//Map<String, Object> ops = (Map<String, Object>) ieOptions.getCapability("se:ieOptions");
		//ops.put("ie.edgechromium", true);
		//ops.put("ie.edgepath", "src\\test\\resources\\drivers\\msedgedriver.exe");
		
		ieOptions.setCapability("ie.edgechromium", true);
		ieOptions.setCapability("ie.edgepath", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");

		ieOptions.ignoreZoomSettings();
		ieOptions.introduceFlakinessByIgnoringSecurityDomains();
		ieOptions.enablePersistentHovering();
		ieOptions.takeFullPageScreenshot();
		ieOptions.disableNativeEvents();
		ieOptions.requireWindowFocus();
		//ieOptions.destructivelyEnsureCleanSession();
		
		ieOptions.setCapability("ignoreProtectedModeSettings", true);
		ieOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
		ieOptions.setCapability("initialBrowserUrl", "https://sucursalpersonas.transaccionesbancolombia.com/mua/USER?scis=QnbeDCjCuXja5VN1WEokE8woYjMJczbZ49hUFproEZY%3D#no-back-button");
		//------------------------------------------------------------------------------------------
		//ieOptions.setCapability("--ie-mode-force", true);-no sirve
		 //System.out.println("caps.getBrowserName() = " + ieOptions.getBrowserName());
		System.out.println("caps ie.edgepath = " + ieOptions.getCapability("ie.edgepath"));
		
		//------------------------------------------------------------------------------------------
		
        driverWeb = new InternetExplorerDriver(ieOptions);
        driverWeb.manage().window().maximize();
		driverWeb.manage().deleteAllCookies();
		driverWeb.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}*/

	
	
	private Driver() {
		
		System.setProperty("webdriver.ie.driver", "src\\test\\resources\\drivers\\IEDriverServer.exe");
		InternetExplorerOptions edgeIe11Options = new InternetExplorerOptions();
		Map<String, Object> ops = (Map<String, Object>) edgeIe11Options.getCapability("se:ieOptions");
		ops.put("ie.edgechromium", true);
		
		edgeIe11Options.setCapability("ie.edgepath", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
		edgeIe11Options.setCapability("initialBrowserUrl", "https://demo.guru99.com/test/newtours/index.php"); //objects
		//edgeIe11Options.setCapability("initialBrowserUrl", "https://espanol.yahoo.com/?p=us&guccounter=1"); // alert activex
		//edgeIe11Options.setCapability("initialBrowserUrl", "https://demo.guru99.com/test/guru99home/"); //FRAME

		edgeIe11Options.setCapability("ignoreProtectedModeSettings", true);
		
		//ops.put("ie.edgepath", System.getProperty("user.dir")+"\\src\\test\\resources\\drivers\\msedgedriver.exe");
		
		edgeIe11Options.setCapability("ignoreZoomSetting", true);
		//edgeIe11Options.setCapability("javascriptEnabled", true);
		edgeIe11Options.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//edgeIe11Options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, true);
		//edgeIe11Options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		//edgeIe11Options.takeFullPageScreenshot();
		
		driverWeb = new InternetExplorerDriver(edgeIe11Options);
		driverWeb.manage().window().maximize();
		driverWeb.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}

	
	public static Driver web() {
		return new Driver();
	}

	public static WebDriver inThePage(String url) {
		//driverWeb.get(url);
		return driverWeb;
	}
	
	public static WebDriver inThePageUrl(String url) {
		driverWeb.get(url);
		return driverWeb;
	}

	public static WebDriver inTheStage() {
		return driverWeb;
	}
	
	public static WebDriver getDriver() {
		return driverWeb;
	}
}
		
			