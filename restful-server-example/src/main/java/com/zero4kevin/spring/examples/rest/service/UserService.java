package com.zero4kevin.spring.examples.rest.service;

import com.zero4kevin.spring.examples.rest.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xi1zhang on 2018/4/19.
 */
@Component
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Person person){
        String sql="insert into Person values (";
        sql=sql+person.getName()+","+person.getSex()+","+person.getAge()+")";
        jdbcTemplate.update(sql);
    }

    public List<Person> query(String name){
        String sql="select * from Person where name='"+name+"'";
//        return jdbcTemplate.queryForObject(sql, Person.class);
//        return (Person)jdbcTemplate.query(sql, new ResultSetExtractor<Person>(){
//            public Person extractData(ResultSet resultSet) throws SQLException, DataAccessException {
//                Person person=new Person();
//                person.setName(resultSet.getString(1));
//                person.setAge(resultSet.getInt(2));
//                person.setSex(resultSet.getString(3));
//                return person;
//            }});
        return jdbcTemplate.query(sql, new RowMapper<Person>() {
            public Person mapRow(ResultSet resultSet, int i) throws SQLException {
                Person person=new Person();
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setSex(resultSet.getString("sex"));
                return person;
            }
        });

    }

    public void delete(String name){
        String sql="delete from Person where name="+name;
        jdbcTemplate.update(sql);
    }

}
