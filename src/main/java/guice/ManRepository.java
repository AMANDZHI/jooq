package guice;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.sources.tables.Mytable;
import org.jooq.sources.tables.records.MytableRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ManRepository implements Repository {
    String user = "postgres";
    String password = "postgres";
    String url = "jdbc:postgresql://localhost:5432/postgres";

    @Override
    public void save(Man man) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DSLContext dsl = DSL.using(connection, SQLDialect.POSTGRES);
            dsl.insertInto(Mytable.MYTABLE, Mytable.MYTABLE.ID, Mytable.MYTABLE.NAME).values(man.getId(), man.getName()).execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Man getManById(Integer id) {
        Man man = new Man();
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
            DSLContext dsl = DSL.using(connection, SQLDialect.POSTGRES);
            Result<Record> rec = dsl.select().from(Mytable.MYTABLE).where(Mytable.MYTABLE.ID.eq(id)).fetch();

                Record record = rec.get(0);


                man.setId(record.getValue(Mytable.MYTABLE.ID));
                man.setName(record.getValue(Mytable.MYTABLE.NAME));
                System.out.println(man.getName());
                return man;

            } catch (SQLException e) {
            e.printStackTrace();
        }
            return man;
    }
}
