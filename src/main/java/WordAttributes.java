import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WordAttributes{

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("Error occurred. Please enter two arguments.");
      return;
    }

    String inputFile = args[0];
    String outputFile = args[1];

    Scanner scanner = new Scanner(new File(inputFile));
    PrintWriter writer = new PrintWriter(outputFile);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().toLowerCase();


      String s=line;
      s=s+":";
      if (isAbecedarian(line)) {
        s=s+" abecedarian";
      }
      if (isDoubloon(line)) {
        s=s+" doubloon";
      }

      writer.println(s);
    }
    writer.close();
    scanner.close();

  }



  private static boolean isAbecedarian(String word) {
    for (int i = 0; i < word.length() - 1; i++) {
      if (word.charAt(i) > word.charAt(i + 1)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isDoubloon(String word) {
    int[] charCount = new int[26];

    // Count occurrences of each character
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int index = c - 'a';
      charCount[index]++;
      if (charCount[index] > 2) {
        return false;
      }
    }

    // Check if each character appears exactly twice
    for (int i = 0; i < charCount.length; i++) {
      int count = charCount[i];
      if (count != 0 && count != 2) {
        return false;
      }
    }

    return true;
  }

}
