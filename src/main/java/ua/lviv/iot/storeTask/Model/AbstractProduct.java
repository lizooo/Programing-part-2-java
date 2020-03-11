package ua.lviv.iot.storeTask.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractProduct {

  private int idOfTheProdct;
  private double priceInUAH;
  private String producer;
  private int shelfLifeInDays;
  protected Date expirationDate;
  protected AgeGroup ageGroup;
  AbstractProduct abstractProduct;

  public AbstractProduct(int id, double priceInUAH, String producer, int shelfLifeInDays,
      Date expirationDate, AgeGroup ageGroup) {
    this.idOfTheProdct = id;
    this.priceInUAH = priceInUAH;
    this.producer = producer;
    this.shelfLifeInDays = shelfLifeInDays;
    this.expirationDate = expirationDate;
    this.ageGroup = ageGroup;
  }

  public AbstractProduct(double priceInUAH, String producer, AgeGroup ageGroup) {

    this(0, priceInUAH, producer, 0, null, ageGroup);
  }

  public AbstractProduct(final Date expirationDate) {
    this.expirationDate = expirationDate;
  }

  public int getID() {
    return idOfTheProdct;
  }

  public void setID(int id) {
    this.idOfTheProdct = id;
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

  public void setExpirationDate(final Date expirationDate) {
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
      if (this.getExpirationDate() != null && currentDate != null
          && this.getExpirationDate().compareTo(currentDate) > 0) {
        temp = true;
      }
    } catch (NullPointerException e) {
    }
    return temp;
  }
}
