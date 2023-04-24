package testng;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	@Test
	public void f() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Desktop\\kiemthunangcao\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost:8080/asm/Login";
		String title = "LOGIN";
		String title_expected = "";
		title_expected = driver.getTitle();
		driver.get(url);
		assertEquals(title, title_expected);

	}

	@Test(priority = 1)
	public void testlogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\Desktop\\kiemthunangcao\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://localhost:8080/asm/Login";
		driver.get(url);
		WebElement username = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("login"));

		username.sendKeys("duypro");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		password.sendKeys("123456789");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement messageerror = driver.findElement(By.id("messageerror"));
		assertNotNull(messageerror);
		
	}
}
