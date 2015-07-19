package com.mitong.test.builder;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();
    /**
     * Build part1 of the product.
     */
    @Override
    public void buildPart1() {
        product.setPart1(123);
    }

    /**
     * Build part2 of the product.
     */
    @Override
    public void buildPart2() {
        product.setPart2("abc");
    }

    /**
     * Return the product that has been built.
     */
    @Override
    public Product retrieveResult() {
        return this.product;
    }
}
