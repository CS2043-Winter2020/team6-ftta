package ftta;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import javafx.scene.input.DragEvent;

public class Main extends Application implements Initializable {

	private TransactionList tList = new TransactionList();
	private CategoryList cList = new CategoryList();
	private BuyerList bList = new BuyerList();
	private TransactionReport ptList = new TransactionReport();
	private TransactionScanner tScanner = new TransactionScanner(tList);

	Stage stage = new Stage();
	private int stageID = 1;

	public void start() throws Exception {
		Scene scene = null;
		
		if (stageID == 1) {
			Parent root = FXMLLoader.load(getClass().getResource("DragDrop.fxml"));
			scene = new Scene(root, 570, 492);
		}else if (stageID ==2) {
			Parent root = FXMLLoader.load(getClass().getResource("Setup.fxml"));
			scene = new Scene(root, 600, 600);
		}else if (stageID == 3) {
			Parent root = FXMLLoader.load(getClass().getResource("tSort.fxml"));
			scene = new Scene(root, 499, 401);
		}else if (stageID == 4) {
			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			scene = new Scene(root, 600, 600);
		}

		stage.setTitle("Financial Tracker");
		stage.setScene(scene);
		stage.show();
	}

	public void stageTwo() throws Exception {
		Parent root2 = FXMLLoader.load(getClass().getResource("Setup.fxml"));

		Scene sceneTwo = new Scene(root2, 600, 600);

		stage.setScene(sceneTwo);
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

	// Controls

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
					stageID = 2;
					start();
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
	
	@FXML
	public void setupDone() throws Exception {
		stageID = 3;
		start(stage);
	}
	
	@FXML private TextField categoryText;
	@FXML private TextField buyerText;
	@FXML private ListView addedList;
	@FXML private Button submitCategory;
	@FXML private MenuButton tagMenu;
	
	@FXML
	public void addCategory() throws Exception {
		if (submitCategory.onMouseClickedProperty() != null) {
			Category category = new Category(categoryText.getText());
			cList.addCategory(category);			
			//addedList.getItems().add(categoryText.getText() + "was added");
		}
	}
	
	@FXML
	public void addBuyer() throws Exception {
		if (submitCategory.onMouseClickedProperty() != null) {
			Buyer buyer = new Buyer(buyerText.getText());
			bList.addBuyerToList(buyer);
			//addedList.getItems().add(categoryText.getText() + "was added");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
//		stage = primaryStage;
		start();
	}

}
