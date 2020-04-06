package ua.lviv.iot.storeTask.Controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.business.ProductService;
import ua.lviv.iot.storeTask.Model.Product;

@RequestMapping("/products")
@RestController
public class ProductController {
  
  @Autowired
  private ProductService productService;

  @GetMapping
  public List<Product> getAllProducts() {
      return productService.getAllProducts();
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<Product> getPoduct(final @PathVariable("id") Integer productId) {
      return productService.getProduct(productId);
  }

  @PostMapping
  public Product createProduct(final @RequestBody Product product) {
      return productService.createProduct(product);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Product> modifyProduct(final @PathVariable("id") Integer productId,
          final @RequestBody Product productToUpdate) {
      return productService.updateProduct(productToUpdate, productId);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Product> deleteProduct(final @PathVariable("id") Integer productId) {
      HttpStatus status = productService.deleteProduct(productId);
      return ResponseEntity.status(status).build();
  }
}
