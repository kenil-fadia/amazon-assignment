package com.amazon.pages;

import com.amazon.common.EnvironmentSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.amazon.common.AllureTestNGListener.logFailure;

public class TelevisionsPage extends EnvironmentSetup {

    @FindBy(id = "s-refinements")
    WebElement filters;

    @FindBy(id = "s-result-sort-select")
    WebElement sortDropDown;

    @FindBy(xpath = "//*[text() = 'Sort by:']//parent::span")
    WebElement sortLabel;

    public TelevisionsPage() {
        PageFactory.initElements(factory, this);
    }

    @Step("Selecting a brand filter {0}")
    public void selectBrandFilter(String brand) {
        mouseHandler.scroll(filters.findElement(By.xpath("//*[@id = 's-refinements']//*[contains(text(), '" + brand + "')]")));
        mouseHandler.click(filters.findElement(By.xpath("//*[@id = 's-refinements']//*[contains(text(), '" + brand + "')]")));
        waitHandler.waitForPageLoad();
    }

    @Step("Selecting a {0} sort option")
    public void sortList(String option) {
        try {
            mouseHandler.click(sortLabel);
            waitHandler.waitForVisibilityOf(queryHandler.findElement(By.xpath("//*[text()='" + option +  "']")));
            mouseHandler.click(queryHandler.findElement(By.xpath("//*[text()='" + option +  "']")));
        } catch (Exception e) {
            e.printStackTrace();
            logFailure(e.getMessage());
        }
        waitHandler.waitForPageLoad();
    }

    @Step("Selecting {0} th item in the list")
    public void selectNthElementInList(int index) {
        Object element = queryHandler.findElement(By.cssSelector("[data-component-type = 's-search-result'][data-cel-widget='search_result_" + index + "']"));
        waitHandler.waitForVisibilityOf(element);
        mouseHandler.scroll(element);
        mouseHandler.click(element);
        waitHandler.waitForNoOfWindows(2);
    }
}
