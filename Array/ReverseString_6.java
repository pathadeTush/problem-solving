import java.util.Scanner;

public class ReverseString_6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int len = str.length();
        String reverseStr = "";
        for(int i = len-1; i >= 0; i--) {
            reverseStr += str.charAt(i);
        }

        System.out.println(reverseStr);

        System.out.println(new StringBuffer(str).reverse());

    }

}