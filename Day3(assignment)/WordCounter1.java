import java.util.ArrayList;
import java.util.List;

public class WordCounter1 {
    static class WordCount {
        String word;
        int count;

        WordCount(String word) {
            this.word = word;
            this.count = 1;
        }
    }

    public static List<WordCount> countWords(String[] words, int index, List<WordCount> wordCounts) {
        if (index == words.length) {
            return wordCounts;
        }
        
        String word = words[index];
        boolean found = false;
        
        for (WordCount wc : wordCounts) {
            if (wc.word.equals(word)) {
                wc.count++;
                found = true;
                break;
            }
        }
        
        if (!found) {
            wordCounts.add(new WordCount(word));
        }
        
        return countWords(words, index + 1, wordCounts);
    }

    public static List<WordCount> countWordsRecursively(String paragraph) {
        return countWords(paragraph.split(" "), 0, new ArrayList<>());
    }

    public static void main(String[] args) {
        String paragraph = "the cat and the hat";
        List<WordCount> result = countWordsRecursively(paragraph);
        
        for (WordCount wc : result) {
            System.out.println(wc.word + ": " + wc.count);
        }
    }
}
