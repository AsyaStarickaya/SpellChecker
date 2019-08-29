import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dictionary {
   static Set<String> dictionary = new HashSet<>();

    public static List<String> checkWord(String input) {
        CheckerResults checkerResults = new CheckerResults();

        if (dictionary.contains(input)) {
            return checkerResults.returnResult();
        }

        for (String s : dictionary
        ) {
            int numberOfChanges = Checker.numberOfChanges(input, s);
            checkerResults.addWord(s, numberOfChanges);

        }

        return checkerResults.returnResult();
    }

     static void  load (){


        try (BufferedReader br = new BufferedReader(new FileReader("C:/java/en-2012/en.txt"))) {

            String tempStorage;
            while ((tempStorage = br.readLine()) != null) {

                dictionary.add(tempStorage.replaceAll("[0-9]", "").trim());
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }




    }
}
