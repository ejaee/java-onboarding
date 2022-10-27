package onboarding;

public class Problem3 {
    private static final int NUMBER_THREE = 3;
    private static final int NUMBER_SIX = 6;
    private static final int NUMBER_NINE = 9;

    public static int solution(int number) {
        if (isNotValidNumber(number))
            return 0;
        return getClapNumber(number);
    }
    private static boolean isNotValidNumber(int number) {
        return number < 1 || 10000 < number;
    }
    private static int getClapNumber(int number) {
        int clapNumber = 0;

        for (int i = 1; i <= number; i++) {
             clapNumber += countClap(i);
        }
        return clapNumber;
    }
    private static int countClap(int number) {
        int clapNumber = 0;

        while (number != 0) {
            if (isClapNumber(number % 10)) {
                ++clapNumber;
            }
            number /= 10;
        }
        return clapNumber;
    }
    private static boolean isClapNumber(int number) {
        return number == NUMBER_THREE || number == NUMBER_SIX || number == NUMBER_NINE;
    }
}
