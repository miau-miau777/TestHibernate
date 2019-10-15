package defaultpackage;




import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import models.Product;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


import java.util.List;


public class Main {
    //private Logger logger = Logger.getInstance(Main.class);

    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Product> productList = null;

        try{
            session.beginTransaction();

            Criteria criteria = session.createCriteria(Product.class);
            criteria.add(Restrictions.eq("titlt", "rthjk"));
            //select * from product where title = "rthjk"; analog
            productList = criteria.list();
            //...zaprosi
            //Query query = session.createQuery("FROM Product ");
            //productList = ((Query) query).list();
            //if(..)
            session.getTransaction().commit();
        }catch (Exception e) {
            session.getTransaction().rollback();
            //logger.error("message .... ", e);
            e.printStackTrace();

        }finally {
            session.close();
            sessionFactory.close();
        }
        for (Product product: productList) {
            System.out.println(product.toString()); }
        /*
        FROM Product;
        From Product p
        From Product as p;
        FROM product, ProductCategory;

         */
        //validation



    }
}
