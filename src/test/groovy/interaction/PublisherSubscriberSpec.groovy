package interaction

import spock.lang.Specification

class PublisherSubscriberSpec extends Specification {
    def pub = new Publisher()
    def sub1 = Mock(Subscriber)
    def sub2 = Mock(Subscriber)

    def setup() {
        pub.subscribers = [sub1, sub2]
    }

    def "delivers messages to all subscribers"() {
        when:
        pub.publish("msg")

        then:
        sub1.receive("msg")
        sub2.receive("msg")

        expect:
        pub.blackList == []
    }

    def "delivers messages in the order they are published"() {
        when:
        pub.publish("msg1")
        pub.publish("msg2")

        then:
        1 * sub1.receive("msg1")

        then:
        1 * sub1.receive("msg2")

        expect:
        pub.blackList == []
    }

    def "can cope with misbehaving subscribers"() {
        when:
        pub.publish("msg")

        then:
        1 * sub1.receive("msg") >> { throw new RuntimeException() }
        1 * sub2.receive("msg")

        expect:
        [sub1] == pub.blackList.collect {it}
    }

    def "using wildcards"() {
        when:
        pub.publish("msg")

        then:
        (_.._) * sub1._("msg")
        1 * sub2.receive("msg")

        expect:
        pub.blackList == []
    }
}