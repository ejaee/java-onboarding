package onboarding;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

public class Problem4 {
    private static final int UPPERCASE_NUMBER = 155;
    private static final int LOWERCASE_NUMBER = 219;
    public static String solution(String word) {
        if (isNotValidWord(word)) {
            return word;
        }
        return modifyString(word);
    }
    private static boolean isNotValidWord(String word) {
        return word.length() == 0 || 1000 < word.length();
    }
    private static String modifyString(String word) {
        char[] resultWord = word.toCharArray();
        for (int i = 0; i < resultWord.length; i++) {
            resultWord[i] = modifychar(resultWord[i]);
        }
        return String.valueOf(resultWord);
    }
    private static char modifychar(char ch) {
        if (isUpperCase(ch)) {
            return (char)(UPPERCASE_NUMBER - ch);

        }
        else if (isLowerCase(ch)) {
            return (char)(LOWERCASE_NUMBER - ch);
        }
        return (ch);
    }
}
