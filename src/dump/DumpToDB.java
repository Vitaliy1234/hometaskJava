package dump;

import compute.Statistic;
import logger.ILogger;
import logger.LoggerFactory;

import java.sql.*;

public class DumpToDB implements IDumper {

    private static final ILogger logger = LoggerFactory.getLogger();
    @Override
    public void dumpResult(Statistic statistic, String tableName, String object) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        String sqlQuery = "create table " + tableName + "(id serial primary key, " + object + " varchar(100), count int)";
        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlQuery);
        logger.info("Table created!");

        try {
            for (String docName : statistic.stat.keySet()) {
                String docNum = statistic.stat.get(docName).toString();
                String putValues = "insert into " + tableName + "(" + object + ", count) values('" +
                        docName + "'," + docNum + ")";
                statement.executeUpdate(putValues);
                logger.info("Values inserted");
            }
        } catch (Exception exception) {
            logger.error("Values was not inserted", exception);
        }
    }

    private Connection getConnection () throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hw_java", "postgres", "12345");
        if (connection != null) {
            logger.info("Connection succesfull!");
        }
        else {
            logger.warning("Connection failed");
        }

        return connection;
    }
}
