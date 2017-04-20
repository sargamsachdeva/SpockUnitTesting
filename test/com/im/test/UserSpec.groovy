package com.im.test

import spock.lang.Specification
import spock.lang.Unroll

class UserSpec extends Specification {

    def "First test"() {
        expect:
        true
    }

    @Unroll
    def "We are able to get the maximum of the two numbers"() {
        when:
        Integer result = Math.max(x, y)

        then:
        result == z

        where:
        x | y  || z
        1 | 2  || 2
        5 | 10 || 10
        0 | 0  || 0
    }



    void "We get an encrypted password from a string "(){
        given: "A password"
        String password = "password"

        and: "A user"
        User user = new User()

        and:
        def mockedEncrypterService = Mock(PasswordEncrypterService)


        and: "Stub encrypt method"
        mockedEncrypterService.encrypt("password") >> "def"
        user.passwordEncrypterService = mockedEncrypterService

        when:
        String encryptedPassword = user.encyryptPassword(password)

        then:
        encryptedPassword=="def"
    }

    void "Encrypt password"() {

        given:"A user"
        User user = new User()

        and:

        def passwordEncrypterService=Mock(PasswordEncrypterService)

        user.passwordEncrypterService=passwordEncrypterService



        when:

        String encrypted=user.encyryptPassword("password")

        then:

        1 * passwordEncrypterService.encrypt("password") >> "password".reverse()
        encrypted == "password".reverse()
    }
















}
