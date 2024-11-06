import java.util.List;
import java.util.Iterator;

public class Scramble {

    public static String scrambleWord(String word) {
        StringBuilder scrambled = new StringBuilder(word);

        for (int i = 0; i < scrambled.length() - 1; i++) {
            if (scrambled.charAt(i) == 'A' && scrambled.charAt(i + 1) != 'A') {
                char temp = scrambled.charAt(i);
                scrambled.setCharAt(i, scrambled.charAt(i + 1));
                scrambled.setCharAt(i + 1, temp);
                i++;
            }
        }

        return scrambled.toString();
    }

    public static void scrambleOrRemove(List<String> wordList) {
        Iterator<String> iterator = wordList.iterator();

        while (iterator.hasNext()) {
            String originalWord = iterator.next();
            String scrambledWord = scrambleWord(originalWord);

            if (originalWord.equals(scrambledWord)) {
                iterator.remove();
            } else {
                wordList.set(wordList.indexOf(originalWord), scrambledWord);
            }
        }
    }
}