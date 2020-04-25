package Cucumber1;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class MyStepdefsLogin {
    WebDriver driver;
    Login login;
    @Given("user in navigation site")
    public void userInNavigationSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login= PageFactory.initElements(driver, Login.class);

        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");


    }

    @And("submit login")
    public void submitLogin() {
        login.login();
    }

    @Then("Login successfully into system")
    public void loginSuccessfullyIntoSystem() {
        Assert.assertTrue(login.VerifyMessage());
    }

    @When("^user enters username as\"([^\"]*)\"$")
    public void userEntersUsernameAs(String uname)  {
        // Write code here that turns the phrase above into concrete actions
        login.enterUsername(uname);
    }

    @And("^password \"([^\"]*)\"$")
    public void password(String password)  {
        login.enterPassword(password);
    }
}
