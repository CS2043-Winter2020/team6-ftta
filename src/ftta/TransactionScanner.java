  
package ftta;

import java.util.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TransactionScanner {
	private TransactionList tList;
	
	public TransactionScanner(TransactionList tListIn) {
		tList = tListIn;
	}
	
	public TransactionList ScanExcelSheet(TransactionList tList, File fileIn) throws IOException {
		FileInputStream fis = new FileInputStream(fileIn);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sheet = wb.getSheetAt(0);
				
		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
			Row row = sheet.getRow(i);
			
			if (row.getCell(3) == null || row.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK) {
				Transaction transaction = new Transaction(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
						row.getCell(2).getNumericCellValue() , 0);
				
				tList.addToTransactions(transaction);
			}else if(row.getCell(2) == null || row.getCell(2).getCellType() == Cell.CELL_TYPE_BLANK) {
				Transaction transaction = new Transaction(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(),
						0, row.getCell(3).getNumericCellValue());
				
				tList.addToTransactions(transaction);
			}
		}
		
		return tList;
	}
}