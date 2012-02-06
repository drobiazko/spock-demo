package gebdemo

import geb.spock.GebReportingSpec
import geb.spock.GebSpec

class GoogleWikipediaSpec extends GebSpec {

    def "go to google"() {
        when:
        browser.go()

        then:
        browser.page.title == "Google"
    }

    def "search for wikipedia"() {
        given:
        $("input", name: "q").value("wikipedia")

        and:
        waitFor { btnG().displayed }

        when:
        btnG().click()

        then:
        waitFor { title.endsWith("Google Search") }
    }

    def "the first result should be wikipedia"() {
        given:
        def firstLink = $("li.g", 0).find("a.l")

        expect:
        firstLink.text() == "Wikipedia"

        when:
        firstLink.click()

        then:
        waitFor { title == "Wikipedia" }
    }
}