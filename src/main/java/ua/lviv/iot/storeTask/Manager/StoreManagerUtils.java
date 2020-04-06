package ua.lviv.iot.storeTask.Manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.storeTask.Model.Product;
import ua.lviv.iot.storeTask.Model.SortType;

public class StoreManagerUtils {
  private static final ProductSorterByPrice PRODUCT_SORTER_BY_PRICE = new ProductSorterByPrice();

  public static void sortByPrice(List<Product> products, SortType sortType) {

    products.sort(
        sortType == SortType.ASC ? PRODUCT_SORTER_BY_PRICE : PRODUCT_SORTER_BY_PRICE.reversed());

  }

  public static void sortByProducer(List<Product> products, SortType sortType) {
    Comparator<Product> comparator = Comparator.comparing(Product::getProducer);
    products.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
  }

  public static void sortByPriceAndProducer(List<Product> products, SortType sortType) {
    Comparator<Product> comparator = new Comparator<Product>() {

      @Override
      public int compare(Product firstProduct, Product secondProduct) {
        int priceComparisonResult =
            Double.compare(firstProduct.getPriceInUAH(), secondProduct.getPriceInUAH());
        if (priceComparisonResult != 0) {
          return priceComparisonResult;
        }
        return firstProduct.getProducer().compareTo(secondProduct.getProducer());
      }
    };
    products.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
  }

  public static void sortByShelfLifeInDays(List<Product> products, SortType sortType) {
    products.sort(
        sortType == SortType.ASC ? (o1, o2) -> (o1.getShelfLifeInDays() - o2.getShelfLifeInDays())
            : (o1, o2) -> (o2.getShelfLifeInDays() - o1.getShelfLifeInDays()));
  }

  static class ProductSorterByPrice implements Comparator<Product> {

    @Override
    public int compare(Product firstProduct, Product secondProduct) {

      return Double.compare(firstProduct.getPriceInUAH(), secondProduct.getPriceInUAH());
    }

  }

  class ProductSorterByProducer implements Comparator<Product> {

    @Override
    public int compare(Product firstProduct, Product secondProduct) {
      return firstProduct.getProducer().compareTo(secondProduct.getProducer());
    }

  }
}
