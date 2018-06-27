package myPackage;
import java.util.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.By.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
public class Tatoc {
//WebDriver web=new ChromeDriver();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Users\\vaibhavsadhna\\Downloads\\chromedriver_win32\\chromedriver.exe");
WebDriver web=new ChromeDriver();
web.get("http://10.0.1.86/tatoc/");
web.findElement(By.cssSelector("a")).click();
web.findElement(By.className("greenbox")).click();
web.switchTo().frame("main");
String box1=web.findElement(By.id("answer")).getAttribute("class");
while(true){
	web.findElement(By.cssSelector("a")).click(); 
	web.switchTo().frame("child");
	String box2=web.findElement(By.id("answer")).getAttribute("class");
	web.switchTo().parentFrame();
	if(box1.equals(box2)){
		web.findElement(By.linkText("Proceed")).click();
		break;
		
	}
}
Actions act=new Actions(web);
WebElement drag=web.findElement(By.id("dragbox"));
WebElement drop=web.findElement(By.id("dropbox"));
act.dragAndDrop(drag,drop);
act.build().perform();
web.findElement(By.cssSelector("a")).click();
String parentWindow=web.getWindowHandle();
web.findElement(By.cssSelector("a")).click();
String subWin=null;
Set<String> s1=web.getWindowHandles();
Iterator<String> i=s1.iterator();
while(i.hasNext()){
	subWin=i.next();}
web.switchTo().window(subWin);
web.findElement(By.id("name")).sendKeys("vaibhav");
web.findElement(By.id("submit")).click();
web.switchTo().window(parentWindow);
web.findElement(By.linkText("Proceed")).click();
web.findElement(By.cssSelector("a")).click();
String tokenValue=web.findElement(By.id("token")).getText();
tokenValue=(tokenValue.substring(7));
Cookie cook=new Cookie("Token", tokenValue);
web.manage().addCookie(cook);
web.findElements(By.cssSelector("a")).get(1).click();
}
}
