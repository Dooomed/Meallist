package com.prokhorenko.meallist.dao;

import com.prokhorenko.meallist.config.HibernateUtil;
import com.prokhorenko.meallist.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserDao /*implements UserDetailsService*/ {

/*
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
*/

    public List<User> getAll(){
        return HibernateUtil.getSession().createQuery("from User").list();
    }
    public User findUserById(int id) {

        return (User) HibernateUtil.getSession()
                .createQuery("from User where id = :id")
                .setParameter("id", id).getSingleResult();
    }


/*
    public boolean createUser(User user) {
        Session session = HibernateUtil.getSession();
        //UserDetails userFormDB = loadUserByUsername(user.getUsername());
        if(userFormDB != null){
            return false;
        }
        Transaction tx = session.beginTransaction();
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        session.save(user);
        tx.commit();
        return true;
    }
*/

    public void deleteUser(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }

    public void updateUser(User user) {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        session.update(user);
        tx.commit();
    }

    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) HibernateUtil.getSession()
                .createQuery("from User where username = :username ")
                .setParameter("username", username).getSingleResult();
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return user;

    }*/
}

