package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ControlActions;

public class DashboardPage extends ControlActions{

	@FindBy(xpath="")
	List<WebElement> CategoriesList;
	
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public int getTotalNumOfCategoriesList() {
		return CategoriesList.size();
	}
	
	
}

