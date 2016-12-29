package sample5;

import java.io.IOException;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType; 

public class ContactOverviewController {
		

	
	@FXML
	private TableView<Contact> contactTable;
	private ObservableList<Contact> contactData = FXCollections.observableArrayList();
	
	@FXML
	private TableColumn<Contact, String> nameColumn;
	@FXML
	private TableColumn<Contact, String> phoneColumn;
	
	@FXML
	private Label nameLabel;
	@FXML
	private Label phoneLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label addrLabel;
	@FXML
	private Label faxLabel;
	
	public ContactOverviewController() {
		contactData.add(new Contact("홍길동", "010-1234-1234", "hong@gmail.com", "경남", "245-487-4555"));
		contactData.add(new Contact("이순신", "010-4321-6453", "lee@gmail.com", "진도", "014-313-5166"));
		contactData.add(new Contact("강감찬", "010-7854-1278", "kang@gmail.com", "평양", "511-123-7123"));
		contactData.add(new Contact("김유신", "010-9994-9934", "kim@gmail.com", "경주", "168-414-1123"));
	}

	/*
	 * Controller의 initialize() 메소드는 fxml파일이 로드되고 나서 자동으로 실행된다.
	 * 주로, 화면과 관련된 초기화 작업을 구현한다.
	 * 		- 기본데이터 설정
	 * 		- 이벤트 등록
	 */
	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(celldata -> celldata.getValue().nameProperty());
		phoneColumn.setCellValueFactory(celldata -> celldata.getValue().phoneProperty());
		
		contactTable.getSelectionModel()
		.selectedItemProperty()
		.addListener((observable, oldValue, newValue) -> {
			if (contactData != null) {
				nameLabel.setText(newValue.getName());
				phoneLabel.setText(newValue.getPhone());
				emailLabel.setText(newValue.getEmail());
				addrLabel.setText(newValue.getAddress());
				faxLabel.setText(newValue.getFax());
			}
		});
		
		
		contactTable.setItems(contactData);
		
		nameLabel.setText("");
		phoneLabel.setText("");
		emailLabel.setText("");
		addrLabel.setText("");
		faxLabel.setText("");
	}
	
	@FXML
	public void addNewContact() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("ContactEdit.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		
		// 다이얼로그용 스테이지 만들기
		Stage dialogStage = new Stage();
		dialogStage.setTitle("신규 연락처 등록");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.setScene(scene);
		
		// ContactEditController
		ContactEditController editController = loader.getController();
		editController.setContactData(contactData);
		editController.setDialogStage(dialogStage);
		
		dialogStage.showAndWait();
		
	}
	
	@FXML
	public void deleteContact() {
		int selectedIndex = contactTable.getSelectionModel().getSelectedIndex();
		
		if (selectedIndex < 0) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("경고 메세지");
			alert.setHeaderText("연락처 삭제 관련 경고");
			alert.setContentText("삭제할 연락처 정보를 선택해주시기 바랍니다.");
			
			alert.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("확인 메세지");
			alert.setHeaderText("연락처 삭제 확인");
			alert.setContentText("선택한 연락처를 삭제하시겠습니까?");
			
			
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				contactData.remove(selectedIndex);
			}
		}
	}
}