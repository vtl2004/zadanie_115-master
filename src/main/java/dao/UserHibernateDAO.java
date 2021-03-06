package dao;

import com.mysql.cj.Query;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.LogicalExpression;
import util.DBHelper;
import util.UserDaoFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;

public class UserHibernateDAO implements UserDAO{
    private SessionFactory sessionFactory;


    public UserHibernateDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private static UserHibernateDAO userHibernateDAO;

    public static UserHibernateDAO getInstance(){
        if (userHibernateDAO == null){
            userHibernateDAO = new UserHibernateDAO(DBHelper.getSessionFactory());
        }
        return userHibernateDAO;
    }


    @Override
    public List<User> findAllUsers() {
        List<User> users = sessionFactory.openSession().createQuery("From User").list();
        return users;
    }

    @Override
    public void saveUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User findUser(long id) throws SQLException {
        return  sessionFactory.openSession().get(User.class, id);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }

    @Override
    public User getUserDao(String name, String password) {
        User user = null;
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(User.class);
            Criterion nameUser = Restrictions.eq("name", name);
            Criterion passUser = Restrictions.eq("password", password);
            LogicalExpression logicalExpression = Restrictions.and(nameUser, passUser);
            criteria.add(logicalExpression);
            user = (User) criteria.uniqueResult();
        } catch (Exception e){e.printStackTrace();}
        finally {
            session.close();
        }
        return user;
    }


}
