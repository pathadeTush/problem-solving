public class MinFlipsForAlternateBinString_83 {

    /*
    for alternate String, there are 2 possibilities
    1. '0' occurs at even places while '1' at odd places
    2. vice versa

    for both case find misMatchedPositions and return minimum of them
     */
    public static int minFlips(String str) {
        int len = str.length();
        int minFlipsFor0AtEven = 0;
        int minFlipsFor0AtOdd = 0;

        for(int i = 0; i < len; i++) {
            if(i%2 == 0) {
                if(str.charAt(i) == '0') {
                    minFlipsFor0AtOdd++;
                } else {
                    minFlipsFor0AtEven++;
                }
            } else {
                if(str.charAt(i) == '0') {
                    minFlipsFor0AtEven++;
                } else {
                    minFlipsFor0AtOdd++;
                }
            }
        }

        return Math.min(minFlipsFor0AtEven, minFlipsFor0AtOdd);
    }

    public static void main(String[] args) {
        String str = "00010100001011";
        //00010100001011
        System.out.println(minFlips(str));
    }

}
