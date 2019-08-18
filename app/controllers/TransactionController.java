package controllers;

import com.impetus.client.cassandra.common.CassandraConstants;
import model.Transaction;
import model.User;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class TransactionController extends Controller {
    public static final String BASE_HREF = "http://localhost:9016/billingManagement/transaction";
    private EntityManagerFactory emf;

    public Result persist() {
        Transaction transaction = new Transaction();
        transaction.id = "0001";
        transaction.href = String.format("%s/%s", BASE_HREF, transaction.id);
        transaction.veeaMerchantId = "840000000655";
        transaction.merchantName = "SubMerchant";
        transaction.vantivMID = "8400000006551";
        transaction.amount = BigDecimal.valueOf(5.25);
//        transaction.totalCharges = BigDecimal.valueOf(1.15);
//        transaction.isAuthorized = false;
        transaction.isPended = false;

        EntityManager em = getEmf().createEntityManager();
        em.persist(transaction);
        em.close();

        return ok("User 0001 record persisted for persistence unit cassandra_pu");
    }

    public Result find() {
        EntityManager em = getEmf().createEntityManager();
        Transaction transaction = em.find(Transaction.class, "002");
        em.close();

        return ok("Found Transaction in database with the following details:" + print(transaction));
    }

//    public Result update() {
//        EntityManager em = getEmf().createEntityManager();
//        User user = em.find(User.class, "0001");
//        user.setCity("New York");
//        em.merge(user);
//        user = em.find(User.class, "0001");
//
//        return ok("Record updated:" + printUser(user));
//    }

//    public Result delete() {
//        EntityManager em = getEmf().createEntityManager();
//        User user = em.find(User.class, "0001");
//
//        em.remove(user);
//        user = em.find(User.class, "0001");
//
//        return ok("Record deleted:" + printUser(user));
//    }

    private EntityManagerFactory getEmf() {
        Map<String, String> props = new HashMap<>();
        props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("cassandra_pu", props);
        }

        return emf;
    }

    private String print(Transaction transaction) {
        if (transaction == null) {
            return "Record not found";
        }

        return "\n--------------------------------------------------" + "\nId:" + transaction.id + "\nveeaMerchantId:"
                + transaction.veeaMerchantId + "\nmerchantName:" + transaction.merchantName + "\nvantivMID:" + transaction.vantivMID;
    }
}
