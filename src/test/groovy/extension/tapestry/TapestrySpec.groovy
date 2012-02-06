package extension.tapestry

import spock.lang.Specification
import org.apache.tapestry5.ioc.annotations.SubModule
import org.apache.tapestry5.ioc.annotations.Inject

@SubModule(Module)
class TapestrySpec extends Specification {

    @Inject
    Uppercase uppercase

    def "inject tapestry service"() {
        expect:
        uppercase.transform("hello") == "HELLO"
    }
}