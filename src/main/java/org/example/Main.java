package org.example;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {

      File file = new File("input.txt");
      String text=FileUtils.readFileToString(file,"UTF-8");

      text=StringUtils.lowerCase(text);
      text=StringUtils.replaceChars(text,"!.,;?:'\"-()[]{}", " ");

      Set<String> uniqueWords = new HashSet<>(StringUtils.countMatches(text, " ")+1);
      for(String word : StringUtils.split(text, " ")){
          uniqueWords.add(word);
      }

      File outputFile = new File("output.txt");
      FileUtils.writeStringToFile(outputFile, "Number of unique words: " + uniqueWords.size(),"UTF-8");
    }
}