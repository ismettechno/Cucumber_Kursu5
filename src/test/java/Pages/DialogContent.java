package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// POM : Page Object Model
public class DialogContent {

    @FindBy(css = "input[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="input[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="button[aria-label='LOGIN']")
    public WebElement loginButton;

}
