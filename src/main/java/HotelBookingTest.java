import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest extedns UtilityBase {

    
           @FindBy(linkText = "Hotels")
	   private WebElement hotelLink;

	   @FindBy(xpath = "//*[@id='Tags']")
	   private WebElement localityTextBox;
   
	   @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[6]/a")
	   private WebElement checkIn;
	   
	   @FindBy(xpath = "//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[2]/a")
	   private WebElement checkOut;
	   
	   @FindBy(id = "//*[@id='SearchHotelsButton']")
	   private WebElement searchButton;

	   @FindBy(xpath = "//*[@id='travellersOnhome']")
	   private WebElement travellerSelection;
	
	
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
    
   	  @Test
	  public void shouldBeAbleToSearchForHotels() 
	  {
	  clickButton(hotelLink);
	  waitFor(2000);
	  enterText(localityTextBox, "Indiranagar, Bangalore",Keys.TAB);
	  clickButton(checkIn);
	  clickButton(checkOut);
	  selectDropDown(travellerSelection,"2 rooms, 4 adults");
          waitFor(2000);
	  clickButton(searchButton);  
	  }
	  

	  @AfterSuite
	  public void quitBrowser()  
	  {
          driver.quit();
	  }


}
