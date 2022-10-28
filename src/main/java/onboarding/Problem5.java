package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Problem5 {
//    if (!isNotValidMoney(money)) {
//        return money;
//    }

    private static final List<Integer> MONETARY_UNITS = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        for (int monetaryUnit : MONETARY_UNITS) {
            answer.add(money / monetaryUnit);
            money %= monetaryUnit;
        }
        return answer;
    }
}
