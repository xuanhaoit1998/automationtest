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

public class TestLogin {

	private WebDriver driver;

	private final String SRC = ExcelUtils.DATA_SRC + "LOGIN_TEST.xlsx";

	private Set<LoginData> logs; // Map
	// Trước khi chạy BeforeMthod thì data sẽ bị reset. logs dùng để chứa dữ liệu
	// trước đó

	private LoginData data;

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
		data = new LoginData(); // Khởi tạo lại từ đầu để có dữ liệu mới, ko nhớ cái cũ
	}

	private void processLogin(String username, String password) { // hàm tiện ích thực hiện thao tác đăng nhập
		WebElement usernameInput = driver.findElement(By.name("username"));
		usernameInput.sendKeys(username);

		WebElement passwordInput = driver.findElement(By.name("password"));
		passwordInput.sendKeys(password);

		WebElement form = driver.findElement(By.name("login"));
		form.click();
	}

	@Test(dataProvider = "loginData") //Nhờ vào dataProvider nên Test này sẽ chạy hết những dữ liệu có trong file Excel
	public void multipleLogin(String username, String password, String expected) throws InterruptedException {
		// ở trong sheet dữ liệu có bao nhiêu cột thì mấy ông truyền vào đúng bấy nhiêu tham số là được
		
		processLogin(username, password); // thực hiện đăng nhập

		// trả về kết quả actual là url của trang web
		// trong trường hợp test thêm sửa xoá actual phải là một thứ gì khác
		// tuỳ vào logic của mấy ông muốn so sánh kiểu gì
		String currentURL = driver.getCurrentUrl(); //actual
		
		// gán dữ liệu cho các fields của đối tượng
		data.setUsername(username);
		data.setPassword(password);
		data.setAction("Test login (authenticate) function"); // thay đổi mô tả cho phù hợp với trường hợp test
		data.setLogTime(new Date()); 
		data.setExpected(expected); // expected nhập vào từ file data

		Thread.sleep(3000);
		if(driver.findElements( By.id("message") ).size() != 0) {
			data.setActual(currentURL.equalsIgnoreCase("http://localhost:8080/asm/Home") ? "Đăng Nhập thành công" : "Đăng Nhập thất bại");
			assertEquals(expected, currentURL.equalsIgnoreCase("http://localhost:8080/asm/Home") ? "Đăng Nhập thành công" : "Đăng Nhập thất bại");
			
			
		} else {
			
			data.setActual(currentURL.equalsIgnoreCase("http://localhost:8080/asm/Home") ? "Đăng Nhập thành công" : "Đăng Nhập thất bại");
			assertTrue(driver.findElements( By.id("message") ).size() == 0); // so sánh expected với actual
		}
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

	@DataProvider(name = "loginData")
	public Object[][] data() throws IOException { // ĐỌC
		// mở file excel để lấy dữ liệu test
		XSSFWorkbook workbook = ExcelUtils.getWorkbook(SRC);
		// thay đổi tên sheet phù hợp
		XSSFSheet sheet = workbook.getSheet("LOGIN_DATA");
		// đọc dữ liệu test bằng hàm tiện ích
		Object[][] data = ExcelUtils.readSheetData(sheet);

		return data;
	}

}
