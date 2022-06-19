package model;

public abstract class PersonalDoc implements IDocument{
    public String employee;
    public String orderText;
    public Status status;

    public PersonalDoc (String employee, String orderText, Status status) {
        this.employee = employee;
        this.orderText = orderText;
        this.status = status;
    }

    @Override
    public String toString() {
        return this.employee + ";" + this.orderText + ";" + this.status;
    }
}
