package compute;

import model.IDocument;
import model.Letter;
import model.PersonalDoc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BaseStatComputer implements IStatComputer {

    @Override
    public Statistic countDocsByType(List<IDocument> data) {
        Statistic result = new Statistic(new HashMap<>());

        for (IDocument curDoc : data) {
            String curDocClass = curDoc.getClass().getName();

            if (result.stat.containsKey(curDocClass)) {
                result.stat.put(curDocClass, result.stat.get(curDocClass) + 1);
            } else {
                result.stat.put(curDocClass, 1);
            }
        }
        return result;
    }

    @Override
    public Statistic countDocsByEmployee(List<IDocument> data) {
        Statistic result = new Statistic((new HashMap<>()));

        for (IDocument curDoc : data) {
            List<String> curEmployees = new ArrayList<>();

            if (curDoc instanceof Letter) {
                curEmployees.add(((Letter) curDoc).from);
                curEmployees.add(((Letter) curDoc).to);
            }
            else {
                curEmployees.add(((PersonalDoc) curDoc).employee);
            }
            for (String employee : curEmployees) {
                if (result.stat.containsKey(employee)) {
                    result.stat.put(employee, result.stat.get(employee) + 1);
                } else {
                    result.stat.put(employee, 1);
                }
            }
        }

        return result;
    }
}
