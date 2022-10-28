package onboarding;

import java.util.*;

public class Problem6 {
  public static List<String> solution(List<List<String>> forms) {
    return getAnswer(forms);
  }

  private static List<String> getAnswer(List<List<String>> forms) {
    Map<String, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();

    makeMap(map, forms);
    for (String nickName : map.keySet()) {
      if (isDuplicated(nickName, map)) {
        set.add(map.get(nickName));
      }
    }
    return makeSort(set);
  }
  private static void makeMap(Map<String, String> map, List<List<String>> forms) {
    for (List<String> form : forms) {
      map.put(form.get(1), form.get(0));
    }
  }
  private static boolean isDuplicated(String nickName, Map<String, String> map) {
    if (nickName.length() < 2)
      return false;
    for (String nickName2 : map.keySet()) {
      return isMatchTwoWord(nickName, nickName2);
    }
    return false;
  }
  private static boolean isMatchTwoWord(String str1, String str2) {
    for (int i = 0; i < str2.length()-2; i++) {
      if (str1.contains(str2.substring(i, i+2)))
        return true;
    }
    return false;
  }
  private static List<String> makeSort(Set<String> set) {
    List<String> answer = new ArrayList(set);
    Collections.sort(answer);
    return answer;
  }
}
