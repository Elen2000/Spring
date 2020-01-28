package am.basic.web.repository;

import am.basic.web.model.User;
import am.basic.web.util.Datasource;
import am.basic.web.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
@Transactional(isolation= Isolation.DEFAULT,rollbackFor = Throwable.class,noRollbackFor = RuntimeException.class)
@Scope("singleton")
public class UserRepositoryImpl implements UserRepositor {

    public void init() {
        System.out.println("UserRepositoryImpl");
    }

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
@Transactional(readOnly = true)
    public User getById(long id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);
    }


    public void add(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);

    }

    @Override
    public void delete(long id) throws SQLException {
    }

    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    public User getByUsernameAndPassword(String username, String password) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("SELECT * FROM user WHERE username = ? AND password = ?");
        query.setParameter(1, username);
        query.setParameter(2, password);
        return query.uniqueResult();
    }

    public User getByUsername(String username) {
        NativeQuery<User> query = sessionFactory.openSession().createNativeQuery("SELECT * FROM user WHERE username = ?", User.class);
        query.setParameter(1, username);
        return query.uniqueResult();
    }
}
