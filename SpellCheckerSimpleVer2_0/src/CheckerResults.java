import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class CheckerResults {

    TreeSet<Word> wordsForCorrection;

    public CheckerResults() {
        this.wordsForCorrection = new TreeSet<>();
    }

    public void addWord(String someWord, int numberOfChanges) {
        Word wordFromDictionary = new Word(someWord, numberOfChanges);
        wordsForCorrection.add(wordFromDictionary);

        if (wordsForCorrection.size() > 5) {
            wordsForCorrection.pollLast();
        }
    }

    public List<String> returnResult() {
        List<String> arrayOfWords = new ArrayList<>();
        for (Word i : wordsForCorrection
        ) {
            arrayOfWords.add(i.getWord());

        }
        return arrayOfWords;
    }
}
