import java.util.HashMap;
import java.util.Map;

public class MobileKeypad_75 {

    public static String printSequence(String s)
    {
        Map<Character, Integer> code = new HashMap<>();
        code.put(' ', 0);
        code.put('A', 2);
        code.put('B', 22);
        code.put('C', 222);
        code.put('D', 3);
        code.put('E', 33);
        code.put('F', 333);
        code.put('G', 4);
        code.put('H', 44);
        code.put('I', 444);
        code.put('J', 5);
        code.put('K', 55);
        code.put('L', 555);
        code.put('M', 6);
        code.put('N', 66);
        code.put('O', 666);
        code.put('P', 7);
        code.put('Q', 77);
        code.put('R', 777);
        code.put('S', 7777);
        code.put('T', 8);
        code.put('U', 88);
        code.put('V', 888);
        code.put('W', 9);
        code.put('X', 99);
        code.put('Y', 999);
        code.put('Z', 9999);

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            ans.append(code.get(s.charAt(i)));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(printSequence("HEY U"));
    }

}
