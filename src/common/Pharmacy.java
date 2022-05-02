package common;
import java.util.HashMap;
import java.util.Map;

public class Pharmacy {
	
	private int pharmacyID;
	private Address address;
	private HashMap<Medication, Integer> stockList = new HashMap<Medication, Integer>();
	public Pharmacy(int pharmacyID, Address address) {
		super();
		this.pharmacyID = pharmacyID;
		this.address = address;
	}
	public int getPharmacyID() {
		return pharmacyID;
	}
	public Address getAddress() {
		return address;
	}
	public HashMap<Medication, Integer> getStockList() {
		return stockList;
	}
	public void setPharmacyID(int pharmacyID) {
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
