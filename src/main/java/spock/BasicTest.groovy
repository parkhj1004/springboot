package spock

import spock.lang.Specification

import java.math.RoundingMode

class BasicTest extends Specification{

    def "테스트"() {
        given:
        BigDecimal 금액 = BigDecimal.valueOf(495)

        when:
        BigDecimal 원단위_반올림 = 금액.setScale(-1 , RoundingMode.HALF_UP)

        then:
        원단위_반올림 == 500
    }
}
