package com.im.test

import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionSpec extends Specification {

//todo
    void "We are able to cancel a sale"(){



        given:"A Transaction for sale"
        Transaction transaction = new Transaction()
        User user = new User()
        Product product = new Product()

        product.price = 120000
        user.balance = 1400000

        and:

        def emailService= Mock(EmailService)
        transaction.emailService = emailService

        when:
        transaction.cancelSale(product,user)

        then:

        transaction.calculateDiscount(product,user)>>{
            float discount;

            if (user) {
                discount = 45
            } else {
                discount = 50
            }

            return discount
        }

        emailService.sendCancellationEmail(user,"p1")



    }

//todo
    void "Customer discount is calculated for a product"() {

        given:

        Transaction transaction = new Transaction()
        Product product = new Product()
        User user = new User()
        product.price = 120000
        user.balance = 1400000
        product.discountType=DiscountType.ALL
        BigDecimal discount=0


        and:

        def customerService= Mock(CustomerService)
        transaction.customerService = customerService

        when:

        discount =transaction.calculateDiscount(product,user)

        then:

        customerService.isPrivellegedDiscountApplicable(user,product) >> {

            return true;


        }
        discount== product.price * 30 / 100

    }















}
