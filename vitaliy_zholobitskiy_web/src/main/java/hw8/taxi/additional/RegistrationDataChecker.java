package hw8.taxi.additional;

/**
 * Created by just1ce on 15.07.2015.
 */
public class RegistrationDataChecker {
    public boolean isValid(String login,String pass, String confirm_pass){
        return checkLogin(login)&&isEqualPass(pass,confirm_pass)&&checkPass(pass);
    }
    private static boolean checkLogin(String login){
        return !(login.length()<4 || login.contains(" "));
    }
    private static boolean isEqualPass(String pass, String confirm_pass){
        return pass.equals(confirm_pass) ;
    }

    public static boolean checkPass(String pass){
        return ((!(pass.length()<8))&&(pass.matches(".*\\d.*"))&&(pass.matches(".*[A-Z].*"))&&(pass.matches(".*[a-z].*")));
    }

}
