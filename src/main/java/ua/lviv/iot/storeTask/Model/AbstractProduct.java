package ua.lviv.iot.storeTask.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractProduct {

	private int ID;
	private double priceInUAH;
	private String producer;
	private int shelfLifeInDays;
	protected Date expirationDate;
	protected AgeGroup ageGroup;
	AbstractProduct abstractProduct;

	public AbstractProduct(int iD, double priceInUAH, String producer, int shelfLifeInDays, Date expirationDate,
			AgeGroup ageGroup) {
		ID = iD;
		this.priceInUAH = priceInUAH;
		this.producer = producer;
		this.shelfLifeInDays = shelfLifeInDays;
		this.expirationDate = expirationDate;
		this.ageGroup = ageGroup;
	}

	public AbstractProduct(double priceInUAH, String producer, AgeGroup ageGroup) {

		this(0, priceInUAH, producer, 0, null, ageGroup);
	}

	public AbstractProduct(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getPriceInUAH() {
		return priceInUAH;
	}

	public void setPriceInUAH(double priceInUAH) {
		this.priceInUAH = priceInUAH;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public int getShelfLifeInDays() {
		return shelfLifeInDays;
	}

	public void setShelfLifeInDays(int shelfLifeInDays) {
		this.shelfLifeInDays = shelfLifeInDays;
	}

	public Date getExpirationDate() {
		if (expirationDate == null) {
			expirationDate = new Date(System.currentTimeMillis());
		}
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup ageGroup) {
		this.ageGroup = ageGroup;
	}

	public boolean checkIfExpired() throws ParseException {

		boolean temp = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date currentDate = sdf.parse("29-12-2019");
			if (abstractProduct.getExpirationDate() != null && currentDate != null) {
				if (abstractProduct.getExpirationDate().compareTo(currentDate) > 0) {
					temp = true;
				}
			}
		} catch (NullPointerException e) {
			;
		}
		return temp;
	}
}

// @NonNull
//	public boolean checkIfExpired() throws ParseException, NullPointerException {
//
//		boolean temp = false;
//
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		Date currentDate = sdf.parse("29-12-2019");
//			
//			if (abstractProduct.getExpirationDate().compareTo(currentDate) > 0) {
//				temp = false;
//			} else {
//				temp = true;
//			}
//
//		return temp;
//
//	}
