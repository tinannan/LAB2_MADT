package textUtils;

public class TextCounter {
    public static int getCharsCount(String userPhase){
        return userPhase.length();
    }
    public static int getWordsCount(String userPhrase) {
        String[] words = userPhrase.trim().split("[\\s,.]+");
        return words.length;
    }
}
