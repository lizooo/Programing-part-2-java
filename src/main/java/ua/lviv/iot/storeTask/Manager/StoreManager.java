package ua.lviv.iot.storeTask.Manager;

import java.util.LinkedList;
import java.util.List;
import ua.lviv.iot.storeTask.Model.Product;
import ua.lviv.iot.storeTask.Model.AgeGroup;

public class StoreManager {

  private List<Product> productsForSearch = new LinkedList<>();
  Product abstractProduct;

  public List<Product> findByPrice(double priceInUAH) {

    List<Product> foundProducts = new LinkedList<>();
    for (Product currentProduct : this.productsForSearch) {
      if (currentProduct.getPriceInUAH() > priceInUAH) {
        foundProducts.add(currentProduct);
      }
    }

    return foundProducts;
  }

  public List<Product> findForAgeGroup(AgeGroup ageGroup) {

    List<Product> foundProducts = new LinkedList<>();
    for (Product currentProduct : this.productsForSearch) {
      if (currentProduct.getAgeGroup() == ageGroup) {
        foundProducts.add(currentProduct);
      }
    }
    return foundProducts;
  }

  public void addproduct(Product product) {
    this.productsForSearch.add(product);
  }

  public void addproducts(List<Product> productsToAdd) {
    this.productsForSearch.addAll(productsToAdd);
  }
  
  public List<Product> getAllAbstractProducts() {
    return this.productsForSearch;
  }
}
