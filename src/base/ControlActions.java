package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ConstantPath;
import utility.PropOperation;

public abstract class ControlActions {

	protected static WebDriver driver;

	static public void launchBrower() {
		PropOperation propOperation = new PropOperation(ConstantPath.ENV_FILEPATH);
		System.setProperty(ConstantPath.CHROME_DRIVER_KEY, ConstantPath.CHROME_DRIVER_VALUE);
		driver = new ChromeDriver();
		driver.get(propOperation.getValue("url"));
		driver.manage().window().maximize();
	}

	public void launchBrowser(String browser, String url) {
		PropOperation propOperation = new PropOperation(ConstantPath.ENV_FILEPATH);
		System.setProperty(ConstantPath.CHROME_DRIVER_KEY, ConstantPath.CHROME_DRIVER_VALUE);
		driver = new ChromeDriver();
		driver.get(propOperation.getValue("url"));
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}

	protected WebElement getElement(String locatorType, String locatorValue, boolean isWaitRequired) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement e = null;
		switch (locatorType.toUpperCase()) {
		case "XPATH":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			else
				e = driver.findElement(By.xpath(locatorValue));
			break;
		case "CSS":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
			else
				e = driver.findElement(By.cssSelector(locatorValue));
			break;
			
		case "NAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			else
				e = driver.findElement(By.name(locatorValue));
			break;
			
		case "LINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			else
				e = driver.findElement(By.linkText(locatorValue));
			break;
			
		case "PARTIALINKTEXT":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			else
				e = driver.findElement(By.partialLinkText(locatorValue));
			break;
			
		case "CLASSNAME":
			if (isWaitRequired)
				e = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			else
				e = driver.findElement(By.className(locatorValue));
			break;
			
		default:
			System.out.println("Locator is invlaid");
			break;
		}
		return e;
	}
}
