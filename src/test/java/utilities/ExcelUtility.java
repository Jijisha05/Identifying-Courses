package utilities;

import java.io.FileInputStream;
import java.io.IOException;
 
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtility {
	public  String readDataweb() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\CoursesSearch.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		String value = row.getCell(0).getStringCellValue();	
		workbook.close();
		file.close();
		return value;
	}
	public  String readDatalang() throws IOException, InterruptedException
	{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\CoursesSearch.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		String value1 = row.getCell(0).getStringCellValue();	
		workbook.close();
		file.close();
		return value1;
	}
	public static String[] formData=new String[5];
    public static String[] readExcelData() throws IOException{   //Do not change the method signature
        //Implement code to read data from excel file. Store the values in 'customerData' array. Return the array. */
        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\Testdata\\FormDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int total_rows = sheet.getLastRowNum();
        int total_columns = sheet.getRow(0).getLastCellNum();
        for(int i=0;i<total_columns;i++)
        {
            formData[i]=sheet.getRow(0).getCell(i).toString();
        }
        workbook.close();
        file.close();
       return formData; 
    }

 
}
