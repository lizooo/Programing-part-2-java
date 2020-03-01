package ua.lviv.iot.storeTask.Model;

public class BabyShampoo extends AbstractProduct {
	
	private int valueInMl;
	private  boolean isForSensitiveEyes;
	
	public BabyShampoo(double priceInUAH, String producer, AgeGroup ageGroup,int valueInMl, boolean isForSensitiveEyes) {
		super(priceInUAH, producer, ageGroup);
		this.valueInMl = valueInMl;
		this.isForSensitiveEyes = isForSensitiveEyes;
	}
}
