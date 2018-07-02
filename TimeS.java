package hris;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class TimeS {

	WebDriver driver;
	By timesheet= By.id("addstatustag");
	By taskboard=By.className("icon_size taskboard");
	By dashboard=By.className("icon_size dashboard");
	public TimeS(WebDriver driver){
		this.driver=driver;
	}
	public void checkTimeS(){
		driver.findElement(timesheet).click();
		String expectedURL="https://hris.qainfotech.com:8086/time/timesheet";
		 Assert.assertEquals( expectedURL, driver.getCurrentUrl());       
		        
	}
}
