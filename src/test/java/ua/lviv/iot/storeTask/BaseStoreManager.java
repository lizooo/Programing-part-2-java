package ua.lviv.iot.storeTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import ua.lviv.iot.storeTask.Model.AbstractProduct;
import ua.lviv.iot.storeTask.Model.AgeGroup;
import ua.lviv.iot.storeTask.Model.BabyOil;
import ua.lviv.iot.storeTask.Model.BabyPowder;
import ua.lviv.iot.storeTask.Model.BabyShampoo;

class BaseStoreManagerTest {

	protected List<AbstractProduct> products;
	private SimpleDateFormat sdfExpirationDate = new SimpleDateFormat("dd-MM-yyyy");

	@BeforeEach
	public void addproductToStore() throws ParseException {
		products = new LinkedList<AbstractProduct>();
		products.add(new BabyPowder(75.25, "Dove", AgeGroup.ONE_TWO_MONTH, 200, true));
		products.add(new BabyShampoo(90.00, "Johnson Baby", AgeGroup.SEVEN_NINE_MONTH, 150, false));
		products.add(new BabyOil(150.75, "Nivea", AgeGroup.THREE_SIX_MONTH, 100, true));
		products.add(
				new BabyOil(1234, 60.4, "P&G", 300, sdfExpirationDate.parse("25-11-2021"), AgeGroup.SEVEN_NINE_MONTH));
	}

}
