public class Word implements Comparable<Word> {

    private final String word;
    private final int numberOfChanges;

    public Word(String word, int numberOfChanges) {
        this.word = word;
        this.numberOfChanges = numberOfChanges;
    }

    public String getWord() {
        return word;
    }

    public int getNumberOfChanges() {
        return numberOfChanges;
    }

    public int compareTo(Word anotherWord) {
        int result = Integer.compare(this.numberOfChanges, anotherWord.numberOfChanges);
        if (result != 0) {
            return result;
        }

        result = this.word.compareTo(anotherWord.word);

        return result;
    }


}
