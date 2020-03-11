package ua.lviv.iot.storeTask.Model;

public class BabyPowder extends AbstractProduct {

    private int valueInGr;
    private boolean isTranslucent;

    public BabyPowder(double priceInUAH, String producer, AgeGroup ageGroup, int valueInGr, boolean isTranslucent) {
	super(priceInUAH, producer, ageGroup);
	this.valueInGr = valueInGr;
	this.isTranslucent = isTranslucent;
    }
}
