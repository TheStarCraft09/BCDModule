import java.util.Scanner;

public class bcd_module {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("What do you want to do? ");
            System.out.println("Convert Hexadecimal (press h)");
            System.out.println("Convert Binary (press b)");
            System.out.println("Quit (press q)");
            String selector_input = scanner.nextLine();

            if (selector_input.equalsIgnoreCase("h")) {     //Converts Hex to decimal
                while (true) {
                    System.out.print("Enter a hexadecimal number or quit to menu(q): ");
                    String hexInput = scanner.nextLine();
                    if (hexInput.equalsIgnoreCase("q")) {
                        break;
                    }
                    if (!hexInput.matches("[0-9a-fA-F]+")) {
                    System.out.println("Invalid hexadecimal input. Use digits 0-9 and letters A-F.");
                    continue;
                }
                bcd_module converter = new bcd_module();
                int decimal = converter.convertHex(hexInput);
                System.out.println("Decimal: " + decimal);
                }

            }
            else if (selector_input.equalsIgnoreCase("b")) {        //Converts Binary to decimal
               while(true) {
                    System.out.print("Enter a binary number or quit to menu(q): ");
                    String binInput = scanner.nextLine();
                    if (binInput.equalsIgnoreCase("q")) {
                        break;
                    }
                    if (!binInput.matches("[01]+")) {
                        System.out.println("Invalid binary input. Use only 0 and 1.");
                        continue;
                    }
                   bcd_module converter = new bcd_module();
                   int decimal = converter.convert(Integer.parseInt(binInput));
                   System.out.println("Decimal: " + decimal);
               }

            }
            else if (selector_input.equalsIgnoreCase("q")) {        //Quits the program
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private int convert(int binary) {       //Basic binary to decimal conversion
        int decimal = 0;
        int place_value = 0;

        while (binary > 0) {
            int digit = binary % 10;
            decimal += digit * Math.pow(2, place_value);
            binary /= 10;
            place_value++;
        }
        return decimal;
    }

    private int convertHex(String hexInput) {   //Hexadecimal to decimal conversion
        int decimal = 0;

        for (int i = 0; i < hexInput.length(); i++) {
            char temp = hexInput.charAt(i);

            int nibbleValue = switch(Character.toUpperCase(temp)) {
                case '0' -> 0;
                case '1' -> 1;
                case '2' -> 2;
                case '3' -> 3;
                case '4' -> 4;
                case '5' -> 5;
                case '6' -> 6;
                case '7' -> 7;
                case '8' -> 8;
                case '9' -> 9;
                case 'A' -> 10;
                case 'B' -> 11;
                case 'C' -> 12;
                case 'D' -> 13;
                case 'E' -> 14;
                case 'F' -> 15;
                default -> 0;
            };

            decimal += nibbleValue * (int)Math.pow(16, hexInput.length() - 1 - i);
        }
        return decimal;
    }
}
