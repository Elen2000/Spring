package am.basic.web.repository;


import am.basic.web.util.Datasource;
import am.basic.web.model.User;
import org.springframework.stereotype.Repository;
import org.w3c.dom.ls.LSOutput;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserRepositoryImplJdbc implements UserRepositor {

    @PostConstruct
    public void init() {
        System.out.println("UserRepositoryImplJdbc");
    }

    @PreDestroy


    @Override
    public User getById(long id) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM user where id= ? ");
        stmt.setLong(1, id);
        User user = null;
        ResultSet a = stmt.executeQuery();

        if (a.next()) {
            user = new User();
            user.setId(a.getLong(1));
            user.setUsername(a.getString(2));
            user.setSurname(a.getString(3));
            user.setAge(a.getInt(4));
            // user.setPassword(a.getInt(5));
            user.setCode(a.getString(5));

        }
        return user;


    }

    @Override
    public void add(User user) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?)");
        stmt.setLong(1, 0);

        stmt.setString(2, user.getName());
        stmt.setString(3, user.getSurname());
        stmt.setInt(4, user.getAge());
        stmt.setString(5, user.getPassword());
        stmt.setString(6, user.getCode());
        stmt.setString(7, user.getUsername());
        stmt.execute();

    }

    @Override
    public void delete(long id) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("DELETE FROM user WHERE ID=?");
        stmt.setLong(1, id);
        stmt.execute();
    }

    @Override
    public void update(User user) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("UPDATE user Set username=?,surname=?,age=?,password=?,code=? WHERE id=? ");
        stmt.setLong(6, user.getId());
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getSurname());
        stmt.setInt(3, user.getAge());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getCode());
        stmt.execute();

    }

    @Override
    public User getByUsernameAndPassword(String username, String password) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM user where username= ? AND password=? ");
        stmt.setString(1, username);
        stmt.setString(2, password);
        User user = null;
        ResultSet a = stmt.executeQuery();

        if (a.next()) {
            user = new User();
            user.setId(a.getLong(1));
            user.setUsername(a.getString(2));
            user.setSurname(a.getString(3));
            user.setAge(a.getInt(4));
            user.setPassword(a.getString(6));
        }
        return user;
    }

    @Override
    public User getByUsername(String username) throws SQLException {
        Connection con = Datasource.getConnection();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM user where username=? ");
        stmt.setString(1, username);
        User user = null;
        ResultSet a = stmt.executeQuery();

        if (a.next()) {
            user = new User();
            user.setId(a.getLong(1));
            user.setUsername(a.getString(2));
            user.setSurname(a.getString(3));
            user.setAge(a.getInt(4));
            user.setPassword(a.getString(6));


        }
        return user;


    }

    public void destroy() {
        System.out.println("destroy");
    }

}

