package com.everis.automationtraining.steps;

import com.everis.automationtraining.utils.BrowserDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

import static com.everis.automationtraining.utils.BrowserDriver.getCurrentDriver;

public class LoginSteps {

    private WebDriver driver;

    public LoginSteps() {
        this.driver = getCurrentDriver();
    }

    @Given("^I go to '(.*)'$")
    public void iGoToPage(String url) throws Throwable {
        driver.get(url);
    }

    @When("^I try to login with the following credentials:$")
    public void iTryToLoginWithTheFollowingCredentials(List<String> credentials) throws Throwable {
        driver.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys(credentials.get(0));
        driver.findElement(By.id("passwd")).sendKeys(credentials.get(1));
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(3000);
    }

    @Then("^I (should|shouldn't) see the following message:$")
    public void iShouldSeeTheFollowingMessage(String condition, String message) throws Throwable {
        String feedback = driver.findElement(By.cssSelector("div.alert.alert-danger > ol > li")).getText();

        if ("should".equals(condition)) {
            Assert.assertTrue(message.contains(feedback));
        } else {
            Assert.assertFalse(message.contains(feedback));
        }
        BrowserDriver.closeBrowser();
    }
}


