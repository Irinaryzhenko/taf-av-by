package utils.vincode;

import java.util.Random;

public class Generator {
    public static String generateValidFormatVinCode() {
        Random random = new Random();
        StringBuilder vin = new StringBuilder();
        // Генерация World Manufacturer Identifier
        for (int i = 0; i < 3; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            vin.append(randomChar);
        }
        // Генерация Vehicle Descriptor Section
        for (int i = 0; i < 5; i++) {
            int randomDigit = random.nextInt(10);
            vin.append(randomDigit);
        }
        // Генерация Vehicle Identifier Section
        for (int i = 0; i < 8; i++) {
            char randomChar = (char) (random.nextInt(26) + 'A');
            vin.append(randomChar);
        }
            vin.append(calculateCheckDigit(vin.toString()));
        return vin.toString();
    }

    private static char calculateCheckDigit(String vinPartial) {
        int total = 0;
        String vinChars = "0123456789X";
        int[] weights = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

        for (int i = 0; i < vinPartial.length(); i++) {
            char c = vinPartial.charAt(i);
            int value = vinChars.indexOf(c);
            total += value * weights[i];
        }

        int remainder = total % 11;
        return remainder == 10 ? 'X' : (char) ('0' + remainder);
    }

        public static String generateInvalidNumberCharactersVinCode() {
        int length = 16;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] vinCode = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            vinCode[i] = characters.charAt(index);
        }
        return new String(vinCode);
    }
    public static String generateInvalidCharactersInVinCode() {
        int length = 17;
        String characters = ")(?!.:БЮФЫоалы+-ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] vinCode = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            vinCode[i] = characters.charAt(index);
        }
        return new String(vinCode);
    }
}
