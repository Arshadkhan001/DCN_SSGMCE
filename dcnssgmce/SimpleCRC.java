import java.util.Scanner;

public class SimpleCRC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter data bits: ");
        String data = sc.nextLine();

        System.out.print("Enter divisor (generator): ");
        String divisor = sc.nextLine();

        String dividend = data + "0".repeat(divisor.length() - 1);
        String remainder = getRemainder(dividend, divisor);

        String codeword = data + remainder;

        System.out.println("CRC Remainder: " + remainder);
        System.out.println("Transmitted Codeword: " + codeword);
    }

    static String getRemainder(String dividend, String divisor) {
        int len = divisor.length();
        String temp = dividend.substring(0, len);

        for (int i = len; i <= dividend.length(); i++) {
            if (temp.charAt(0) == '1')
                temp = xor(temp, divisor);
            else
                temp = xor(temp, "0".repeat(len));

            if (i < dividend.length())
                temp = temp.substring(1) + dividend.charAt(i);
            else
                temp = temp.substring(1);
        }

        return temp;
    }

    static String xor(String a, String b) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++)
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        return result.toString();
    }
}
