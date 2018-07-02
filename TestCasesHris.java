package hris;
import hris.LogInPage;
import hris.TimeS;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestCasesHris {
WebDriver driver;
@BeforeClass
public void initialize(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\vaibhavsadhna\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
}
@Test(priority=1)
public void geturl(){
	driver.get("https://hris.qainfotech.com/login.php");
	driver.findElement(By.className("active")).click();
}
@Test(priority=3)
public void signIn(){
	driver.findElement(By.className("active")).click();
	LogInPage Login=new LogInPage(driver);
	Login.setUserName("vaibhavsadhna");
	Login.setPassword("Vaibhav@321#");
	Login.clickLogIn();	
}
@Test(priority=2)
public <WebElement> void wrongSignIn(){
	LogInPage login=new LogInPage(driver);
	login.setWrongUserName("vaibhavsadhna");
	login.setWrongPassword("Vaibhav");
	login.clickLogIn();
	String expectedurl="https://hris.qainfotech.com:8086/empFeedback/yourFeedback";
	String actualurl=driver.getCurrentUrl();
	if(!expectedurl.equals(actualurl)){
		
	driver.findElement(By.className("active")).click();
	

}
	}
@Test(priority=4)
public void checkTimeS(){
	TimeS t=new TimeS(driver);
	t.checkTimeS();
	

}
}