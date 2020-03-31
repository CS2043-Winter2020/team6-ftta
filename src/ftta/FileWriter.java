package ftta;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
/**
 * A very simple program that writes some data to an Excel file
 * using the Apache POI library.
 * @author www.codejava.net
 *
 */
public class FileWriter {
	
	private ProcessedTransactionList plist;
	private ArrayList<ProcessedTransaction> pTransactions;
	
	public FileWriter(ProcessedTransactionList plist) {
		this.plist = plist;
		pTransactions = this.plist.getList();
	}

	public void writeToFile(String directory) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Transaction Record");
        
        int rowCount = 0;
        int titleColumns = 0;
        Row titleRow = sheet.createRow(rowCount);
        rowCount++;
     
        String[] titles = {"Date", "Description", "Credit", "Debit", "Buyer", "Tag"};
        for(String title : titles)
        {
        	Cell cell = titleRow.createCell(titleColumns);
        	titleColumns++;
            cell.setCellValue((String)title);
            	
        }
        for (ProcessedTransaction pTransaction : pTransactions) {

            Row row = sheet.createRow(rowCount);
            rowCount++;
             
            int columnCount = 0;
           
            //date column
            Cell date = row.createCell(columnCount);
            columnCount++;
            date.setCellValue((String) pTransaction.getTransaction().getDate());
            
            //description column
            Cell description = row.createCell(columnCount);
            columnCount++;
            description.setCellValue((String) pTransaction.getTransaction().getDescription());
            
            //debit column
            Cell debit = row.createCell(columnCount);
            columnCount++;
            debit.setCellValue((Double) pTransaction.getTransaction().getDebit());
            
            //credit column
            Cell credit = row.createCell(columnCount);
            columnCount++;
            credit.setCellValue((Double) pTransaction.getTransaction().getCredit());
            
            //buyer column
            Cell buyer = row.createCell(columnCount);
            columnCount++;
            buyer.setCellValue((String) pTransaction.getBuyer());
            
            //tag column
            Cell tag = row.createCell(columnCount);
            columnCount++;
            tag.setCellValue((String) pTransaction.getTag());
             
        }        
        try (FileOutputStream outputStream = new FileOutputStream("Export/TransactionReport.xlsx")) {
            workbook.write(outputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}