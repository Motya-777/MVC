package repository;

import entity.User;

import java.util.ArrayList;

public interface IUserDao {
    boolean insert(User user);
    boolean update(User user);
    boolean update_name(User user);
    boolean update_age(User user);
    boolean update_email(User user);
    boolean delete(User user);
    boolean militaryAge(User user);

    User getById(long id);

    ArrayList<User> getAll();
}
