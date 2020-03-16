package ua.lviv.iot.storeTask.Manager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;


public class StoreManagerReader {
  public static List<String> readLinesFromFile(String path) {
    List<String> lines = new LinkedList<>();
    try (BufferedReader bufferedReader = new BufferedReader(
        new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
      String currentLine;
      while ((currentLine = bufferedReader.readLine()) != null) {
        lines.add(currentLine);
      }
    } catch (IOException error) {
      System.out.println("Error while reading file!");
      error.printStackTrace();
    }
    return lines;
  }
}
