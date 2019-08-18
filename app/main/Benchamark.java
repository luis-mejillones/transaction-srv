package main;

import com.impetus.client.cassandra.common.CassandraConstants;
import model.Transaction;
import model.TransactionFee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Benchamark {
    public static final String BASE_HREF = "http://localhost:9016/billingManagement/transaction";
    private EntityManagerFactory emf;

    public void measureTime(long size) {
        Transaction transaction;
        EntityManager em = getEmf().createEntityManager();

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; ++i) {
            String id = "00" + i;
            transaction = em.find(Transaction.class, id);
            if (transaction != null) {
                transaction.isPended = true;
                em.persist(transaction);
            }
        }

        long count = -1;
        int i = 0;
        while (count != size) {
            Query result = em.createNativeQuery("SELECT COUNT(id) AS total FROM transaction_  WHERE is_pended = true ALLOW FILTERING");
            count = ((Number)result.getSingleResult()).longValue();

            i++;
        }

        System.out.println("Expectations where validated: " + i + " number of times");

        long endTime = System.currentTimeMillis();

        em.close();

        System.out.println("Time to run: " + (endTime - startTime) + " ms");
    }

    public void loadData(long size) {
        EntityManager em = getEmf().createEntityManager();
        double random;

        for (int i = 0; i < size; ++i) {
            Transaction transaction = new Transaction();
            transaction.id = "00" + i;
            transaction.href = String.format("%s/%s", BASE_HREF, transaction.id);
            transaction.veeaMerchantId = "8400000004" + i;
            transaction.merchantName = "SubMerchant " + i;
            transaction.vantivMID = "84000000041 " + i;
            random = Math.random() * size;
            transaction.amount = BigDecimal.valueOf(random);
            transaction.isPended = false;
            transaction.transactionFees = new TransactionFee();
            transaction.transactionFees.discountRate = BigDecimal.valueOf(random);
            transaction.transactionFees.perTransactionFee = BigDecimal.valueOf(random);
            transaction.transactionFees.reserve = BigDecimal.valueOf(random);

            em.persist(transaction);
        }

        em.close();

        System.out.println("Persisted " + size + " transactions records");
    }


    private EntityManagerFactory getEmf() {
        Map<String, String> props = new HashMap<>();
        props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);

        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("cassandra_pu", props);
        }

        return emf;
    }
}
