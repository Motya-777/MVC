package service;

public interface IUserService {
    String insert(String name, Byte age, String email);

    String delete(long id);

    String getUser(long id);

    String update(long id, String name,Byte age,String email);

   // String militaryAge(boolean army);

    //Boolean militaryAge(long id, Byte age);

    String update_name(long id, String name);

    String update_age(long id, Byte age);

    String update_email(long id, String email);


}
