package UtilitiesTest;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataProvider {

	
	public static Object[][] getvalue(String excelname,String exsheetname) throws Exception
	{
		String filelocation="./Datas/"+excelname+".xlsx";
	
		FileInputStream input = new FileInputStream(filelocation);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet= workbook.getSheet(exsheetname);
		
		// to  get number of row
		
		int RowNum = sheet.getLastRowNum();
		
		// to get cell number
		
		int CellNum = sheet.getRow(0).getLastCellNum();
		Object data[][]= new Object[RowNum][CellNum];
		
		// loop for row
		for(int i=1;i<=RowNum;i++)
		{
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<CellNum;j++)
			{
				XSSFCell cell = row.getCell(j);
				String cellvalue="";
				//data[i-1][j] = cell.getStringCellValue();
			
				switch(	cell.getCellType())
				{
				case STRING:
					cellvalue = cell.getStringCellValue();
					break;
				case NUMERIC:
					cellvalue = String.valueOf((int)cell.getNumericCellValue());
					break;
				}
				
				data[i-1][j]=cellvalue;
				
			}
		}
		input.close();
		workbook.close();
		return data;
		
	}
	
	
	

}
