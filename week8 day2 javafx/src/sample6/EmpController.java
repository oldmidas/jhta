package sample6;

import java.text.DecimalFormat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EmpController {
	
	private Stage dialogStage;
	private Emp emp;
	DecimalFormat df = new DecimalFormat("###,###.##");
			
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField jobField;
	@FXML
	private TextField salaryField;
	
	@FXML
	private void ok() {
		dialogStage.close();
	}
	
	public void displayEmpinfo() {
		idField.setText(String.valueOf(emp.getId()));
		nameField.setText(emp.getName());
		jobField.setText(emp.getJob());
		salaryField.setText(df.format(emp.getSalary()));
	}
}
