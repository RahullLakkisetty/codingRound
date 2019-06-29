import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.sun.javafx.PlatformUtil;

public class UtilityBase {

	  /*WaitFor Functionality--holds driver for certain time*/

  public void waitFor(int durationInMilliSeconds) {
       try {
           Thread.sleep(durationInMilliSeconds);
       } catch (InterruptedException e) {
           e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
       }
   }

  /*Environment Setup Selects driver as per Operating System*/

  public static String setEnvironment()
		  {
	   if (PlatformUtil.isMac()) {
		   return "chromedriver";
       }
       if (PlatformUtil.isWindows()) {
    	   return "chromedriver.exe";
       }
       if (PlatformUtil.isLinux()) {
    	   return "chromedriver_linux";
       }
	return null;
	

		  }
  
  /*Intialize WebDriver for Chrome*/
  
public static WebDriver getWebDriver() throws IOException {
	
System.setProperty("webdriver.chrome.driver",setEnvironment());
WebDriver driver=new ChromeDriver();
return driver;
}


/*Checks the availiablity of Element*/

public boolean isElementPresent(By by,WebDriver driver) {
    try {
        driver.findElement(by);
        return true;
    } catch (NoSuchElementException e) {
        return false;
    }
}


/*Enters text into textBox*/

public void enterText( WebElement webElement, String inputValue) {
webElement.sendKeys(inputValue);
waitFor(1000);
}


/*Enters text into textBox- Overloaded above method */

public void enterText( WebElement webElement, String inputValue, Keys tab) {
webElement.sendKeys(inputValue,tab);
}


/*Clicks button*/

public void clickButton(WebElement webElement) {
webElement.click();
waitFor(2000);
}


/*dropDown Functinolity*/

public void selectDropDown(WebElement webElement, String text) {
Select sel=new Select(webElement);
sel.selectByVisibleText(text);
waitFor(3000);
//waitFor(2000);

}

/*Clears textBox*/

public void clearBox(WebElement webElement) {
webElement.clear();
waitFor(1000);

}


/*Captures textData from webElement*/

public String getText(WebElement webElement) {
waitFor(1000);
return webElement.getText();


}

/*Iframe Functionality*/
   
   public void iFrame(WebElement webElement,WebDriver driver) {
   	driver.switchTo().frame(webElement);
   	waitFor(1000);

}

	
}
