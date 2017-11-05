package test_1

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AutoSpec extends Specification implements DomainUnitTest<Auto> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
