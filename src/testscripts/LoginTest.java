/*TestCase1 */

package testscripts;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelOperations;

public class LoginTest extends TestBase{

	WebDriver driver;
	
	@Test
	public void verifyLogin() {
		loginpage.login("shrutikad905@gmail.com", "Shrutika@12");
		boolean loginflag = loginpage.isLoginSuccessFullyDisplayed();
		Assert.assertTrue(loginflag);
	}
	
	@Test
	public void verifyErrorMessages() {
		System.out.println("STEP: Click on login button");
		loginpage.clickOnLoginButton();
		
		System.out.println("VERIFY: Email required Error messgae is visible");
		boolean emailErrorMsgFlag = loginpage.isEmailRequiredElementDisplayed();	
		Assert.assertTrue(emailErrorMsgFlag);
		
		System.out.println("VERIFY: Password required Error messgae is visible");
		boolean passwordErrorMsgFlag = loginpage.isPasswordRequiredElementDisplayed();	
		Assert.assertTrue(passwordErrorMsgFlag);
		
	}

	@Test
	public void verifyPasswordErrorMessage() {
		System.out.println("STEP - Enter valid User email");
		loginpage.enterUserEmail("shrutikad905@gmail.com");
		
		System.out.println("STEP - Click on Login button");
		loginpage.clickOnLoginButton();
		
		System.out.println("VERIFY - Email required Error messages is not visible");
		boolean emailErrorMessageFlag = loginpage.isEmailRequiredElementDisplayed();
		Assert.assertFalse(emailErrorMessageFlag);
		
		System.out.println("VERIFY - Password required Error messages is visible");
		boolean passwordErrorMessageFlag = loginpage.isPasswordRequiredElementDisplayed();
		Assert.assertTrue(passwordErrorMessageFlag);
	}
	
	@Test
	public void verifyEmailErrorMessageDisplayed() {
		System.out.println("STEP - Enter valid password");
		loginpage.enterPassword("Shrutika@123");
		
		System.out.println("STEP - Click on Login button");
		loginpage.clickOnLoginButton();
		
		System.out.println("VERIFY - Email required Error messages is visible");
		boolean emailErrorMessageFlag = loginpage.isEmailRequiredElementDisplayed();
		Assert.assertTrue(emailErrorMessageFlag);
		
		System.out.println("VERIFY - Password required Error messages is not visible");
		boolean passwordErrorMessageFlag = loginpage.isPasswordRequiredElementDisplayed();
		Assert.assertFalse(passwordErrorMessageFlag);
	}
	
	@Test(dataProvider = "LoginDataProvider")
	public void verifyloginUsingDataDriven(String username, String password, String loginStatus) {
		System.out.println("STEP - Login with given credentails");
		loginpage.login(username, password);
		String currentURL = "";
		boolean loginFlag;
		if(loginStatus.equalsIgnoreCase("pass")) {
			System.out.println("VERIFY - Login Successful toast message displayed");
			loginFlag = loginpage.isLoginSuccessFullyDisplayed();
			Assert.assertTrue(loginFlag, "Login successfully Message was not displayed");
			
			System.out.println("VERIFY - Incorrect email or password message is not displayed");
			loginFlag = loginpage.isLoginUnSuccessfulElementDisplayed();
			Assert.assertFalse(loginFlag, "Incorrect email or password message was displayed");
			
			currentURL = loginpage.getCurrentURL();
			System.out.println("VERIFY - Application should redirect to dahsboard page");
			Assert.assertTrue(currentURL.endsWith("dashboard/dash"), "Current URL :" + currentURL);
		}else {
			loginFlag = loginpage.isLoginUnSuccessfulElementDisplayed();
			Assert.assertTrue(loginFlag, "Incorrect email or password message was not displayed");
			
			//loginFlag = loginpage.isLoginSuccessFullyDisplayed();
			//Assert.assertFalse(loginFlag, "Login successfully Message was displayed");
		
			currentURL = loginpage.getCurrentURL();
			Assert.assertTrue(currentURL.endsWith("auth/login"));
		}
	}
	
	@DataProvider(name="LoginDataProvider")
	public Object[][] getLoginData() throws IOException{
		return ExcelOperations.getAllRows(".\\testData\\LoginData.xlsx", "Login");
	}
}
