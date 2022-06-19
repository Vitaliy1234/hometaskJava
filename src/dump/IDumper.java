package dump;

import compute.Statistic;

import java.sql.SQLException;

public interface IDumper {
    /**
     * Save results
     * @param statistic some statistic
     * @param tableName name of the table in DB
     * @param object name of object which statistic we computed
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    void dumpResult(Statistic statistic, String tableName, String object) throws ClassNotFoundException, SQLException;
}
