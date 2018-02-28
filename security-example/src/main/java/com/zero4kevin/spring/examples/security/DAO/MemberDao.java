package com.zero4kevin.spring.examples.security.DAO;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import com.zero4kevin.spring.examples.security.interfaces.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kevin on 2/24/18.
 */
@Repository("myUserDao")
public class MemberDao implements UserDao{
    private  final String USER_TABLE = "users";

    private  JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        System.out.println("setting data source");
        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }

    public MyUser findByEmail(final String email) {
        String sql = "select * from " + USER_TABLE + " where email = '" + email + "'";
//        return jdbcTemplate.queryForObject(sql, new RowMapper<MyUser>() {
        List<MyUser> userList=jdbcTemplate.query(sql, new RowMapper<MyUser>() {
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
        return userList.size()>0?userList.get(0):null;
    }


    public MyUser save(MyUser user) {
        String sql = "insert int " + USER_TABLE + " values ('" + user.getAccountName() + "', '" + user.getFirstName() + "', '"
                + user.getLastName() + "', '" + user.getEmail() + "', '" + user.getPassword() + "', true)";
        try {
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            return null;
        }
        return user;
    }
}
