package com.amazon.selenium.interactions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.amazon.interactions.IExecuteJavascript;

public class ExecuteJavascript implements IExecuteJavascript {

    private JavascriptExecutor _js;
    private WebDriver _driver;

    public ExecuteJavascript(Object driver) {
        _driver = (WebDriver) driver;
        _js = (JavascriptExecutor) _driver;
    }

    public Object executeAsyncScript(String script, Object... args) {
        return _js.executeScript(script, args);
    }

    public Object executeScript(String script, Object... args) {
        return _js.executeScript(script, args);
    }
}
