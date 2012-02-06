package capture

import spock.lang.Specification

class JobStarterSpec extends Specification {

    JobExecutor executor = Mock()
    AlertManager alertManager = Mock()

    JobStarter job = new JobStarter(executor, alertManager)

    def "successful job execution"() {
        when:
        job.execute()

        then:
        1 * alertManager.alert({Alert alert ->
            assert alert.message == "Take it easy"
            assert alert.severity == Severity.INFO
            alert
        })
    }

    def "exception has been thrown"() {
        when:
        job.execute()

        then:
        executor.execute() >> { throw new RuntimeException("Something went wrong!")}

        1 * alertManager.alert({Alert alert ->
            assert alert.message == "Something went wrong!"
            assert alert.severity == Severity.ERROR
            alert
        })
    }
}