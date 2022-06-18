package ru.gb.homeWork.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.gb.homeWork.PrepareDataApp;
import ru.gb.homeWork.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private static SessionFactory factory;


//    Создайте класс ProductDao и реализуйте в нем логику выполнения CRUD-операций над сущностью Product (
//    Product findById(Long id),
//    List<Product> findAll(),
//    void deleteById(Long id),
//    Product saveOrUpdate(Product product);
//    );

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        Product product;
        Long id = 2L;
        try {
            init();
            System.out.println(findById(id));
//          System.out.println(findAll());
//            deleteById(id);
//            saveOrUpdate(product);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    private static Product findById(Long id) {
        Product product;
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, id);
            System.out.println(product);
            session.getTransaction().commit();
        }
        return product;
    }
    private static List<Product> findAll() {
        List<Product> prodRepo = new ArrayList<>();
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            prodRepo = session.createQuery("from Products").getResultList();
            System.out.println(prodRepo + "\n");
            session.getTransaction().commit();
        }
        return prodRepo;
    }
    private static void deleteById(Long id) {

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }
    private static Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            product = session.get(Product.class, product.getId());
            product.setCost(1000);
            session.getTransaction().commit();
        }
        return product;
    }
    private static void shutdown() {
        factory.close();
    }

}
