package service;
import dao.UserDAO;
import model.User;
import util.UserDaoFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Service {

    private UserDAO userDao = UserDaoFactory.getUserDAO();


    private static Service service;

    public Service() throws IOException {
    }


    public static Service getInstance() throws IOException {
        if (service == null){
            service = new Service();
        }
        return service;
    }

    public User findUser(long id) throws SQLException {
        return userDao.findUser(id);
    }

    public void saveUser(User user) throws SQLException {
        userDao.saveUser(user);
    }

    public void deleteUser(User user) throws SQLException {
        userDao.deleteUser(user);
    }

    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User getUser(String name, String pass) throws SQLException {

        return userDao.getUserDao(name, pass);
    }



}
