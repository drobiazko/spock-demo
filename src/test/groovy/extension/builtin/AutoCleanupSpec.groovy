package extension.builtin

import spock.lang.AutoCleanup
import spock.lang.Specification

class AutoCleanupSpec extends Specification {

    @AutoCleanup("delete")
    File file

    def "some file-based test"() {
        setup:

        file = File.createTempFile("spock", null)
        file.createNewFile()

        when:
        file << "Hello, Spock!"

        and:
        print file

        then:
        file.exists()
        file.getText() == "Hello, Spock!"
    }
}