package session2;

import java.util.Comparator;

/**
 * Created by nucleos on 19.05.15.
 */
public class UsersByDays implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getPassword().compareTo(user2.getPassword());
    }
}
