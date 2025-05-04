import java.util.Scanner;

public class SimpleChecksum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();
        
        int checksum = 0;
        for (int i = 0; i < message.length(); i++) {
            checksum += message.charAt(i);
        }

        checksum = checksum % 256;

        System.out.println("Checksum: " + checksum);
        scanner.close();
    }
}
