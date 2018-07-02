package hris;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class LogInPage {
 WebDriver driver;
 By username=By.id("txtUserName");
 By pasword=By.id("txtPassword");
 By LogInButton=By.name("Submit");
By wusername=By.id("txtUserName");
By wpassword=By.id("txtPassword");

public LogInPage(WebDriver driver)
{
	 this.driver=driver;
}
//public void setWrongUserName(String wUsername){
	//driver.findElement(wusername).sendKeys(wUsername);
//}
public void setWrongUserName(String wUsername) {
	// TODO Auto-generated method stub
	driver.findElement(wusername).sendKeys(wUsername);
}

public void setWrongPassword(String wPassword){
	driver.findElement(wpassword).sendKeys(wPassword);
}
public void setUserName(String Username){
	driver.findElement(username).sendKeys(Username);
}
public void setPassword(String Password){
	driver.findElement(pasword).sendKeys(Password);
}
public void clickLogIn(){
	driver.findElement(LogInButton).click();
}

	
}