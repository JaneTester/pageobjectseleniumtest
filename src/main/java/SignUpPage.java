import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[contains(@class,'setup-header')]//h1");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField  =By.xpath("//input[@id='user_email']");
    private By passwordField =By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By mainError = By.xpath("//div[@class='flash flash-error my-3']");
    private By nameError = By.xpath("//form[@id='signup-form']//input[@id='user_login']/ancestor::dd/following-sibling::dd");
    private By emailError = By.xpath("//form[@id='signup-form']//input[@id='user_email']/ancestor::dd/following-sibling::dd");
    private By passwordError = By.xpath("//form[@id='signup-form']//input[@id='user_password']/ancestor::dd/following-sibling::dd");
    private By nameReservedError = By.xpath("//form[@id='signup-form']//input[@id='user_login']/ancestor::dd//div/div");
    private By passwordshotError = By.xpath("//form[@id='signup-form']//password-strength[@invalid-message='Password is invalid.']//p[@class='note mb-3']");

    public SignUpPage typeLogin (String login) {
        driver.findElement(userNameField).sendKeys(login);
        return this;
    }
    public SignUpPage typeEmail (String mail) {
        driver.findElement(emailField).sendKeys(mail);
        return this;
    }
    public SignUpPage typePassword (String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage registerWithInvalidCreds (String login, String mail, String password){
        this.typeLogin(login);
        this.typeEmail(mail);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public String getHeadingText() {
        return driver.findElement(heading).getText();
    }
    public String getMainErrorText(){return driver.findElement(mainError).getText();}
    public String getNameErrorText(){return driver.findElement(nameError).getText();}
    public String getMailErrorText(){ return driver.findElement(emailError).getText();}
    public String getPasswordErrorText() {return driver.findElement(passwordError).getText();}
    public String getnameReservedErrorText () {return driver.findElement(nameReservedError).getText();}
    public String getpasswordshotErrorText () {return driver.findElement(passwordshotError).getText();}
}
