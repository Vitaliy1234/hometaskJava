package get;

import model.IDocument;

import java.io.FileNotFoundException;
import java.util.List;

public interface IDataLoader {
    List<IDocument> collectData() throws FileNotFoundException;
}
