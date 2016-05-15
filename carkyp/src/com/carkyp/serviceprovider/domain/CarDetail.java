package com.carkyp.serviceprovider.domain;

public class CarDetail {
	private String carbrend;
	private String carmodel;
	private String year;
	private String platenumber;
	private String treatmentDate;
	private String vinNumber;
	
	
	public CarDetail(){}
	
	

	public CarDetail(String carbrend, String carmodel, String year,
			String platenumber, String treatmentDate, String vinNumber) {
		super();
		this.carbrend = carbrend;
		this.carmodel = carmodel;
		this.year = year;
		this.platenumber = platenumber;
		this.treatmentDate = treatmentDate;
		this.vinNumber = vinNumber;
	}

	






	public final String getPlatenumber() {
		return platenumber;
	}



	public final void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}



	public final String getTreatmentDate() {
		return treatmentDate;
	}



	public final void setTreatmentDate(String treatmentDate) {
		this.treatmentDate = treatmentDate;
	}



	public final String getVinNumber() {
		return vinNumber;
	}



	public final void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}



	public final String getCarbrend() {
		return carbrend;
	}
	public final void setCarbrend(String carbrend) {
		this.carbrend = carbrend;
	}
	public final String getCarmodel() {
		return carmodel;
	}
	public final void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}
	public final String getYear() {
		return year;
	}
	public final void setYear(String year) {
		this.year = year;
	}



	@Override
	public String toString() {
		return "CarDetail [carbrend=" + carbrend + ", carmodel=" + carmodel
				+ ", year=" + year + ", platenumber=" + platenumber
				+ ", treatmentDate=" + treatmentDate + ", vinNumber="
				+ vinNumber + "]";
	}
	
	
	
	

}
