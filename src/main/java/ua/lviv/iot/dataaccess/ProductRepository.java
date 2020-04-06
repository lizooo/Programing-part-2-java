package ua.lviv.iot.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.iot.storeTask.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
