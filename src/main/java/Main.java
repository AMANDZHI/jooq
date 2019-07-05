import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Mytable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        String user = "postgres";
        String password = "postgres";

        String url = "jdbc:postgresql://localhost:5432/postgres";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DSLContext dsl = DSL.using(connection, SQLDialect.POSTGRES);
            Result<Record> sam = dsl.select().from(Mytable.MYTABLE).where(Mytable.MYTABLE.NAME.eq("sam")).fetch();

            HashMap<Integer, String> map = new HashMap<>();
            for (Record r: sam) {
                Integer id= r.getValue(Mytable.MYTABLE.ID);
                String name = r.getValue(Mytable.MYTABLE.NAME);
                map.put(id, name);

            }
            System.out.println(map.get(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
