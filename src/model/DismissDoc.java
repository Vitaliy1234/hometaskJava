package model;

public class DismissDoc extends PersonalDoc {
    String reason;

    public DismissDoc (String employee, String orderText, Status status, String reason) {
        super(employee, orderText, status);
        this.reason = reason;
    }

    @Override
    public String toString() {
        return super.toString() + ";" + this.reason;
    }
}
