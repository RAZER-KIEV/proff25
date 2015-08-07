package hw8.taxi.service;

/**
 * Created by Роман on 16.07.2015.
 */
public class CheckStrings {
    private static final int LOGIN_LENGTH = 4;
    private static final int ID_LENGTH = 10;
    private static final int PASS_LENGTH = 8;
    /**
    * Checkin login: must be at least 4 symbols and does not exist empty symbols
     */
    public static boolean loginCheck(String login) {
        if(login.length()< LOGIN_LENGTH) {
            return false;
        } else if(login.indexOf(" ") >= 0) {
            return false;
        }
        return true;
    }
    /**
     * Checking identification: must be at least 10 numbers without letters and other symbols
     */
    public static boolean idCheck(String id) {

        if(id.length()<ID_LENGTH) {
            return false;
        }

        char[] charsArray = id.toCharArray();
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int matchCount;

        for(int i = 0; i<charsArray.length; i++) {
            matchCount = 0;
            for(int j = 0; j<numbers.length; j++) {
                if(charsArray[i] == numbers[j]) {
                    matchCount++;
                }
            }
            if(matchCount == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checking password: must be at least 8 characters, includes upper and lowercase letters ans numbers
     */
    public static boolean passCheck(String password) {
        if(password.length()<PASS_LENGTH) {
            return false;
        }

        if(password.equals(password.toLowerCase())) {
            return false;
        }
        if(password.equals(password.toUpperCase())) {
            return false;
        }

        char[] charsArray = password.toCharArray();
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int matchCount = 0;
        for(int i = 0; i<charsArray.length; i++) {
            for(int j = 0; j<numbers.length; j++) {
                if(charsArray[i] == numbers[j]) {
                    matchCount++;
                }
            }
        }
        if(matchCount == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(passCheck("kvnrjMNB123123"));
    }
}
