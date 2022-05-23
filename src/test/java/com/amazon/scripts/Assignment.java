package com.amazon.scripts;

import com.amazon.common.EnvironmentSetup;
import com.amazon.pages.HomePage;
import com.amazon.pages.ItemPage;
import com.amazon.pages.TelevisionsPage;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static com.amazon.common.AllureTestNGListener.logInfo;

public class Assignment extends EnvironmentSetup {

    HomePage homePage;
    TelevisionsPage televisionsPage;
    ItemPage itemPage;

    @Test(priority = 1)
    @Story("To open the 2 costliest item in televisions and assert item details on amazon.in")
    public void completeAssignment() {
        homePage = new HomePage();
        televisionsPage = new TelevisionsPage();
        itemPage = new ItemPage();
        homePage.navigateToHomePage();
        homePage.selectOption("TV, Appliances, Electronics", "Televisions");
        televisionsPage.selectBrandFilter("Samsung");
        televisionsPage.sortList("Price: High to Low");
        String currentWindowHandle = windowHandler.getCurrentWindowHandle();
        televisionsPage.selectNthElementInList(2);
        String[] handles = windowHandler.getAllWindowHandles();
        for (int i = 0; i < handles.length; i++) {
            if(!currentWindowHandle.equals(handles[i])) {
                windowHandler.switchToWindow(handles[i]);
                waitHandler.waitForPageLoad();
            }
        }
        HashMap<String, String> aboutThisItemContent = itemPage.getAboutThisItemContents();

        Assert.assertEquals("About this item", aboutThisItemContent.get("title"), "About this item title is not visible");

        logInfo(aboutThisItemContent.get("title"));
        logInfo(aboutThisItemContent.get("bullet-features"));
    }
}
