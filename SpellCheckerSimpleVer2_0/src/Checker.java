public class Checker {
    public static void main(String[] args) {
        Dictionary.load();
        System.out.println(Dictionary.checkWord("woolf"));
    }


    public static int numberOfChanges(String wordToCheck, String dictionaryWord) {
        int[] numberOfChangesForDictionaryWord = new int[dictionaryWord.length() + 1];             //Damerau-Levenshtein distance
        int[] numberOfChangesForWordToCheck = new int[dictionaryWord.length() + 1];

        for (int j = 0; j <= dictionaryWord.length(); j++) {
            numberOfChangesForWordToCheck[j] = j; // (i == 0)
        }

        for (int i = 1; i <= wordToCheck.length(); i++) {
            System.arraycopy(numberOfChangesForWordToCheck, 0, numberOfChangesForDictionaryWord, 0, numberOfChangesForDictionaryWord.length);

            numberOfChangesForWordToCheck[0] = i; // (j == 0)
            for (int j = 1; j <= dictionaryWord.length(); j++) {
                int cost = (wordToCheck.charAt(i - 1) != dictionaryWord.charAt(j - 1)) ? 1 : 0;
                numberOfChangesForWordToCheck[j] = min(
                        numberOfChangesForDictionaryWord[j] + 1,
                        numberOfChangesForWordToCheck[j - 1] + 1,
                        numberOfChangesForDictionaryWord[j - 1] + cost
                );
            }
        }

        return numberOfChangesForWordToCheck[numberOfChangesForWordToCheck.length - 1];
    }

    private static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }
}