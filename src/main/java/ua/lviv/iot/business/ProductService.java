package ua.lviv.iot.business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.dataaccess.ProductRepository;
import ua.lviv.iot.storeTask.Model.Product;


@Service 
public class ProductService {
  
  @Autowired
  private ProductRepository productRepository;

  public Product createProduct(Product product) {
      return productRepository.save(product);
  }

  public ResponseEntity<Product> getProduct(Integer productId) {
      if(productRepository.existsById(productId)) {
          Product selectedProduct = productRepository.findById(productId).get();
          return new ResponseEntity<Product>(selectedProduct,HttpStatus.OK);
      } else {
          return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
      }
  }

  public ResponseEntity<Product> updateProduct(Product productToUpdate, Integer productId) {
      if (productRepository.existsById(productId)) {
          productToUpdate.setProductId(productId);
          Product updatedProduct = productRepository.save(productToUpdate);
          return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
      } else {
          return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
      }
  }

  public List<Product> getAllProducts() {
      return productRepository.findAll();
  }

  public HttpStatus deleteProduct(Integer productId) {
      if (productRepository.existsById(productId)) {
          productRepository.deleteById(productId);
          return HttpStatus.OK;
      } else {
          return HttpStatus.NOT_FOUND;
      }
  }
}
