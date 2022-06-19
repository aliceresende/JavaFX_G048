package app.domain.model;

import java.util.Random;

public class PasswordGenerator {
  private static final String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
  private static final String NUM = "0123456789";
  final static int numberOfAlphanumericalDigits = 7;
  final static int numberOfCapitalLetters = 3;
  final static int numberOfDigits = 2;

  /**
   * Generate a password with seven alphanumeric characters,
   * including three capital letters and two digits.
   * @return the generated password
   */
  public static String generatePassword() {

    Random rnd = new Random();
    char[] pass = new char[numberOfAlphanumericalDigits];
    int index = 0;
    for (int i = 0; i < numberOfCapitalLetters; i++) {
      index = getNextIndex(rnd, numberOfAlphanumericalDigits, pass);
      pass[index] = ALPHA_CAPS.charAt(rnd.nextInt(ALPHA_CAPS.length()));
    }
    for (int i = 0; i < numberOfDigits; i++) {
      index = getNextIndex(rnd, numberOfAlphanumericalDigits, pass);
      pass[index] = NUM.charAt(rnd.nextInt(NUM.length()));
    }
    for(int i = 0; i < numberOfAlphanumericalDigits; i++) {
      if(pass[i] == 0) {
        pass[i] = ALPHA.charAt(rnd.nextInt(ALPHA.length()));
      }
    }
    String finalPassword = String.valueOf(pass);
    return finalPassword;
  }


  private static int getNextIndex(Random rnd, int length, char[] pass) {
    int index = rnd.nextInt(length);
    while(pass[index = rnd.nextInt(length)] != 0);
    return index;
  }
}