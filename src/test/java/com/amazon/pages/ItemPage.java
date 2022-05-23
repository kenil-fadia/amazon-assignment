package com.amazon.pages;

import com.amazon.common.EnvironmentSetup;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class ItemPage extends EnvironmentSetup {

    @FindBy(id = "feature-bullets")
    WebElement aboutThisItemsBullets;

    public ItemPage() {
        PageFactory.initElements(factory, this);
    }

    @Step("Retrieving content from the `about this item` section")
    public HashMap<String, String> getAboutThisItemContents() {
        HashMap<String, String> aboutThisItemSection = new HashMap<String, String>();

        Object element = queryHandler.findElementWithinElement(aboutThisItemsBullets, By.cssSelector(".a-unordered-list"));
        mouseHandler.scroll(element);
        aboutThisItemSection.put("title", queryHandler.getText(queryHandler.findElementWithinElement(aboutThisItemsBullets, By.cssSelector("h1"))));
        aboutThisItemSection.put("bullet-features", queryHandler.getText(queryHandler.findElementWithinElement(aboutThisItemsBullets, By.cssSelector(".a-unordered-list"))));

        return aboutThisItemSection;
    }
}
