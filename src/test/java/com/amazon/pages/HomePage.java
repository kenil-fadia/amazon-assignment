package com.amazon.pages;

import com.amazon.common.EnvironmentSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends EnvironmentSetup {

    @FindBy(id = "nav-hamburger-menu")
    WebElement hamburgerMenuAll;

    @FindBy(id = "hmenu-content")
    WebElement hamburgerMenuContent;

    public HomePage() {
		PageFactory.initElements(factory, this);
	}

    @Step("Navigate to the Amazon Homepage")
    public void navigateToHomePage() {
        windowHandler.open(_baseUrl);
        waitHandler.waitForPageLoad();
    }

    @Step("Selecting option {0} from hamburger menu")
    public void selectOption(String option) {
        mouseHandler.scroll(hamburgerMenuAll);
        mouseHandler.click(hamburgerMenuAll);
        waitHandler.waitForVisibilityOf(hamburgerMenuContent.findElement(By.xpath("//*[contains(text(), '" + option + "')]")));
        mouseHandler.click(hamburgerMenuContent.findElement(By.xpath("//*[contains(text(), '" + option + "')]")));
    }

    @Step("Selecting sub-option {1} under option {0} from hamburger menu")
    public void selectOption(String option, String subOption) {
        selectOption(option);
        waitHandler.waitForVisibilityOf(hamburgerMenuContent.findElement(By.xpath("//*[contains(text(), '" + subOption + "')]")));
        mouseHandler.click(hamburgerMenuContent.findElement(By.xpath("//*[contains(text(), '" + subOption + "')]")));
    }
}
