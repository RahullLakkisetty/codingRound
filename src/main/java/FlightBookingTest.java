import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/* Intializes WebDriver, Automate FlightBooking Page and Closes web browser */ 
public class FlightBookingTest extends BaseUtility{
	
	private static WebDriver driver=null;

	   //Page Object Elements of FlightBooking Page
            @FindBy(linkText = "Flights")
	    private WebElement flightLink;
	 
	    @FindBy(linkText = "One Way")
	    private WebElement trip;

	    @FindBy(id = "FromTag")
	    private WebElement source;

	    @FindBy(id = "ToTag")
	    private WebElement destination;

	    @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a")
	    private WebElement departOn;
	    
	    @FindBy(id = "Adults")
	    private WebElement noOfPeople;
	    
	    @FindBy(id = "SearchBtn")
	    private WebElement searchFlights;
	
	    
            //Intializes WebDriver from UtilityBase and opens Cleartrip website
	    @BeforeSuite	
	    public void intializeDriver() throws IOException
	    {
	    driver=UtilityBase.getWebDriver();
	    driver.get("https://www.cleartrip.com");
	    waitFor(2000);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    PageFactory.initElements(driver, this);   
	    }
	
	
	    //Opens Flightbooking web page and searches flights from Bangalore to Delhi
	    @Test
	    public void testThatResultsAppearForAOneWayJourney() 
	    {
	    clickButton(flightLink);
	    clearBox(source);
	    enterText(source, "Bangalore",Keys.TAB);
	    clearBox(destination);
	    enterText(destination, "Delhi",Keys.TAB);
            clickButton(departOn);
	    selectDropDown(noOfPeople,"2");
	    clickButton(searchFlights);
	    System.out.println("Succesfully Booked your Flight"); 
	    Assert.assertTrue(isElementPresent(By.className("searchSummary"),driver));
	    }


	    //Closes browser after executing test
            @AfterSuite
	    public void quitBrowser(){
	    {
	    driver.quit();
	    }

}
