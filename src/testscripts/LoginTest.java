/*TestCase1 */

package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.ControlActions;
import pages.LoginPage;

public class LoginTest {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		ControlActions.launchBrower();
	}

	@Test
	public void verifyLogin() {
		LoginPage loginpage = new LoginPage();
		loginpage.login("shrutikad905@gmail.com", "Shrutika@123");

		boolean loginflag = loginpage.isLoginSuccessFuulyDisplayed();
		Assert.assertTrue(loginflag);
	}

	@AfterMethod
	public void tearDown() {
		ControlActions.closeBrowser();
	}
}
