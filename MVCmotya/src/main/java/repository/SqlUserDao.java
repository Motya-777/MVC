package repository;

import entity.User;

import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;

public class SqlUserDao implements IUserDao {
    private Connection connection = SqlConnection.getInstance().getConnection();
    private static final String INSERT_QUERY = "INSERT INTO USERS (NAME, AGE, EMAIL) VALUES (?,?,?)";
    private static final String UPDATE_QUERY = " UPDATE USERS SET NAME=?,AGE=?,EMAIL=?  WHERE ID=?";
    private static final String UPDATE_QUERY_NAME = " UPDATE USERS SET NAME = ? WHERE ID=?";
    private static final String UPDATE_QUERY_EMAIL = " UPDATE USERS SET EMAIL = ? WHERE ID=?";
    private static final String UPDATE_QUERY_AGE = " UPDATE USERS SET AGE = ? WHERE ID=?";
    private static final String DELETE_QUERY = "DELETE FROM USERS WHERE ID = ?;";
    private static final String SELECT_QUERY = "SELECT * FROM USERS WHERE ID = ?;";


    @Override
    public boolean insert(User user) {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, user.getName());
            statement.setByte(2, user.getAge());
            statement.setString(3, user.getEmail());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, user.getName());
            statement.setByte(2, user.getAge());
            statement.setString(3, user.getEmail());
            statement.setLong(4, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update_name(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_NAME)) {
            statement.setString(1, user.getName());
            statement.setLong(2, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update_age(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_AGE)) {
            statement.setByte(1, user.getAge());
            statement.setLong(2, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update_email(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY_EMAIL)) {
            statement.setString(1, user.getEmail());
            statement.setLong(2, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setLong(1, user.getId());
            if (statement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User getById(long id) {
        User user = new User();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("NAME"));
                user.setAge(resultSet.getByte("AGE"));
                user.setEmail(resultSet.getString("EMAIL"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new User();
    }

    @Override
    public boolean militaryAge(User user) {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_QUERY)) {
            statement.setLong(1, user.getId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user.getId();
                user.getAge();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public ArrayList<User> getAll() {
        return null;
    }
}
