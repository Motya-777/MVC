package service;

import entity.User;
import repository.IUserDao;
import repository.SqlUserDao;

public class UserService implements IUserService {
    private IUserDao dao = new SqlUserDao();

    @Override
    public String insert(String name, Byte age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        if (dao.insert(user)) {
            return "User add in system!";
        } else {
            return "Error with insert user!";
        }
    }

    @Override
    public String delete(long id) {
        User user = new User();
        user.setId(id);
        if (dao.delete(user)) {
            return "User delete!";
        } else {
            return "Error with delete user!";
        }
    }

    @Override
    public String getUser(long id) {
        User user = dao.getById(id);
        if (user.equals(new User())) {
            return "User not found!";
        } else {
            return dao.getById(id).toString();
        }
    }

    @Override
    public String update(long id, String name, Byte age, String email) {
        if (name == null || id == 0 || age == null || email == null) {
            return "User name or id or age or email is null!";
        } else {
            User user = new User();
            user.setId(id);
            user.setName(name);
            user.setAge(age);
            user.setEmail(email);
            if (dao.update(user)) {
                return "User update!";
            } else {
                return "Error with update user!";
            }
        }
    }

//    @Override
//    public Boolean militaryAge(long id, Byte age) {
//        if (age > 18 && age < 27)
//            return true;
//        else {
//            return false;
//        }
//    }


    @Override
    public String update_name(long id, String name) {
        if (name == null || id == 0) {
            return "User name or id is null!";
        } else {
            User user = new User();
            user.setId(id);
            user.setName(name);
            if (dao.update_name(user)) {
                return "User name update!";
            } else {
                return "Error with update user!";
            }
        }
    }

    @Override
    public String update_age(long id, Byte age) {
        if (age == null || id == 0) {
            return "User age or id is null!";
        } else {
            User user = new User();
            user.setId(id);
            user.setAge(age);
            if (dao.update_age(user)) {
                return "User age update!";
            } else {
                return "Error with update user!";
            }
        }
    }

    @Override
    public String update_email(long id, String email) {
        if (email == null || id == 0) {
            return "User email or id is null!";
        } else {
            User user = new User();
            user.setId(id);
            user.setEmail(email);
            if (dao.update_email(user)) {
                return "User email update!";
            } else {
                return "Error with update user!";
            }
        }
    }
}