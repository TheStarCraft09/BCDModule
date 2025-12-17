import java.util.Scanner;

public class bcd_module {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a binary number (or q to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting.");
                break;
            }

            if (!input.matches("[01]+")) {
                System.out.println("Invalid input. Use only 0 and 1.");
                continue;
            }

            bcd_module converter = new bcd_module();
            int decimal = converter.convert(Integer.parseInt(input));
            System.out.println("Decimal: " + decimal);
        }
        scanner.close();  // ✅ Nach der while-Schleife!
    }

    private int convert(int binary) {  // int statt void!
        int decimal = 0;
        int place_value = 0;

        while (binary > 0) {
            int digit = binary % 10;
            decimal += digit * Math.pow(2, place_value);
            binary /= 10;
            place_value++;
        }
        return decimal;  // ✅ Gibt die Zahl zurück!
    }
}
