package com.zero4kevin.spring.examples.security;

import com.zero4kevin.spring.examples.security.DTO.MyUser;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by xi1zhang on 2018/2/14.
 * This class runs all operations on DB
 */
public class MyUserDao {
    private static EntityManager entityManager;

    public static MyUser findByEmail(final String email){
        final Query query= entityManager.createQuery("from Users where email=:email", MyUser.class);
        query.setParameter("email",email);
        final List<MyUser> result=query.getResultList();
        return getMyUserInstance(result);
    }

    public static MyUser findByUsername(final String username) {
        final Query query = entityManager.createQuery("from Users where username=:username", MyUser.class);
        query.setParameter("username", username);
        final List<MyUser> result = query.getResultList();
        return getMyUserInstance(result);
    }

    private static MyUser getMyUserInstance(List<MyUser> result) {
        if (result != null && result.size() > 0) {
            return result.get(0);
        } else
            return null;
    }

    public static MyUser save(final MyUser user) {
        entityManager.persist(user);
        return user;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}
