package domain

import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Shared

@Stepwise
class AccountSpecStepwise extends Specification {
    @Shared def account = new Account(5.0)

    def "first two euros are withdrawn"() {
        when:
        account.withdraw(2.0)

        then:
        account.balance == 3.0
    }

    def "then one more euros is withdrawn"() {
        when:
        account.withdraw(1.0)

        then:
        account.balance == 2.0
    }

    def "final account balance"() {
        expect:
        account.balance == 2.0
    }
}