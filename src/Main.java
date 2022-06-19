import compute.BaseStatComputer;
import compute.IStatComputer;
import compute.Statistic;
import dump.DumpToDB;
import dump.IDumper;
import get.FileDataLoader;
import get.IDataLoader;
import logger.ILogger;
import logger.LoggerFactory;
import model.IDocument;

import java.sql.SQLException;
import java.util.List;

public class Main {

    private static final ILogger logger = LoggerFactory.getLogger();

    public static void main(String[] args) {

        logger.info("Load data.");
        List<IDocument> data = null;
        try {
            IDataLoader dataLoader = new FileDataLoader();
            data = dataLoader.collectData();
            logger.info("End loading data.");
        } catch (Exception exception) {
            logger.error("Error while loading data.", exception);
            System.exit(1);
        }
        logger.info("Compute stat.");
        Statistic resultStatDocs = null;
        Statistic resultStatEmpls = null;
        try {
            IStatComputer statComputer = new BaseStatComputer();
            resultStatDocs = statComputer.countDocsByType(data);
            resultStatEmpls = statComputer.countDocsByEmployee(data);
            logger.info("End statistic cimputing.");
        } catch (Exception exception) {
            logger.error("Error while statistic computiong.", exception);
            System.exit(2);
        }

        logger.info("Dump results.");
        try {
            IDumper dumper = new DumpToDB();
            dumper.dumpResult(resultStatDocs, "docs", "docType");
            dumper.dumpResult(resultStatEmpls, "empls", "emplName");
            logger.info("End dumping results.");
        } catch (Exception exception) {
            logger.error("Error while dumping resutls.", exception);
            System.exit(3);
        }
    }
}
