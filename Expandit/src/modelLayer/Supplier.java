package modelLayer;

public class Supplier {
	private String companyName; 
	private int cvr; 
	private int phone; 
	private String email;
	private SupplierCountry supplierCountry; 
	public Supplier(String companyName, int cvr, int phone, String email , SupplierCountry supplierCountry) {
	
		this.companyName = companyName;
		this.cvr = cvr;
		this.phone = phone;
		this.email = email;
		this.supplierCountry = supplierCountry;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getCvr() {
		return cvr;
	}
	public void setCvr(int cvr) {
		this.cvr = cvr;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public SupplierCountry getSupplierCountry() {
		return supplierCountry;
	}
	public void setSupplierCountry(SupplierCountry supplierCountry) {
		this.supplierCountry = supplierCountry;
	} 
	

}
