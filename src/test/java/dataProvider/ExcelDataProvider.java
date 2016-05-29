package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;
	
	
	public ExcelDataProvider()
	{
		
		File src=new File("./ApplicationTestData/AppData.xlsx");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			
		    wb=new XSSFWorkbook(fis);
			
		} catch (Exception e) 
		{
			System.out.println("Ëxception is "+e.getMessage());
		}
	  	
	}
	
	
	public String getData(int sheetIndex,int row,int column)
	{
		
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	public String getData(String sheetName,int row,int column)
	{
		
		String data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
		return data;
	}
	
	
	
	
	
}
