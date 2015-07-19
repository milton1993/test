package com.mitong.test.builder;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public abstract class Builder {
    /**
     * Build part1 of the product.
     * */
    public abstract void buildPart1();

    /**
     * Build part2 of the product.
     * */
    public abstract void buildPart2();

    /**
     * Return the product that has been built.
     * */
    public abstract Product retrieveResult();
}
