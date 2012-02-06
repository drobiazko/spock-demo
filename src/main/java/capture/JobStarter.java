package capture;

public class JobStarter {

    private final JobExecutor jobExecutor;
    private final AlertManager alertManager;

    public JobStarter(JobExecutor jobExecutor, AlertManager alertManager) {
        this.jobExecutor = jobExecutor;
        this.alertManager = alertManager;
    }

    public void execute() {
        try {
            jobExecutor.execute();

            final Alert alert = new Alert(Severity.INFO, "Take it easy");

            alertManager.alert(alert);
        } catch (Exception e) {
            final Alert alert = new Alert(Severity.ERROR, e.getMessage());

            alertManager.alert(alert);
        }
    }
}
