package onboarding;

import java.util.regex.Pattern;

public class Problem2 {

  private static boolean duplicateFlag;
  private static int STRING_MIN_LENGTH = 1;
  private static int STRING_MAX_LENGTH = 1000;
  private static int start;
  private static int end;

  public static String solution(String cryptogram) {
    validityChecker(cryptogram);

    return modifyString(cryptogram);
  }

  private static void validityChecker(String cryptogram) {
    if (isNotValidCryptogram(cryptogram)) {
      throw new IllegalArgumentException("Not valid cryptogram");
    }
  }
  /**
   * 알맞은 매개변수가 전달되었는지 확인
   *
   * @param cryptogram
   * @return true/ false
   */
  private static boolean isNotValidCryptogram(String cryptogram) {
    return !isValidLength(cryptogram) || !isVaildCompo(cryptogram);
  }

  private static boolean isValidLength(String cryptogram) {
    int stringLength = cryptogram.length();

    return STRING_MIN_LENGTH <= stringLength && stringLength <= STRING_MAX_LENGTH;
  }

  private static boolean isVaildCompo(String cryptogram) {
    return Pattern.matches("^[a-z]*$", cryptogram);
  }

  /**
   * 중복 문자를 삭제 중복 문자의 유/무에 따라 flag의 값이 true/false
   *
   * @param cryptogram
   * @return modifyCryptogram
   */
  private static String modifyString(String cryptogram) {
    duplicateFlag = true;
    StringBuilder sb = new StringBuilder(cryptogram);

    while (duplicateFlag) {
      duplicateFlag = false;
      getIndex(sb.toString());
      if (duplicateFlag) {
        sb.delete(start, end + 1);
      }
    }
    return sb.toString();
  }

  private static void getIndex(String str) {
    char preCh = 0;

    for (int i = 0; i < str.length() - 1; i++) {
      if (!duplicateFlag && str.charAt(i) == str.charAt(i + 1)) {
        duplicateFlag = true;
        start = i;
        preCh = str.charAt(i);
      } else if (duplicateFlag && preCh != str.charAt(i + 1)) {
          break;
      }
      end = i + 1;
    }
  }
}
