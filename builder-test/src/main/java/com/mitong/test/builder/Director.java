package com.mitong.test.builder;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public class Director {
    private Builder builder;

    /**
     * Method to build the product.
     * */
    public void construct() {
        builder = new ConcreteBuilder();
        builder.buildPart1();
        builder.buildPart2();
        Product product = builder.retrieveResult();
    }
}
