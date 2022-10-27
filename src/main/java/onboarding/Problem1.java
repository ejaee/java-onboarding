package onboarding;

import java.util.List;

class Problem1 {

  static final int EXCEPTION = -1;
  static final int DRAW = 0;
  static final int POBIWIN = 1;
  static final int CRONGWIN = 2;


  public static int solution(List<Integer> pobi, List<Integer> crong) {
    if (isNotValidPage(pobi) || isNotValidPage(crong)) {
      return EXCEPTION;
    }

    int pobiNum = getBiggestNum(pobi);
    int crongNum = getBiggestNum(crong);

    int res = getWinner(pobiNum, crongNum);
    return res;
  }

  //  가독성, 의존성, value 값
  /*
  타당하지 않은 페이지를 확인   isNotValidPage()
  1. 허용 범위를 벗어나는가     isValidRange()
  2. 올바른 홀, 짝수인가      isValidOddEven()
  3. 두 페이지간의 차이가 1인가 isValidInterval()
  (고민중) 6번규칙의 첫페이지, 마지막페이지에 대한 고민 [1,2], [399,400]
   */
  private static boolean isNotValidPage(List<Integer> pages) {
    if (!isValidRange(pages)) {
      return (true);
    } else if (!isValidOddEven(pages)) {
      return (true);
    } else if (!isValidInterval(pages)) {
      return (true);
    }
    return false;
  }

  private static boolean isValidRange(List<Integer> pages) {
    for (int pageNumber : pages) {
      if (pageNumber < 1) {
        return false;
      } else if (pageNumber > 400) {
        return false;
      }
    }
    return true;
  }

  /*
  올바른 홀, 짝수인지 확인
  1. 왼쪽이 홀수인가
  2. 오른쪽이 짝수인가
  3. 페이지간의 차이가 1인가
  */
  private static boolean isValidOddEven(List<Integer> pages) {
    int leftPage = pages.get(0);
    int rightPage = pages.get(1);

    if (leftPage % 2 == 0) {
      return false;
    } else if (rightPage % 2 == 1) {
      return false;
    }
    return true;
  }

  private static boolean isValidInterval(List<Integer> pages) {
    int leftPage = pages.get(0);
    int rightPage = pages.get(1);

    if (rightPage - leftPage != 1) {
      return false;
    }
    return true;
  }

  private static int getBiggestNum(List<Integer> pages) {
    int BiggestNum = 0;

    for (int page : pages) {
      BiggestNum = Math.max(BiggestNum, getBiggerNum(page));
    }
    return BiggestNum;
  }

  private static int getBiggerNum(int page) {
    int biggerNum = Math.max(sumNum(page), mulNum(page));

    return biggerNum;
  }

  private static int sumNum(int page) {
    int resNum = 0;
    String pageNum = Integer.toString(page);

    for (int i = 0; i < pageNum.length(); i++) {
      resNum += pageNum.charAt(i) - '0';
    }
    return resNum;
  }

  private static int mulNum(int page) {
    int resNum = 1;
    String pageNum = Integer.toString(page);

    for (int i = 0; i < pageNum.length(); i++) {
      resNum *= pageNum.charAt(i) - '0';
    }
    return resNum;
  }

  private static int getWinner(int pobiNum, int crongNum) {
    if (pobiNum > crongNum) {
      return (POBIWIN);
    } else if (pobiNum < crongNum) {
      return (CRONGWIN);
    }
    return (DRAW);
  }
}

