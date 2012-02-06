package database

import spock.lang.Specification
import spock.lang.Shared
import groovy.sql.Sql

class DaoSpec extends Specification {

    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table languages (id int primary key, name varchar(50))")
        sql.execute("insert into languages values (1, 'Groovy'), (2, 'Java'), (3, 'Scala'), (4, 'Kotlin')")
    }

    def ""() {
        given:
        def dao = new Dao()
        dao.db = sql

        when:
        def all = dao.findAll()

        then:
        all.size() == 4
        ['Groovy', 'Java', 'Scala', 'Kotlin'] == all.collect { it.name }
    }
}