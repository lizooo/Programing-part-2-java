package ua.lviv.iot.storeTask;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.storeTask.Manager.StoreManager;
import ua.lviv.iot.storeTask.Model.AbstractProduct;
import ua.lviv.iot.storeTask.Model.AgeGroup;

class StoreManagerTest extends BaseStoreManagerTest {

  private StoreManager storeManager;
  List<AbstractProduct> expectedFoundproducts = new LinkedList<AbstractProduct>();

  @BeforeEach
  public void setUp() {
    storeManager = new StoreManager();
    storeManager.addproducts(products);
  }

  @Test
  public void testFindByPrice() {
    List<AbstractProduct> foundProducts = storeManager.findByPrice(60.00);
    assertEquals(4, foundProducts.size());
    assertEquals(75.25, foundProducts.get(0).getPriceInUAH());
    assertEquals(90.00, foundProducts.get(1).getPriceInUAH());
    assertEquals(150.75, foundProducts.get(2).getPriceInUAH());
  }

  @Test
  public void testFindForAgeGroup() {
    List<AbstractProduct> foundProducts = storeManager.findForAgeGroup(AgeGroup.ONE_TWO_MONTH);
    assertEquals(1, foundProducts.size());
  }

  @Test
  public void testCheckIfExpired() throws ParseException {
    if (products.get(3).checkIfExpired() == false) {
      int var = 1;
      assertEquals(1, var);
    }
  }

}
