package com.onerivet.student;

public class Adress {

	private int flatNo;
	private String landmark;
	private String city;
	public int getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(int flatNo) {
		this.flatNo = flatNo;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Adress [flatNo=" + flatNo + ", landmark=" + landmark + ", city=" + city + "]";
	}
	public Adress(int flatNo, String landmark, String city) {
		super();
		this.flatNo = flatNo;
		this.landmark = landmark;
		this.city = city;
	}
	public Adress() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
