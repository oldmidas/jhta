package sample4;

import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class EmployeeSearchController {
	EmployeeDAO employee = new EmployeeDAO();
	
	@FXML
	private TextField employeeNumberField;
	@FXML
	private TextField employeeIdField;
	@FXML
	private TextField employeeNameField;
	@FXML
	private TextField jobIdField;
	@FXML
	private TextField hireDateField;
	@FXML
	private TextField salaryField;
	@FXML
	private TextField departmentIdField;
	@FXML
	private TextField emailField;
	
	@FXML
	public void searchEmployee() throws SQLException {
		EmployeeVO emp = new EmployeeVO();
		emp = employee.searchEmployeeDao(Integer.parseInt(employeeNumberField.getText()));
		employeeIdField.setText(String.valueOf(emp.getEmployeeId()));
		employeeNameField.setText(emp.getEmployeeName());
		jobIdField.setText(emp.getJobId());
		hireDateField.setText(emp.getPrettyHireDate());
		salaryField.setText(emp.getPrettySalary());
		departmentIdField.setText(emp.getDepartmentId());
		emailField.setText(emp.getEmail());
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Searched");
		alert.setContentText("Searched!");
		alert.showAndWait();
		
	}

}
