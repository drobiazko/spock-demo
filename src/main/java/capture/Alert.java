package capture;

public class Alert {
    private Severity severity;

    private String message;

    public Alert(Severity severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

}
