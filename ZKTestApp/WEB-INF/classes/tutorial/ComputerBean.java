package tutorial;

public class ComputerBean {

	private String id;
	private String model;
	private String warrantyTime;
	private double salvage;
	private String product;
	private String serialNumber;
	private String os;
	private String brand;
	private String date;
	private double cost;
	
	public String getId() {
		return id;
	}
	public void setId(String nextLine) {
		this.id = nextLine;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getWarrantyTime() {
		return warrantyTime;
	}
	public void setWarrantyTime(String warrantyTime) {
		this.warrantyTime = warrantyTime;
	}
	public double getSalvage() {
		return salvage;
	}
	public void setSalvage(double d) {
		this.salvage = d;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double d) {
		this.cost = d;
	}
	
}
