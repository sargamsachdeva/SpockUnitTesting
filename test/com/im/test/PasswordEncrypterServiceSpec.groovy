package com.im.test

import spock.lang.IgnoreRest
import spock.lang.Specification

class PasswordEncrypterServiceSpec extends Specification {
    //todo

    @IgnoreRest
    def "Encrypted password is returned by the public method"() {
        given:

        PasswordEncrypterService encrypterService = Spy(PasswordEncrypterService)
        String password = "somePassword"
        String aVeryComplexProcessedPassword = password.reverse()

        when:

        String p = encrypterService.encrypt(password)

        then:
        1 * encrypterService.aVeryComplexProcess(password) >> aVeryComplexProcessedPassword
        p == aVeryComplexProcessedPassword
    }

}
