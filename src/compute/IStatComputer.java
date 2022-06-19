package compute;

import model.IDocument;

import java.util.List;

public interface IStatComputer {
    /**
     * Statistic computing on data
     * @param data list of docs
     * @return statistic
     */
    Statistic countDocsByType(List<IDocument> data);
    Statistic countDocsByEmployee(List<IDocument> data);
}
