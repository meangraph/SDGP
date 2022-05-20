package common;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Pharmacy implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pharmacyID;
	private String password;
	private Address address;
	private HashMap<Medication, Integer> stockList = new HashMap<Medication, Integer>();
	public Pharmacy(String pharmacyID,String password, Address address) {
		super();
		this.pharmacyID = pharmacyID;
		this.password = password;
		this.address = address;
	}
	public String getPharmacyID() {
		return pharmacyID;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Address getAddress() {
		return address;
	}
	public HashMap<Medication, Integer> getStockList() {
		return stockList;
	}
	public void setPharmacyID(String pharmacyID) {
		this.pharmacyID = pharmacyID;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setStockList(Medication x, int y) {
		stockList.put(x, y);
	}
	public void dispenceStock(Medication x,int y) {
		int currentStock = stockList.get(x);
		stockList.put(x, currentStock-y);
	}
	@Override
	public String toString() {
		
		String stock = "";
		
		for(Map.Entry<Medication, Integer> entry : stockList.entrySet()){
			stock += "Chemical name: " + entry.getKey().getChemicalName() + "\nBrand name(s): " + entry.getKey().getBrandName() + "\n" + "Stock: " + entry.getValue();
		}
	
		return "\nPharmacy ID: " + pharmacyID + "\nAddress:" + address + "\n\nStock list\n\n" + stock;
	}
}
