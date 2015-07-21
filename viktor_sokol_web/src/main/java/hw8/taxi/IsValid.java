package hw8.taxi;

/**
 * Created by storo_000 on 10.07.2015.
 */
public class IsValid {
    public static boolean isValidId(String string){
        if (string.length()!=10) return false;
        for (int i=0;i<string.length();i++){
            if (!Character.isDigit(string.charAt(i)))
                return false;
        }
        return true;
    }

    public static boolean isValidPassword(String pass){
        if (pass.length()<8) return false;
        boolean flag = false;
        for (int i=0;i<pass.length();i++){
            if (Character.isDigit(pass.charAt(i)))
            {
                flag = true;
                break;
            }
        }
        if (!flag) return false;
        flag = false;
        for (int i=0;i<pass.length();i++){
            if (Character.isLowerCase(pass.charAt(i)))
            {
                flag = true;
                break;
            }
        }
        if (!flag) return false;
        flag = false;
        for (int i=0;i<pass.length();i++){
            if (Character.isUpperCase(pass.charAt(i)))
            {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static boolean isValidLogin(String login){
        return !(login.length() < 4 || login.contains(" "));
    }
}
