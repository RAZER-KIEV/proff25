package session2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Sveta on 5/19/2015.
 * ������� ����� ������������:
 * �����
 * ������
 * ����� ��������� �������� ������(���������� ����)
 * �����(����� � ������)
 * ��������� ������������� ������������ ��� ���
 *
 *
 */
public class UserMain {

    HashSet<User> userSet = new HashSet<>();

    public static void main(String[] args) {



    }

    public boolean check(String name, String password){
        User user = new User(name, password);

        if(userSet.contains(user)) {
            return true;
        }
        else{
            return  false;
        }

    }



}
 