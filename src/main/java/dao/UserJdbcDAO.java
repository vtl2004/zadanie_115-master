package dao;

import model.User;
import util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserJdbcDAO implements UserDAO{
    private Connection connection;

    public UserJdbcDAO(Connection connection) {
        this.connection = connection;
    }
    private static UserJdbcDAO userJdbcDAO;
    public static UserJdbcDAO getInstance(){
        if (userJdbcDAO == null){
            userJdbcDAO = new UserJdbcDAO(DBHelper.getInstance().getConnection());
        }
        return userJdbcDAO;
    }

    @Override
    public List<User> findAllUsers() {
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM db_example.users_role";
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String password = rs.getString("password");
                String role = rs.getString("role");
                userList.add(new User(id, name, password, age, role));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        String name = user.getName();
        String password = user.getPassword();
        int age = user.getAge();
        String role = user.getRole();
        String sql = "INSERT INTO db_example.users_role (name, password, age, role) Values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        connection.setAutoCommit(true);
        statement.setString(1, name);
        statement.setString(2, password);
        statement.setInt(3, age);
        statement.setString(4, role);
        statement.execute();
        statement.close();
    }

    @Override
    public User findUser(long id) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from db_example.users_role where id='" + id + "'");
        ResultSet result = stmt.getResultSet();
        result.next();
        String name = result.getString(2);
        String pass = result.getString(3);
        int age = result.getInt(4);
        String role = result.getString(5);
        User user = new User(id, name, pass, age, role);
        result.close();
        stmt.close();
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String name = user.getName();
        int age = user.getAge();
        long id = user.getId();
        String pass = user.getPassword();
        String role = user.getRole();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("UPDATE db_example.users_role" +
                " SET name = '"+name+"', password = '"+pass+"', age = '"+age+"', role = '"+role+"' " +
                " WHERE id = '"+id+"'");
        stmt.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        long id = user.getId();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("DELETE FROM db_example.users_role WHERE id = '"+id+"'");
        stmt.close();
    }

    @Override
    public User getUserDao(String name, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("select * from db_example.users_role where name='" + name + "', password = '"+password+"'");
        ResultSet result = stmt.getResultSet();
        result.next();
        long id = result.getLong(1);
        String namee = result.getString(2);
        String pass = result.getString(3);
        int age = result.getInt(4);
        String role = result.getString(5);
        User user = new User(id, namee, pass, age, role);
        result.close();
        stmt.close();
        return user;
    }


}
