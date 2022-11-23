package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User getUser(String model, int series){
      TypedQuery<User> query=sessionFactory.openSession().createQuery("select u FROM User u WHERE u.car.model =:model and u.car.series =:series");
      query.setParameter("model",model).setParameter("series", series);
      return query.getSingleResult();
   }




}

/*
      TypedQuery<User> query=sessionFactory.openSession().createQuery("select u FROM User u WHERE u.car.model =:model and u.car.series =:series");
      query.setParameter("model",model).setParameter("series", series);
      return query.getSingleResult();



      List<User> users = null;
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      String hql = "FROM User u LEFT JOIN Car c on u.id = c.id where c.model = " + model + " and c.series = " + series;
      Query query = session.createQuery(hql);
      users = query.getResultList();
      session.getTransaction().commit();
      System.out.printf(String.valueOf(users.get(0)));

      return null;
 */