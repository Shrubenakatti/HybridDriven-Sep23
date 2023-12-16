package testscripts;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import base.ControlActions;
import pages.LoginPage;

public class TestBase {

	LoginPage loginpage;

	@BeforeMethod
	public void setup() {
		ControlActions.launchBrower();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus());
		ControlActions.takeScreenshot(result.getName());
		ControlActions.closeBrowser();
	}
}
