package WordCounterProject;

public class WordCounterConsole {
    public static int wordCount(String str) {
        if (str == null || str.isEmpty())
            return 0;

        String[] words = str.trim().split("\\s+");
        return words.length;
    }
    public static int characterCount(String str) {
        if (str == null || str.isEmpty())
            return 0;

        return str.length();
    }
}
