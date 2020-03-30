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
	
	private Stage stage;
	private int stageID = 1;

	public void start() throws Exception {
		Scene scene = null;
		
		Parent root = FXMLLoader.load(getClass().getResource("DragDrop.fxml"));
		scene = new Scene(root, 570, 492);
		
		this.stage = new Stage();
		stage.setTitle("Financial Tracker");
		stage.setScene(scene);
		stage.show();
		
	}
	
	public void changeScene() throws IOException{
		if (stageID == 1) {
			Parent root = FXMLLoader.load(getClass().getResource("DragDrop.fxml"));		
			stage.getScene().setRoot(root);
		}else if (stageID ==2) {
			Parent root = FXMLLoader.load(getClass().getResource("Setup.fxml"));
			stage.getScene().setRoot(root);
		}else if (stageID == 3) {
			Parent root = FXMLLoader.load(getClass().getResource("tSort.fxml"));
			stage.getScene().setRoot(root);
			transactionSort();
		}else if (stageID == 4) {
			Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
			stage.getScene().setRoot(root);
		}
	}

	public static void main(String args[]) {
		launch(args);
	}
	
	//**********************
	//****** Controls ******
	//**********************

	@FXML private Rectangle rectangle;
	@FXML private TextField categoryText;
	@FXML private TextField buyerText;
	@FXML private ListView<String> addedList;
	@FXML private Button submitCategory;
	@FXML private ChoiceBox tagMenu;
	@FXML private Label reportLabel;
	@FXML private TextField tagName;
	
	//defaults
	
	//stage one
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
					changeScene();
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
	
	//Stage Two
	@FXML
	private void nextButton() throws Exception  {
		stageID = 3;
		start(stage);
	}
	@FXML
	public void addCategory() throws Exception {
		if (submitCategory.onMouseClickedProperty() != null) {
			Category category = new Category(categoryText.getText());
			cList.addCategory(category);			
			reportLabel.setText("Category " + category.getName() + " has been added.");
			tagMenu.getItems().add(category.getName());
		}
	}
	
	@FXML
	public void addBuyer() throws Exception {
		if (submitCategory.onMouseClickedProperty() != null) {
			Buyer buyer = new Buyer(buyerText.getText());
			bList.addBuyerToList(buyer);
			reportLabel.setText("Buyer " + buyer.getInitials() + " has been added.");
			//addedList.getItems().add(categoryText.getText() + "was added");
		}
	}
	
	@FXML
	public void addTag() throws Exception {
		if (submitCategory.onMouseClickedProperty() != null) {
			cList.getCategory(tagMenu.getValue().toString()).addTag(tagName.getText());
			reportLabel.setText("Tag " + tagName.getText() + " has been added to " + tagMenu.getValue());
		}
	}
	
	//stage three
	
	@FXML private ChoiceBox buyerList;
	@FXML private ChoiceBox tagList;
	@FXML private Label transactionLbl;
	
	@FXML
	public void updateButton() throws Exception{
		loadBuyers();
		loadTags();
	}
	
	@FXML
	public void loadBuyers() throws Exception{
		for (int i = 0; i < 1; i++) {
			buyerList.getItems().add(bList.getBuyerInitials(i));
		}
	}
	
	@FXML
	public void loadTags() throws Exception{
		for (int i = 0; i < 1; i++) {
			tagList.getItems().add(cList.getCategory(0));
		}
	}
	
	@FXML
	public void transactionSort() {
		transactionLbl.setText(tList.getTransactions().get(0).toString());
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Not to fill but breaks without !?
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		start();
	}

}
