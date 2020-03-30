package ua.lviv.iot.storeTask.Controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.storeTask.Model.AbstractProduct;

@RequestMapping("/products")
@RestController
public class ProductController {
  
  private static Map<Integer, AbstractProduct> products = new HashMap<>();

  private static AtomicInteger idCounter = new AtomicInteger();

  @GetMapping
  public List<AbstractProduct> getProducts() {
      return new LinkedList<AbstractProduct>(products.values());
  }

  @GetMapping(path = "/{id}")
  public AbstractProduct getProduct(final @PathVariable("id") Integer productId) {
      return products.get(productId);
  }

  @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
  public AbstractProduct createProduct(final @RequestBody AbstractProduct product) {
      product.setId(idCounter.incrementAndGet());
      products.put(product.getId(), product);
      return product;
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Object> deleteProduct(final @PathVariable("id") Integer productId) {
      HttpStatus status = products.remove(productId) == null ? HttpStatus.NOT_FOUND : HttpStatus.OK;
      return ResponseEntity.status(status).build();
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<AbstractProduct> updateProduct(final @PathVariable("id") Integer productId,
          final @RequestBody AbstractProduct product) {
    HttpStatus status = products.replace(productId, product) == null? HttpStatus.NOT_FOUND : HttpStatus.OK;
      product.setId(productId);
       return ResponseEntity.status(status).build();
  }
}
