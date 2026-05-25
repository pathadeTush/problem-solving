/**
 * https://leetcode.com/problems/count-numbers-with-unique-digits/description/
 */
public class CountNumbersWithUniqueDigits_357 {

    /*
    Think all possible choice for unique numbers of n digits;

    For e.g, for 2 digit
    choice1 : first digit is not 0 = (9c1x9c1)
    choice2: first digit is 0 = (1c1x9c1)
    choice2: both digit is 0 = (1c1x1c1)
    total unique = 81+9+1 = 91
     */
//    public static int countNumbersWithUniqueDigits(int n) {
//        int maxDigit = n;
//        int totalUniqueDigits = 0;
//        for(int preceedingDigitZeroCount = 0; preceedingDigitZeroCount <= maxDigit; preceedingDigitZeroCount++) {
//            int digitLeft = n-preceedingDigitZeroCount;
//            boolean canZeroBeUsed = false;
//            int digitChoices = 9;
//            int uniqueDigits = 1;
//            while (digitLeft > 0) {
//                uniqueDigits *= digitChoices;
//                if(!canZeroBeUsed) {
//                    canZeroBeUsed = true;
//                } else {
//                    digitChoices--;
//                }
//                digitLeft--;
//            }
//            totalUniqueDigits += uniqueDigits;
//        }
//
//        return totalUniqueDigits;
//    }

    /*
    for n = 1, choices for digit = first digit can be non zero OR first digit is 0 = 9+1
    for n = 2, choices = first digit non zero + first digit zero + all digit zero = 9x9 + 1x9 + 1x1
    for n = 3, choices = first digit non zero + first digit zero + first 2 digit non zero + all digit zero = 9x9x8 + 1x9x9 + 1x1x9 + 1x1x1

    thus, f(n) =  x + f(n-1)
    we need to calculate x only.
     */

    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }

        int prod = 9;
        int digitChoiceLeft = 9;
        int prev = 10;
        for(int i = 2; i <= n; i++) {
            prod *= digitChoiceLeft;
            int totalUniqueDigits = prod + prev;
            prev = totalUniqueDigits;
            digitChoiceLeft--;
        }

        return prev;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(CountNumbersWithUniqueDigits_357.countNumbersWithUniqueDigits(n));
    }

}
