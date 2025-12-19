public class converter_blueJ {
        public static void main(String[] args) {

        }

        public void convert(int binary) {
            int decimal = 0;
            int place_value = 0;

            while (binary > 0) {
                int digit = binary % 10;
                decimal += digit * Math.pow(2, place_value);
                binary /= 10;
                place_value++;
            }
            System.out.println(decimal);
        }
    }

}
