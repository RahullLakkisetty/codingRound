import java.io.IOException;
import com.sun.javafx.PlatformUtil;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/* Intializes WebDriver, Automate SignIn Page with null credentials and Closes web browser */
public class SignInTest {
	
	    private static WebDriver driver=null;
    
	    //Page Object Elements of SignIn Page
    	    @FindBy(xpath = "//*[@id='userAccountLink']")
	    private WebElement yourTrips;
	    
	    @FindBy(xpath = "//*[@id='SignIn']")
	    private WebElement signIn;
	    
	    @FindBy(xpath = "//*[@id='modal_window']")
	    private WebElement modalWindow;
	    
	    @FindBy(xpath = "//*[@id='signInButton']")
	    private WebElement frameSignIn;
	    
	    @FindBy(id = "errors1")
	    private WebElement errorMessage;
	
	

             //Intializes WebDriver from UtilityBase and opens Cleartrip website
	    @BeforeSuite	
	    public void intializeDriver() throws IOException 
	    {
	    driver=UtilityBase.getWebDriver();
	    driver.get("https://www.cleartrip.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    PageFactory.initElements(driver, this);
	    }

	    //Opens SignIn web page and SignIn with Null credentials to capture and assert errors
            @Test
	    public void shouldThrowAnErrorIfSignInDetailsAreMissing()
	    {
	    clickButton(yourTrips);
	    clickButton(signIn);
	    iFrame(modalWindow,driver);
	    clickButton(frameSignIn);
	    String errorMsg=getText(errorMessage);
	    Assert.assertTrue(errorMsg.contains("There were errors in your submission"));	
	    }
	
	    //Closes browser after executing test
	    @AfterSuite
	    public void quitBrowser()
	    {
	    driver.quit();
	    }

}
