
public class Pyramid {
private String pharaoh;
private String modern_name;
private double latitude;
private double longitude;

public Pyramid(String pharaoh , String modern_name , double latitude , double longitude) {
	this.pharaoh = new String(pharaoh);
	this.modern_name = new String(modern_name);
	this.latitude = latitude;
	this.longitude = longitude;	
}
public Pyramid() {}

public String getPharaoh() {
	return pharaoh;
}

public void setPharaoh(String pharaoh) {
	this.pharaoh = pharaoh;
}

public String getModern_name() {
	return modern_name;
}

public void setModern_name(String modern_name) {
	this.modern_name = modern_name;
}

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}

public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}

@Override
public String toString() {
	return "Pyramid [pharaoh=" + pharaoh + ", modern_name=" + modern_name + ", latitude=" + latitude + ", longitude="
			+ "longitude  ]";
}


}
