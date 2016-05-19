package dao;

public enum AccessData {
	
	DRIVER("com.mysql.jdbc.Driver"),
	
	USERNAME("root"),
	PASSCODE("v01p11f83"),
	URL("jdbc:mysql://localhost:3306/data");
	
	private final String data;
	
	AccessData(String data) {
		this.data = data;
	}
	
	public String get() {
		return this.data;
	}
	
	
	
	
	
	

}
