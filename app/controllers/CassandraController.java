package controllers;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import play.mvc.Controller;
import play.mvc.Result;
import services.Counter;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * This controller demonstrates how to use dependency injection to
 * bind a component into a controller class. The class contains an
 * action that shows an incrementing count to users. The {@link Counter}
 * object is injected by the Guice dependency injection system.
 */
@Singleton
public class CassandraController extends Controller {

    @Inject
    public CassandraController() {
    }

    /**
     * An action that responds with the {@link Counter}'s current
     * count. The result is plain text. This action is mapped to
     * <code>GET</code> requests with a path of <code>/count</code>
     * requests by an entry in the <code>routes</code> config file.
     */
    public Result cassandra() {
        String output;
        Cluster cluster = null;
        try {
            cluster = Cluster.builder()
                    .addContactPoint("172.17.0.2")
                    .build();
            Session session = cluster.connect("myspace");

            ResultSet rs = session.execute("SELECT * FROM one");
            Row row = rs.one();
            output = "" + row.getInt("id") + " -> " + row.getString("data");
            System.out.println(output);

        } finally {
            if (cluster != null) cluster.close();
        }

        return ok("Data: " + output);
    }

}
