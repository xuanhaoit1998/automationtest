package testng;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;


public interface log<T extends TestData> { //interface - TẠO hay KHÔNG cũng được
	
	public void writeLog(String src, String sheetName, Set<T> logs) throws IOException;
	
	public void writeDataRow(T log, Row row, XSSFSheet sheet) throws IOException;
	
}
