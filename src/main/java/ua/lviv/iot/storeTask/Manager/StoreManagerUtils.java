package ua.lviv.iot.storeTask.Manager;

import java.util.Comparator;
import java.util.List;
import ua.lviv.iot.storeTask.Model.AbstractProduct;
import ua.lviv.iot.storeTask.Model.SortType;

public class StoreManagerUtils {
  private static final ProductSorterByPrice PRODUCT_SORTER_BY_PRICE = new ProductSorterByPrice();

  public static void sortByPrice(List<AbstractProduct> products, SortType sortType) {

    products.sort(
        sortType == SortType.ASC ? PRODUCT_SORTER_BY_PRICE : PRODUCT_SORTER_BY_PRICE.reversed());

  }

  public static void sortByProducer(List<AbstractProduct> products, SortType sortType) {
    Comparator<AbstractProduct> comparator = Comparator.comparing(AbstractProduct::getProducer);
    products.sort(sortType == SortType.ASC ? comparator : comparator.reversed());
  }

  public static void sortByPriceAndProducer(List<AbstractProduct> products, SortType sortType) {
    Comparator<AbstractProduct> comparator = new Comparator<AbstractProduct>() {

      @Override
      public int compare(AbstractProduct firstProduct, AbstractProduct secondProduct) {
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

  public static void sortByShelfLifeInDays(List<AbstractProduct> products, SortType sortType) {
    products.sort(
        sortType == SortType.ASC ? (o1, o2) -> (o1.getShelfLifeInDays() - o2.getShelfLifeInDays())
            : (o1, o2) -> (o2.getShelfLifeInDays() - o1.getShelfLifeInDays()));
  }

  static class ProductSorterByPrice implements Comparator<AbstractProduct> {

    @Override
    public int compare(AbstractProduct firstProduct, AbstractProduct secondProduct) {

      return Double.compare(firstProduct.getPriceInUAH(), secondProduct.getPriceInUAH());
    }

  }

  class ProductSorterByProducer implements Comparator<AbstractProduct> {

    @Override
    public int compare(AbstractProduct firstProduct, AbstractProduct secondProduct) {
      return firstProduct.getProducer().compareTo(secondProduct.getProducer());
    }

  }
}
