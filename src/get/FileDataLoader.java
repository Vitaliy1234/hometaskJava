package get;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileDataLoader implements IDataLoader {
    @Override
    public List<IDocument> collectData() throws FileNotFoundException {
        List<IDocument> result = new ArrayList<>(readLetter("data/Letters.csv"));
        result.addAll(readEmpl("data/Employments.csv"));
        result.addAll(readDismiss("data/Dismiss.csv"));

        return result;
    }

    private List<IDocument> readLetter(String fileName) throws FileNotFoundException {
        File letterFile = new File(fileName);
        Scanner scanner = new Scanner(letterFile);
        List<IDocument> result = new ArrayList<>();

        // skip header
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] curLine = scanner.nextLine().split(";");
            String from = curLine[1];
            String to = curLine[2];
            String text = curLine[3];
            IDocument curDoc = new Letter(from, to, text);
            result.add(curDoc);
        }

        return result;
    }

    private List<IDocument> readEmpl(String fileName) throws FileNotFoundException {
        File emplFile = new File(fileName);
        Scanner scanner = new Scanner(emplFile);
        List<IDocument> result = new ArrayList<>();

        // skip header
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] curLine = scanner.nextLine().split(";");
            String employee = curLine[1];
            String orderText = curLine[2];
            Status status = Status.getByText(curLine[3]);
            IDocument curDoc = new EmploymentDoc(employee, orderText, status);
            result.add(curDoc);
        }
        return result;
    }

    private List<IDocument> readDismiss (String fileName) throws FileNotFoundException {
        File emplFile = new File(fileName);
        Scanner scanner = new Scanner(emplFile);
        List<IDocument> result = new ArrayList<>();

        // skip header
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String[] curLine = scanner.nextLine().split(";");
            String employee = curLine[1];
            String orderText = curLine[2];
            Status status = Status.getByText(curLine[3]);
            String reason = curLine[4];
            IDocument curDoc = new DismissDoc(employee, orderText, status, reason);
            result.add(curDoc);
        }
        return result;
    }
}
