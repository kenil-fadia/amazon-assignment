# Assignment

[Click here to read the assignment](./docs/assignment.md)

## vanilla

This is a base starter kit framework that you can use to build your tests for the above assignment.
However, if you are more comfortable with your own tool kit, feel free to use that as well!

## External dependencies

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE.

## Getting Started

For easiest way to getting started, extract this project and open it from IntelliJ.
> Then Do a dry run on test in : test -> java -> TestSandbox class and see if your setup is correct.  

Tip: Do remember to update this readme file for anything else that you think needs updating here!

## Success

# Amazon Assignment

## Description  

I have used Java, Selenium, PageFactory (to demonstrate page Object Model), and Maven Framework to complete this assignment.  

## Java Version  
Take latest release of AdoptOpenjdk (LTS 11, Hotspot) from here: [AdoptOpenJDK](https://adoptopenjdk.net/?variant=openjdk11&jvmVariant=hotspot)  

## Setting up JAVA_HOME  
Go to your terminal and run following command ls -lart, you will see  .zshrc if not the create with following command vi .zshrc and then save the file by pressing esc then write :q and press enter.  
  
Open .zshrc  in terminal with command vi .zshrc append the following command in the file  
  
```
export JAVA_HOME=$(/usr/libexec/java_home)  
```
  
Now run following command to apply the settings `source .zshrc`  
To verify, run the following command echo $JAVA_HOME and if it displays the value as following  
  
```
/Library/Java/JavaVirtualMachines/temurin-11.jdk/Contents/Home  
```

## Maven  
install maven using homebrew command $ `brew install maven`  

## Executables  

Here is the command you can use -  
  
```
mvn clean test -DmyBrowser="chrome" -Dmode="gui" -Dresolution="laptop" -Denv="prod"  
```

-DmyBrowser - Can have following values ["chrome", "firefox", "safari"]  
-Dmode - Can have following values ["gui", "headless"]  
-Dresolution - Can have following values ["hd", "laptop", "tablet-landscape", "tablet-portrait", "mobile"]  
-Denv - Can have following values ["prod", "stage", "qa"]  

You can also import the maven project into an IDE and execute the `src/TestSuites/testng.xml` as a TestNG suite.  

## Execution Reports  

You can find the execution reports in the HTML format in the "allure-results"  

### Allure Installation  
[Install Allure](https://docs.qameta.io/allure/#_mac_os_x)  

### Generate Allure Report  

```
allure serve ./allure-results  
```
