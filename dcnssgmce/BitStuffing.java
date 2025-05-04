import java.util.Scanner;

public class BitStuffing {

    public static String bitStuff(String data) {
        StringBuilder stuffedData = new StringBuilder();
        int count = 0;

        for (int i = 0; i < data.length(); i++) {
            char bit = data.charAt(i);
            stuffedData.append(bit);

            if (bit == '1') {
                count++;
                if (count == 5) {
                    // Stuff a 0 after five consecutive 1's
                    stuffedData.append('0');
                    count = 0;  // reset count
                }
            } else {
                count = 0;  // reset count if bit is 0
            }
        }

        return stuffedData.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter binary data (e.g., 01111110): ");
        String data = sc.nextLine();

        String stuffed = bitStuff(data);
        System.out.println("Bit Stuffed Data: " + stuffed);
    }
}