package extension.spring

import spock.lang.Specification
import org.springframework.test.context.ContextConfiguration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext

@ContextConfiguration(locations = "spring-context.xml")
class SpringSpec extends Specification {

    @Autowired
    ApplicationContext applicationContext

    @Autowired
    Greeter greeter

    def "inject spring bean"() {
        when:
        def greeting = greeter.greet("Spock")

        then:
        greeting == "Hello, Spock!"
    }

    def "access beans from application context"() {
        when:
        def greeter = applicationContext.getBean("Greeter", Greeter)

        and:
        def greeting = greeter.greet("Spock")

        then:
        greeting == "Hello, Spock!"
    }
}