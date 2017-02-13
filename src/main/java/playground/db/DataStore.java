package playground.db;

import org.apache.commons.io.FileUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by guoliang on 2/13/2017.
 */
public class DataStore {
    private static String dbPath = FileUtils.getTempDirectoryPath() + "//devops_tower";
    public final static String inMemoryDBConnString = "jdbc:h2:" + dbPath;

    static {
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection(inMemoryDBConnString);

            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE PRICE IF EXISTS; CREATE TABLE PRICE(BATCH_ID INTEGER, INSTRUMENT_CODE VARCHAR(32), PRICE DECIMAL(10, 2), LOAD_TIMESTAMP TIMESTAMP )");
            statement.execute("  INSERT INTO PRICE(BATCH_ID, INSTRUMENT_CODE, PRICE) VALUES(123, 'SIN', 1.63)");
            statement.close();
            connection.close();

            System.out.println("database initialized by: " + DataStore.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getDummyResult() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection(inMemoryDBConnString);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT TOP 10 * FROM PRICE");
        String result = "";
        while (resultSet.next()) {
            result += resultSet.getString("INSTRUMENT_CODE");
            result += " - " + resultSet.getString("PRICE");
        }

        return result;
    }

}