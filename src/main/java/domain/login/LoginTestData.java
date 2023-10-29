package domain.login;

import java.security.SecureRandom;
import java.util.Random;

public class LoginTestData {
    private final static String VALID_LOGIN = "irisha_box@mail.ru";
    private final static String VALID_PASSWORD = "qatestteam12";
    public static String getValidLogin() {
        return VALID_LOGIN;
    }
    public static String getValidPassword() {
        return VALID_PASSWORD;
    }

    public static String generatePassword() {
        Random random = new SecureRandom();
        final String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String digits = "0123456789";
        final String specialCharacters = "!@#$%&*";
        final String allCharacters = letters + digits + specialCharacters;

        int length = random.nextInt(9) + 8;
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            char randomCharacter = allCharacters.charAt(randomIndex);
            password.append(randomCharacter);
        }
        return password.toString();
    }

    public static String generateLogin() {
        int length = 10;
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        char[] nickname = new char[length];

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            nickname[i] = characters.charAt(index);
        }
        return new String(nickname);
    }
}
