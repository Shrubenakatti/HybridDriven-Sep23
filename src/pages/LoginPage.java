package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;
import constants.ConstantPath;

public class LoginPage extends ControlActions {

	@FindBy(id = "userEmail")
	WebElement userEmailElement;

	@FindBy(id = "userPassword")
	WebElement userPasswordElement;

	@FindBy(id = "login")
	WebElement loginButtonElement;

	@FindBy(xpath = "//div[@aria-label='Login Successfully']")
	WebElement loginSucccessfulElement;
	
	@FindBy(xpath = "//div[text()='*Email is required']")
	WebElement emailIsRequiredElement;

	@FindBy(xpath = "//div[text()='*Password is required']")
	WebElement passedIsRequiredElement;
	
	@FindBy(xpath = "//div[@aria-label='Login Successfully']")
	WebElement loginSuccessfulElement;

	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement loginUnSuccessfulElement;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void login(String email, String password) {
		enterUserEmail(email);
		enterPassword(password);
		clickOnLoginButton();
	}

	public boolean isLoginSuccessFullyDisplayed() {
		waitForElementTobeVisible(loginSucccessfulElement);
		return loginSucccessfulElement.isDisplayed();
	}
	
	public void enterUserEmail(String email) {
		System.out.println("STEP: Entered Email address");
		userEmailElement.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		System.out.println("STEP: Entered Password");
		userPasswordElement.sendKeys(password);
	}

	public void clickOnLoginButton() {
		System.out.println("STEP : Click on Login Button");
		loginButtonElement.click();
	}
	
	public boolean isLoginUnSuccessfulElementDisplayed() {
		return isElementDisplayedWithWait(loginUnSuccessfulElement,ConstantPath.FAST_WAIT);
	}

	public boolean isEmailRequiredElementDisplayed() {
		return isElementDisplayed(emailIsRequiredElement);
	}

	public boolean isPasswordRequiredElementDisplayed() {
		return isElementDisplayed(passedIsRequiredElement);
	}

	public String getCurrentURL() {
		return super.getCurrentURL();
	}
}
