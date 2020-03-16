package ua.lviv.iot.storeTask.Manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.storeTask.Model.AbstractProduct;
import ua.lviv.iot.storeTask.Model.AgeGroup;

public class StoreManager {

  private List<AbstractProduct> productsForSearch = new LinkedList<>();
  AbstractProduct abstractProduct;

  public List<AbstractProduct> findByPrice(double priceInUAH) {

    List<AbstractProduct> foundProducts = new LinkedList<>();
    for (AbstractProduct currentProduct : this.productsForSearch) {
      if (currentProduct.getPriceInUAH() > priceInUAH) {
        foundProducts.add(currentProduct);
      }
    }

    return foundProducts;
  }

  public List<AbstractProduct> findForAgeGroup(AgeGroup ageGroup) {

    List<AbstractProduct> foundProducts = new LinkedList<>();
    for (AbstractProduct currentProduct : this.productsForSearch) {
      if (currentProduct.getAgeGroup() == ageGroup) {
        foundProducts.add(currentProduct);
      }
    }
    return foundProducts;
  }

  public void addproduct(AbstractProduct product) {
    this.productsForSearch.add(product);
  }

  public void addproducts(List<AbstractProduct> productsToAdd) {
    this.productsForSearch.addAll(productsToAdd);
  }
  
  public List<AbstractProduct> getAllAbstractProducts() {
    return this.productsForSearch;
  }
}
