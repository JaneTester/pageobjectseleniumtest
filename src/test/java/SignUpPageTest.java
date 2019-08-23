import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Melkish\\IdeaProjects\\pageobjectseleniumtest\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://github.com/join?source=header-home");
        signUpPage = new SignUpPage(driver);
    }


    @Test
    public void signUpReservedUserNameTest() {
        SignUpPage sp = signUpPage.typeLogin("username");
        String error = sp.getnameReservedErrorText();
        Assert.assertEquals("Username 'username' is unavailable.", error);
    }

    @Test
    public void signUpshortPasswordTest() {
        SignUpPage sp = signUpPage.typePassword("ghod");
        String error = sp.getpasswordshotErrorText();
        Assert.assertEquals("Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter. Learn more.", error);
    }

    @Test
    public void getHeadingTest (){
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Join GitHub", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
