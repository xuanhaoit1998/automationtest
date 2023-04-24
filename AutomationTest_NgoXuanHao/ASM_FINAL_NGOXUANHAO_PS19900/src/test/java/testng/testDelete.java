package testng;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class testDelete {
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
		
		password.sendKeys("123456789a");
		
		login.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement admin = driver.findElement(By.id("admin"));
		admin.click();
		WebElement user = driver.findElement(By.id("user"));
		user.click();
		WebElement usernameUser = driver.findElement(By.name("id"));
		WebElement passwordUser = driver.findElement(By.name("password"));
		WebElement fullnameUser = driver.findElement(By.name("fullname"));
		WebElement emailUser = driver.findElement(By.name("email"));
		WebElement btnDelete = driver.findElement(By.name("btnDelete"));
		
		usernameUser.sendKeys("ad");
		passwordUser.sendKeys("123");
		fullnameUser.sendKeys("duy");
		emailUser.sendKeys("duy22245vn@gmail.com");
		btnDelete.click();
		WebElement message = driver.findElement(By.id("message"));
		System.out.print("thong bao : "+String.valueOf(message));
		assertNotNull(message);
		
		
	}
}
