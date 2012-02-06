import spock.lang.Specification

class HelloSpock extends Specification {

    def "greater of two numeric values"() {

        expect:
        Math.max(1, 3) == 3
    }
}