package ua.lviv.iot.storeTask.Model;

import java.util.Date;

public class BabyOil extends AbstractProduct {

    private int valueInMl;
    private boolean isForSensitiveSkin;

    public BabyOil(double priceInUAH, String producer, AgeGroup ageGroup, int valueInMl, boolean isForSensitiveSkin) {
	super(priceInUAH, producer, ageGroup);
	this.valueInMl = valueInMl;
	this.isForSensitiveSkin = isForSensitiveSkin;
    }

    public BabyOil(int iD, double priceInUAH, String producer, int shelfLifeInDays, Date expirationDate,
	    AgeGroup ageGroup) {
	super(iD, priceInUAH, producer, shelfLifeInDays, expirationDate, ageGroup);
    }

}
