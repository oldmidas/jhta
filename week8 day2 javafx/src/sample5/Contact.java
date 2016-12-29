package sample5;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Contact {
	private StringProperty name = new SimpleStringProperty();
	private StringProperty phone = new SimpleStringProperty(); 
	private StringProperty email = new SimpleStringProperty();
	private StringProperty addr = new SimpleStringProperty();
	private StringProperty fax = new SimpleStringProperty();
	
	public Contact() {}
	
	public Contact(String name, String phone, String email, String addr, String fax) {
		this.name.set(name);
		this.phone.set(phone);
		this.email.set(email);
		this.addr.set(addr);
		this.fax.set(fax);
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name.set(name);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone.set(phone);
	} 
	public StringProperty phoneProperty() {
		return phone;
	}
	
	public String getEmail() {
		return email.get();
	}
	public void setEmail(String email) {
		this.email.set(email);
	}
	public StringProperty emailProperty() {
		return email;
	}
	
	public String getAddress() {
		return addr.get();
	}
	public void setAddress(String address) {
		this.addr.set(address);
	}
	public StringProperty addressProperty() {
		return addr;
	}
	
	public String getFax() {
		return fax.get();
	}
	public void setFax(String fax) {
		this.fax.set(fax);
	}
	public StringProperty faxProperty() {
		return fax;
	}
	
}