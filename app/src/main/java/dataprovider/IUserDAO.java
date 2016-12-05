package dataprovider;

import java.util.List;

import domain.User;

/**
 * Created by João Vinaud on 04/12/2016.
 */

public interface IUserDAO {

    public List<User> getUsers();
    public void addUser(User user);
}
