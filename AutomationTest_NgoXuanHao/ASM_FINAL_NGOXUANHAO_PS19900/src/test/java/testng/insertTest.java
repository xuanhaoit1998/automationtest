package testng;

import org.testng.annotations.Test;

import testng.LoginData;
import testng.ExcelUtils;

import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class insertTest {

	private WebDriver driver;

	private final String SRC = ExcelUtils.DATA_SRC + "INSERT_TEST.xlsx";

	private Set<InsertData> logs; // Map
	// Trước khi chạy BeforeMthod thì data sẽ bị reset. logs dùng để chứa dữ liệu
	// trước đó

	private InsertData data;

	@BeforeClass
	public void init() throws IOException {
		// khai báo đường dẫn web driver
		System.setProperty("webdriver.chrome.driver", ExcelUtils.CHROME_DRIVER_SRC);
		// khởi tạo danh sách logs
		logs = new LinkedHashSet<>();
		// dùng HashSet hay LinkHashSet gì cũng được
		// lý do dùng LinkedHashSet để đảm bảo thứ tự dữ liệu test không bị thay đổi do
		// tính chất của kiểu dữ liêu này
	}

	@BeforeMethod
	public void setUp() {
		// khởi tạo và thiết lập các thông số cho web driver
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/asm//Login"); // trang cần test
//		driver.manage().window().maximize();
		

		// khởi tạo biến lưu dữ liệu của 1 row trong excel
		data = new InsertData(); // Khởi tạo lại từ đầu để có dữ liệu mới, ko nhớ cái cũ
	}

	private void processLogin(String username, String password,String fullname,String email) { // hàm tiện ích thực hiện thao tác đăng nhập
		WebElement usernamelogin = driver.findElement(By.name("username"));
		WebElement passwordlogin = driver.findElement(By.name("password"));
		WebElement login = driver.findElement(By.name("login"));
		
		usernamelogin.sendKeys("duypro");
		
		passwordlogin.sendKeys("123456789a");
		
		login.click();
		WebElement admin = driver.findElement(By.id("admin"));
		admin.click();
		WebElement user = driver.findElement(By.id("user"));
		user.click();
		WebElement usernameUser = driver.findElement(By.name("id"));
		WebElement passwordUser = driver.findElement(By.name("password"));
		WebElement fullnameUser = driver.findElement(By.name("fullname"));
		WebElement emailUser = driver.findElement(By.name("email"));
		WebElement btncreate = driver.findElement(By.name("btnCreate"));

		usernameUser.sendKeys(username);
		passwordUser.sendKeys(password);
		fullnameUser.sendKeys(fullname);
		emailUser.sendKeys(email);
		btncreate.click();
	}

	@Test(dataProvider = "InsertData") //Nhờ vào dataProvider nên Test này sẽ chạy hết những dữ liệu có trong file Excel
	public void multipleLogin(String username, String password,String fullname,String email, String expected) throws InterruptedException {
		// ở trong sheet dữ liệu có bao nhiêu cột thì mấy ông truyền vào đúng bấy nhiêu tham số là được
		
		processLogin(username, password,fullname,email); // thực hiện đăng nhập

		// trả về kết quả actual là url của trang web
		// trong trường hợp test thêm sửa xoá actual phải là một thứ gì khác
		// tuỳ vào logic của mấy ông muốn so sánh kiểu gì
		String currentURL = driver.getCurrentUrl(); //actual
		
		// gán dữ liệu cho các fields của đối tượng
		data.setUsername(username);
		data.setPassword(password);
		data.setFullname(fullname);
		data.setEmail(email);
		data.setAction("Test insert function"); // thay đổi mô tả cho phù hợp với trường hợp test
		data.setLogTime(new Date()); 
		data.setExpected(expected); // expected nhập vào từ file data

		Thread.sleep(3000);
		
			data.setActual(currentURL.equalsIgnoreCase("http://localhost:8080/asm/index") ? "Thêm thành công" : "Thêm thất bại");
			assertEquals(expected, currentURL.equalsIgnoreCase("http://localhost:8080/asm/index") ? "Thêm thành công" : "Thêm thất bại");
			
			
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		data.setTestMethod(result.getName()); // setTestMethod

		switch (result.getStatus()) {
		case ITestResult.SUCCESS:
			data.setStatus("SUCCESS"); // setStatus to success
			break;
		case ITestResult.FAILURE:
			data.setStatus("FAILURE"); // setStatus to failure
			data.setException(result.getThrowable().getMessage()); // setException

			// chỉ định đường dẫn lưu file hình ảnh
			String path = ExcelUtils.IMAGES_SRC + "failure-" + System.currentTimeMillis() + ".png"; // tên hình

			// gọi hàm chụp ảnh màn hình từ lớp tiện ích
			ExcelUtils.takeScreenShot(driver, path); // chụp màn hình ngay tại chỗ bị lỗi

			// ghi dữ liệu hình ảnh vào workbook thông qua gán dữ liệu
			data.setImage(path);
			break;
		case ITestResult.SKIP:
			data.setStatus("SKIP"); // setStatus to skip
		default:
			break;
		}

		logs.add(data); // Lưu data vào lags

		driver.close();
	}

	@AfterClass
	public void destroy() throws IOException {
		// cuối cùng sau khi đã thực hiện tất cả các test case
		// gọi hàm writeLog để export dữ liệu ra file
		// lưu ý lúc ghi dữ liệu phải đóng file excel trước (nếu đang mở)
		data.writeLog(SRC, "RESULT_TEST", logs); // tham số bao gồm đường dẫn file xuất, tên sheet, bộ dữ liệu
	}

	@DataProvider(name = "InsertData")
	public Object[][] data() throws IOException { // ĐỌC
		// mở file excel để lấy dữ liệu test
		XSSFWorkbook workbook = ExcelUtils.getWorkbook(SRC);
		// thay đổi tên sheet phù hợp
		XSSFSheet sheet = workbook.getSheet("test_data");
		// đọc dữ liệu test bằng hàm tiện ích
		Object[][] data = ExcelUtils.readSheetData(sheet);

		return data;
	}

}

