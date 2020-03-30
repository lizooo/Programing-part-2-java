package ua.lviv.iot.storeTask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.storeTask.Manager.StoreManagerWriter;
import ua.lviv.iot.storeTask.Model.AbstractProduct;

public class StoreManagerReaderAndWriterTest extends StoreManagerTest {


  private static final String OUTPUT_PATH = "products.csv";
  private StoreManagerWriter writer;

  @BeforeEach
  public void setUp() {
    super.setUp();
    this.writer = new StoreManagerWriter();
  }

  @Test
  void testHomeApplianceWriter() {
    try (Writer fileWriter = new FileWriter(OUTPUT_PATH);) {
      this.writer.setWriter(fileWriter);
      this.writer.writeToFile(storeManager.getAllAbstractProducts());
    } catch (IOException e) {
      System.out.println("Error while writing to file!");
      e.printStackTrace();
    }
  }

  @Test
  void testHomeApplianceWriterToString() {
    List<AbstractProduct> homeAppliances = storeManager.getAllAbstractProducts();

    try (Writer expectedWriter = new StringWriter()) {
      this.writer.setWriter(expectedWriter);
      this.writer.writeToFile(homeAppliances);
    } catch (IOException e) {
      e.printStackTrace();
    }

    StringBuilder expectedString = new StringBuilder();
    for (AbstractProduct currentAbstractProduct : products) {
      expectedString.append(currentAbstractProduct.getHeaders()).append("\n")
          .append(currentAbstractProduct.toCSV()).append("\n");
    }

    assertEquals(expectedString.toString(), this.writer.toString());
  }
}

