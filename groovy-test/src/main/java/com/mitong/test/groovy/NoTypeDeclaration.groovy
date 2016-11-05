package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description groovy中访问权限默认为public
 * @description groovy中可以省略类型声明
 * @description def关键字代替类型，根据赋予的值自动识别类型
 */
class NoTypeDeclaration {

    private static def noType

    static void main(args) {
        this.noType = "123"
        println this.noType
        //自动将变量的类型识别为String
        println this.noType.class
    }
}
