package domain

import spock.lang.Specification
import spock.lang.Unroll
import extension.custom.Report

@Report
class AccountSpec extends Specification {

    def "withdraw an amount"() {
        given: "an account with a balance of five euros"
        Account account = new Account(BigDecimal.valueOf(5));

        when: "two euros are withdrawn"
        account.withdraw(BigDecimal.valueOf(2));

        then: "three euros remain in the account"
        account.getBalance() == BigDecimal.valueOf(3);
    }

    def "withdraw an amount - groovy"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(2.0)

        then:
        account.balance == 3.0
    }

    def "can't withdraw negative amount"() {
        given:
        def account = new Account(5.0)

        when:
        account.withdraw(-1.0)

        then:
        NegativeAmountWithdrawnException e = thrown()
        e.amount == -1.0
    }

    @Unroll("withdrawing #amount from initial #initial results in balance #balance")
    def "withdraw amount datadriven"() {
        given:
        def account = new Account(initial)

        when:
        account.withdraw(amount)

        then:
        account.balance == balance

        where:
        initial << [5.0, 4.0, 7.0]
        amount << [3.0, 0.0, 7.0]
        balance << [2.0, 4.0, 0]
    }

    def "withdraw amount datadriven - matrix"() {
        given:
        def account = new Account(initial)

        when:
        account.withdraw(amount)

        then:
        account.balance == balance

        where:
        initial | amount | balance
        5.0     | 3.0    | 2.0
        4.0     | 0.0    | 4.0
        7.0     | 7.0    | 0.0
    }
}
