package hi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Petermillar {
	static ChromeDriver driver;

	public void lunchChrome() {
		System.setProperty("webdriver.chrome.silentOutput", "true");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\bayan\\eclipse-workspace\\hi\\exefiles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.petermillar.com/");
	}

	public void delay() {
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

	}

	public boolean checkLogo() {

		WebElement element = driver
				.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/div/div/div/div[2]/a/div[2]"));
		boolean Logo = element.isDisplayed();
		if (Logo) {
			System.out.println("Logo display");
			return true;
		} else {
			System.out.println("Logo not display");
			return false;
		}
	}

	public boolean checkMyAccount() {
		WebElement element = driver
				.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/div/div/div/div[3]/ul/li/a/span[1]"));
		boolean MyAccount = element.isDisplayed();
		if (MyAccount) {
			System.out.println("MyAccount display ");
			return true;
		} else {
			System.out.println("MyAccount not display  ");
			return false;
		}
	}

	public boolean checkMyBag() {
		WebElement element = driver
				.findElement(By.xpath("/html/body/div[2]/header/nav/div[1]/div/div/div/div[3]/div[3]/div[1]"));
		boolean MyBag = element.isDisplayed();
		if (MyBag) {
			System.out.println("MyBag display");
			return true;
		} else {
			System.out.println("MyBag not display ");
			return false;
		}
	}

	public void login() {
		

		System.out.println("click on my account");

		driver.findElement(By.className("toggle-menu")).click();

		String actualTitle = driver.findElement(By.xpath("//*[@id=\"loginTabHeader\"]")).getText();
		System.out.println(actualTitle);

		String expectedTitle = "Returning Customers";
		if (actualTitle.equalsIgnoreCase(expectedTitle))
			System.out.println("Title Matched to Returning Customers");
		else
			System.out.println("Title didn't match");

		// identify email,password,login
		WebElement email = driver.findElement(By.id("login-form-email"));

		WebElement password = driver.findElement(By.id("login-form-password"));
		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/button"));

		String e = "bayanazar15@gmail.com";
		String p = "1qaz1QAZ@";
		email.sendKeys(e);
		System.out.println("email is enter");

		password.sendKeys(p);
		System.out.println("password is enter");
		loginButton.click();

	}

	public boolean checkAccess() {
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div/div[2]/div")).getText();

		String expectedTitle = "Welcome, bayan";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title Matched");
			return true;
		} else {
			System.out.println("Title didn't match");
			return false;
		}
	}

	public void close() {
		driver.quit();
	}

	public static void main(String[] args) {
		Petermillar obj = new Petermillar();
		obj.lunchChrome();
		obj.delay();
		System.out.println("petermillar website open");
		obj.checkLogo();
		obj.checkMyAccount();
		obj.checkMyBag();
		obj.delay();

		obj.login();

		 obj.checkAccess();
		obj.close();
		System.out.println("petermillar website closed");

	}

}
