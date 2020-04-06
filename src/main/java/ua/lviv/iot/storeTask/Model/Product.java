package ua.lviv.iot.storeTask.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer productId;

  private double priceInUAH;
  private String producer;
  private int shelfLifeInDays;
  protected Date expirationDate;
  protected AgeGroup ageGroup;


  public Product(double priceInUAH, String producer, int shelfLifeInDays,
      Date expirationDate, AgeGroup ageGroup) {
    this.priceInUAH = priceInUAH;
    this.producer = producer;
    this.shelfLifeInDays = shelfLifeInDays;
    this.expirationDate = expirationDate;
    this.ageGroup = ageGroup;
  }

//  public Product(double priceInUAH, String producer, AgeGroup ageGroup) {
//
//    this(0, producer, 0, null, ageGroup);
//  }
  
//  public Product() {
//  }

  public Product(final Date expirationDate) {
    this.expirationDate = expirationDate;
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
      e.printStackTrace();
    }
    return temp;
  }

  public String getHeaders() {
    return "priceInUAH, producer, ageGroup";
  }

  public String toCSV() {
    return priceInUAH + ", " + producer + ", " + ageGroup;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer id) {
    this.productId = id;
  }
}
