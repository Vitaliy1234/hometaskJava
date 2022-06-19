package model;

public class Letter implements IDocument{
    public String to;
    public String from;
    public String text;

    public Letter (String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String toString() {
        return this.from + ";" + this.to + ";" + this.text;
    }
}
