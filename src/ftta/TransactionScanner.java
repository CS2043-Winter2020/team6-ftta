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
	
	public TransactionList ScanExcelSheet(TransactionList tList, String fileLocationIn) throws IOException {
		String fileLocation = fileLocationIn;
		FileInputStream fis = new FileInputStream(new File(fileLocation.substring(1, fileLocationIn.length()-1)));
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
	
//	public void ProcessedTransactionScanner() throws IOException {
//		FileInputStream fis = new FileInputStream(new File("/team6-ftta/TestFiles/SampleBankRecord2.xls"));
//		HSSFWorkbook wb = new HSSFWorkbook(fis);
//		HSSFSheet sheet = wb.getSheetAt(0);
//		
//		TransactionList tList = new TransactionList();
//		
//		for (int i = 1; i < sheet.getLastRowNum()+1; i++) {
//			Row row = sheet.getRow(i);
//			
//			if (row.getCell(3) == null || row.getCell(3).getCellType() == Cell.CELL_TYPE_BLANK) {
//				ProcessedTransaction pTransaction = new ProcessedTransaction(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getNumericCellValue() , 0, row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue());
//				tList.addToTransactions(pTransaction);
//			}else if(row.getCell(2) == null || row.getCell(2).getCellType() == Cell.CELL_TYPE_BLANK) {
//				ProcessedTransaction pTransaction = new ProcessedTransaction(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), 0, row.getCell(3).getNumericCellValue(), row.getCell(4).getStringCellValue(), row.getCell(5).getStringCellValue());
//				tList.addToTransactions(pTransaction);
//			}
//		} 
//	}
	
}
