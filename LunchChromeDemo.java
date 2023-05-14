package hi;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LunchChromeDemo {
public static void main(String [] args)  {
	System.out.print("hi to Testing via Selenium \n");
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\bayan\\eclipse-workspace\\hi\\exefiles\\chromedriver.exe");//open chrome browser
	WebDriver driver =new ChromeDriver();
	//load wait page

	//lunch URL
	driver.navigate().to("https://www.lancome-usa.com/");
	System.out.print("site is open");
	driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

	driver.manage().window().maximize();

    
   
      WebElement element = driver.findElement(By.id("homepage"));
      
      boolean p = element.isDisplayed();
	  //verify if status is true
      if (p) {
         System.out.println("Logo present \n");
      } else {
         System.out.println("Logo not present \n ");
	  
      }
      //verify the "email sign up", "my account" and 'my bag" links are displayed
 boolean emailSignUp = driver.findElement(By.xpath("/html/body/div[10]/header/div[1]/div[3]/div[1]/div[4]/div[1]/div[1]/button")).isDisplayed();
 
 boolean myAccount = driver.findElement(By.xpath("/html/body/div[10]/header/div[1]/div[3]/div[1]/div[4]/div[1]/div[2]/div")).isDisplayed();
 boolean myBag = driver.findElement(By.xpath("/html/body/div[10]/header/div[1]/div[3]/div[1]/div[4]/div[1]/div[5]/div/div/div/button/span[1]")).isDisplayed();

	  //verify if status is true
      if (emailSignUp) {
         System.out.println("email sign up present \n");
      } else {
         System.out.println("email sign up not present \n ");
	  
      }
      if (myAccount) {
          System.out.println("myAccount present \n");
       } else {
          System.out.println("myAccount not present \n ");
 	  
       }
		
		  if (myBag) { System.out.println("myBag present \n"); } 
		  else {
		 System.out.println("myBag not present \n ");
		  
		  }
		 
	      //click on my account link
		  ((JavascriptExecutor)driver).executeScript("document.querySelector(\"a[href='https://www.lancome-usa.com/account']\").click();");
     System.out.println("click on my account is done \n");
    
     String actualTitle=  driver.findElement(By.className("c-account__title")).getText();
   
    String expectedTitle = "SIGN IN";
	if(actualTitle.equalsIgnoreCase(expectedTitle))
		System.out.println("Title Matched to SIGN IN");
	else
		System.out.println("Title didn't match");
	
	  //identify email
	WebElement email = driver.findElement(By.name("email"));
  email.sendKeys("bayanazar15@gmail.com");
    System.out.println("email is enter");
	
    //identify password
    WebElement password = driver.findElement(By.name("password"));
 password.sendKeys("1qaz1QAZ@");

 System.out.println("password is enter");
 
 password.sendKeys(Keys.ENTER);
	/*
	 * WebElement chkBx =
	 * driver.findElement(By.xpath("//*[@id=\"rememberme-079483\"]")); boolean flag2
	 * = chkBx.isSelected(); System.out.println(flag2); if(flag2) //true
	 * System.out.println("checkbox is already selected"); else //false
	 * System.out.println("select checkbox"); chkBx.click();
	 */
//click on sign in 
 //WebElement signIn = driver.findElement(By.className("c-field"));
 //signIn.click();

System.out.println("SIGN IN is done");

 
 //get title from login form and verify it equal to "registered members" //add
			 
WebElement strvalue = driver.findElement(By.className("c-account__user-name h-show-for-large"));
String expected = "Hi bayan azar";
String actual = strvalue.getText();
System.out.println(actual);

if(expected.equals(actual)){
System.out.println("Pass");
}
else {
    System.out.println("Fail");
}
 
	driver.quit();
	System.out.print("site is close \n");

} 
}
