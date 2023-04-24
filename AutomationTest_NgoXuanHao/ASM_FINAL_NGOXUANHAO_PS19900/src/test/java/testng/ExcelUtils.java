package testng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {

	public static final String CHROME_DRIVER_SRC = System.getProperty("user.dir") + "/test-resources/chromedriver.exe";

	public static final String DATA_SRC = System.getProperty("user.dir") + "/test-resources/data/";

	public static final String IMAGES_SRC = System.getProperty("user.dir") + "/test-resources/images/";

	public static XSSFWorkbook getWorkbook(String filePath) throws IOException  { //Qua getWorkbook trước
		File src = new File(filePath); //Lấy File từ đường dẫn
		if (!src.exists()) {
			throw new IOException("Không tồn tại file với đường dẫn: " + filePath);
		}
		FileInputStream fis = new FileInputStream(src); //Chuyển File sang FileInputStream
		XSSFWorkbook workbook = new XSSFWorkbook(fis); //Tạo đối tượng Workbook
		fis.close(); //đóng kết nối
		return workbook;
	}

	public static XSSFSheet getSheet(XSSFWorkbook workbook, String sheetName) { //Lấy sheet
		XSSFSheet sheet = workbook.getSheet(sheetName); //sheetName là tên đặt trong file Excel
		if (sheet == null) {
			throw new NullPointerException("Sheet " + sheetName + " không tồn tại, thêm dữ liệu thất bại!");
		}
		return sheet;
	}

	public static CellStyle getRowStyle(XSSFWorkbook workbook) { //dùng để định dạng tr6en Excel cho đẹp
		CellStyle rowStyle = workbook.createCellStyle();
		rowStyle.setAlignment(HorizontalAlignment.CENTER);
		rowStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		rowStyle.setWrapText(true);

		return rowStyle;
	}

	public static String getCellValue(XSSFSheet sheet, int row, int column) { //đối tương sheet, số hàng, số cột
		String returnValue;
		XSSFCell cell = sheet.getRow(row).getCell(column); //Row - Hàng, Cell - Cột
		//Lấy hàng trước (getRow - số), Lấy Cell (getCel - số cột)
		//Trong Excel là 1 nhưng trong code là bd từ 0)
		//Lấy được Cell thui, chưa lấy dc giá trị
		try {
			if (cell.getCellType() == CellType.STRING) { //Nếu là String thì chuyển về getStringCellValue
				returnValue = cell.getStringCellValue();
			} else if (cell.getCellType() == CellType.NUMERIC) { //Nếu là số thì cũng ép về String
				returnValue = String.format("%.0f", cell.getNumericCellValue());
			} else { //Ko lấy ký tự đặc biệt
				returnValue = "";
			}
		} catch (Exception e) {
			returnValue = "";
		}
		
		return returnValue;
	}

	public static void takeScreenShot(WebDriver driver, String outputSrc) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(outputSrc)); //outputSrc = đường dẫn
	}

	public static Object[][] readSheetData(XSSFSheet sheet) {
		int rows = sheet.getPhysicalNumberOfRows(); //tổng cộng số Row
		int columns = sheet.getRow(0).getLastCellNum(); //tổng số Column

		Object[][] data = new Object[rows - 1][columns]; //tảo mảng 2 chiều
		//-1 để chừa hàng cho title, code bắt đầu từ hàng t2 trở đi
		
		for (int row = 1; row < rows; row++) { //số 1 này tương ứng với hàng t2 trong Excel
			for (int col = 0; col < columns; col++) {
				data[row - 1][col] = ExcelUtils.getCellValue(sheet, row, col); //bên trong getCellValue
			}
		}
		
		return data; //lấy được dữ liệu
	}

	public static void writeImage(String image, Row row, Cell cell, XSSFSheet sheet) throws IOException {
		InputStream is = new FileInputStream(image); //Lấy hình - image là đường dẫn

		byte[] bytes = IOUtils.toByteArray(is); //trung gian

		int pictureId = sheet.getWorkbook().addPicture(bytes, XSSFWorkbook.PICTURE_TYPE_PNG); 
		//dùng addPicture đễ tạo đối tưởng hình ảnh vào Workbook (Chưa có hình thật)
		
		is.close(); //đóng kết nối

		XSSFDrawing drawing = sheet.createDrawingPatriarch(); //Bắt buộc phải khởi tạo để đưa hình lên Excel
		ClientAnchor anchor = new XSSFClientAnchor(); //định vị

		anchor.setCol1(cell.getColumnIndex());
		anchor.setRow1(row.getRowNum());
		anchor.setCol2(cell.getColumnIndex() + 1);
		anchor.setRow2(row.getRowNum() + 1);
		
		drawing.createPicture(anchor, pictureId); //PictureId để biết bỏ hình nào vào
	}

	public static void export(String outputSrc, XSSFWorkbook workbook) throws IOException { //cuối cùng xuất ra file Excel thật
		FileOutputStream out = new FileOutputStream(outputSrc);
		workbook.write(out);
		out.close();
	}

}

