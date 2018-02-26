package com.zero4kevin.spring.examples.security.DAO;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kevin on 2/24/18.
 */
@Repository
public class MemberDao extends JdbcDaoSupport{
    private String USER_TABLE = "users";

    @Autowired
    public void setDS(DataSource dataSource){
        setDataSource(dataSource);
    }

    public MyUser findByEmail(final String email) {
        String sql = "select * from " + USER_TABLE + " where email = '" + email + "'";
        return getJdbcTemplate().queryForObject(sql, new RowMapper<MyUser>() {
            @Override
            public MyUser mapRow(ResultSet resultSet, int i) throws SQLException {
                MyUser myUser = new MyUser();
                myUser.setAccountName(resultSet.getString("username"));
                myUser.setFirstName(resultSet.getString("givenname"));
                myUser.setLastName(resultSet.getString("surname"));
                myUser.setEmail(resultSet.getString("email"));
                myUser.setPassword(resultSet.getString("password"));
                return myUser;
            }
        });
    }


    private MyUser getMyUserInstance(List<MyUser> result) {
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else
            return null;
    }

    public MyUser save(MyUser user) {
        String sql = "insert int " + USER_TABLE + " values ('" + user.getAccountName() + "', '" + user.getFirstName() + "', '"
                + user.getLastName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', true)";
        try {
            getJdbcTemplate().update(sql);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
