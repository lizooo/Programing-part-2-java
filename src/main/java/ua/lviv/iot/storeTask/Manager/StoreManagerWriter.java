package ua.lviv.iot.storeTask.Manager;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import ua.lviv.iot.storeTask.Model.AbstractProduct;

public class StoreManagerWriter {
  private Writer writer;

  public void setWriter(final Writer writer) {
    this.writer = writer;
  }

  public void writeToFile(List<AbstractProduct> products) throws IOException {
    try {
    for (AbstractProduct currentProduct : products) {
      writeLine(this.writer, currentProduct.getHeaders());
      writeLine(this.writer, currentProduct.toCSV());
    }
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally{
    this.writer.close();
    this.writer.flush();
  }
  }

  private void writeLine(Writer writer, String line) throws IOException {
    writer.write(line + "\n");
  }

  @Override
  public String toString() {
    return this.writer.toString();
  }
}
