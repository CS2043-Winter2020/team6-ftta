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
 
	private CategoryList clist;
	private BuyerList blist;
	
	public FileWriter(TransactionReport trep) {
		plist = trep.getPTList();
		pTransactions = this.plist.getList();
		clist = trep.getClist();
		blist = trep.getBlist();
	
	public FileWriter(ProcessedTransactionList plist) {
		this.plist = plist;
		pTransactions = this.plist.getList();
	}

	public void writeToFile(String directory, String fileName) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Transaction Record");
        
        int rowCount = 0;
        int titleColumns = 0;
        Row titleRow = sheet.createRow(rowCount);
        rowCount++;
     
        String[] titles = {"Date", "Description", "Debit", "Credit", "Buyer", "Tag"};

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
    
        writeCategoryTotals(workbook);
        writeBuyerTotals(workbook);

        try (FileOutputStream outputStream = new FileOutputStream(directory + "/"+fileName)) {
            workbook.write(outputStream);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	private void writeCategoryTotals(XSSFWorkbook workbook) {
		XSSFSheet sheet = workbook.createSheet("Category Totals");
        int titleColumns = 0;
        Row titleRow = sheet.createRow(0);
        
        String[] titles = {"Category", "Transaction Total", "Total Points"};
        for(String title : titles) {
        	Cell cell = titleRow.createCell(titleColumns);
        	titleColumns++;
            cell.setCellValue((String)title);
        }
        double pointsTotal = 0;
        for(int i=0; i<clist.size(); i++) {
            Row row = sheet.createRow(i+1);
            int columnCount = 0;
            
            //category name column
            Cell name = row.createCell(columnCount);
            columnCount++;
            name.setCellValue((String) clist.getCategory(i).getName());
            
            //transaction total column
            Cell total = row.createCell(columnCount);
            columnCount++;
            total.setCellValue((Double) clist.getCategory(i).getTransactionTotal());
            
            //points column
            Cell points = row.createCell(columnCount);
            columnCount++;
            double categoryPoints = clist.getCategory(i).getPointsTotal();
            points.setCellValue((Double) categoryPoints);
            pointsTotal += categoryPoints;
        }
        Row finalRow = sheet.createRow(clist.size()+1);
        Cell cell1 = finalRow.createCell(1);
        cell1.setCellValue((String)"Total Points");
        Cell cell2 = finalRow.createCell(2);
        cell2.setCellValue((Double) pointsTotal);
	}
	
	private void writeBuyerTotals(XSSFWorkbook workbook) {
		XSSFSheet sheet = workbook.createSheet("Buyer Totals");
        int rowCount = 0;
        int titleColumns = 0;
        Row titleRow = sheet.createRow(rowCount);
        rowCount++;
        
        String[] titles = {"Buyer Initials", "Transaction Total"};
        for(String title : titles) {
        	Cell cell = titleRow.createCell(titleColumns);
        	titleColumns++;
            cell.setCellValue((String)title);   	
        }
        for(int i=0; i<blist.size(); i++) {
            Row row = sheet.createRow(rowCount);
            rowCount++;
            int columnCount = 0;
            
            //Buyer initials column
            Cell initials = row.createCell(columnCount);
            columnCount++;
            initials.setCellValue((String) blist.getBuyer(i).getInitials());
            
            //Transaction total column
            Cell total = row.createCell(columnCount);
            total.setCellValue((Double) blist.getBuyer(i).getTransactionTotal());
        }
	}
 
}