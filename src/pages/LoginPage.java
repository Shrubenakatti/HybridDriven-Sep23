package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.ControlActions;

public class LoginPage extends ControlActions {

	public void login(String email, String password) {
		System.out.println("STEP :  Enter Email address");
		driver.findElement(By.id("userEmail")).sendKeys(email);

		System.out.println("STEP :  Enter Password ");
		driver.findElement(By.id("userPassword")).sendKeys(password);

		System.out.println("STEP :  Click button ");
		driver.findElement(By.id("login")).click();
	}

	public boolean isLoginSuccessFuulyDisplayed() {
	WebElement loginSuccessfulElement= getElement("XPATH","//div[@aria-label='Login Successfully']",true);
		return loginSuccessfulElement.isDisplayed();
	}
}
