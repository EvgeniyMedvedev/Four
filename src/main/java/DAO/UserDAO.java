package DAO;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {

    List<User> getAll() ;

    void add(User t);

    User getById(long id) ;

    void delete(long id);

    void updateUser(long idUser, String name, String surName);

    boolean validateUser(String login, String password);

    String getRole(String login, String password);

    User getUserByLoginAndPassword(String login, String password);
}
