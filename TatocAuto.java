package myPack;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.*;

//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Set;

//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.Cookie;*/
import org.openqa.selenium.interactions.Actions;

public class NewTestNg {

	String driverPath;
	WebDriver driver;
	
	@BeforeClass
	public void initialize(){
		 driverPath = "C:\\Users\\vaibhavsadhna\\Downloads\\chromedriver_win32\\chromedriver.exe";
		    
		    System.setProperty("webdriver.chrome.driver", driverPath);
		    driver=new ChromeDriver();
	}
   
  @Test (priority=1)
  public void verifyHomepageTitle() 
  {
      System.out.println("launching chrome browser"); 
      
  
      driver.get("http://10.0.1.86/tatoc");
      }
  @Test(priority=2)
  public void compareTitle()
  {
      String expectedTitle = ("Welcome - T.A.T.O.C");
      String actualTitle = driver.getTitle();
      System.out.println(expectedTitle);
      System.out.println(actualTitle);
      
      Assert.assertEquals(actualTitle, expectedTitle);
      //driver.close();
}
  @Test(priority=3)
  public void click_basic_course(){
	  driver.findElement(By.cssSelector("a")).click();
  }
  @Test(priority=4)
  public void click_greebox(){
	  driver.findElement(By.className("greenbox")).click();
  }
@Test(priority=5)
public void repaintBoxAndCheck()
{
	driver.switchTo().frame("main");
	String box1=driver.findElement(By.id("answer")).getAttribute("class");
	while(true)
	{
	 driver.findElement(By.cssSelector("a")).click(); 
		driver.switchTo().frame("child");
		String box2=driver.findElement(By.id("answer")).getAttribute("class");
		driver.switchTo().parentFrame();
		if(box1.equals(box2))
		{
			driver.findElement(By.linkText("Proceed")).click();
			
			break;
		}
}}
 @Test(priority=6)
 public void dragAndDropAndProceed(){
	 Actions act=new Actions(driver);
	 WebElement drag=driver.findElement(By.id("dragbox"));
	 WebElement drop=driver.findElement(By.id("dropbox"));
	 act.dragAndDrop(drag,drop);
	 act.build().perform();
driver.findElement(By.cssSelector("a")).click();
 }
 @Test(priority=7)
 public void launchPopupWindow(){
	 String parentWindow=driver.getWindowHandle();
	 driver.findElement(By.cssSelector("a")).click();
	 }
 @Test(priority=8)
 public void  windowHand(){
	 String parentWindow=driver.getWindowHandle();
	 String subWin=null;
	 Set<String> s1=driver.getWindowHandles();
	 Iterator<String> i=s1.iterator();
	 while(i.hasNext()){
	 	subWin=i.next();}
	driver.switchTo().window(subWin);
	driver.findElement(By.id("name")).sendKeys("vaibhav");
	driver.findElement(By.id("submit")).click();
	 driver.switchTo().window(parentWindow);
 }
 @Test(priority=9)
 public void proceed(){
	 driver.findElement(By.linkText("Proceed")).click();
 }
 @Test(priority=10)
 public void cookie(){
	 driver.findElement(By.cssSelector("a")).click();
	 String tokenValue= driver.findElement(By.id("token")).getText();
	 tokenValue=(tokenValue.substring(7));
	 Cookie cook=new Cookie("Token", tokenValue);
	 driver.manage().addCookie(cook);
	 driver.findElements(By.cssSelector("a")).get(1).click();
 }
}