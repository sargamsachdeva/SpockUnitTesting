package com.im.test

class CustomerService {

    Boolean isPrivellegedDiscountApplicable(User user, Product product){
        return (product.discountType == DiscountType.PRIVELLEGE_ONLY && user.isPrivellegedCustomer)
    }

}
