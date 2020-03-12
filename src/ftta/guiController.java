package ftta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.*;

public class guiController implements Initializable{
	private Main main = new Main();
	private TransactionList tList = new TransactionList();
	private CategoryList cList = new CategoryList();
	private TransactionReport ptList = new TransactionReport();
	private TransactionScanner tScanner = new TransactionScanner(tList);
	
	@FXML
	private Rectangle rectangle;
	
	@FXML
	private void handleDragOver(DragEvent event) {
		if (event.getDragboard().hasFiles()) {
			event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
		}
		event.consume();
	}
	
	@FXML
	public void handleDrop(DragEvent event) {
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasFiles()) {
			if (db.getFiles().toString().contains(".xls")) {
				try {
					tList = tScanner.ScanExcelSheet(tList, db.getFiles().toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				success = true;
			} else {
				success = false;
			}
		}
		event.setDropCompleted(success);
		event.consume();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
