package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description 参数不定义类型可以接受任意类型
 * @description for循环若不在static方法中，可以不用给自增变量声明类型，也不用使用def关键字
 * @description Groovy中可以使用..限定范围，用在for循环很方便
 * @description 函数参数指定默认值，可以在调用的时候省略该参数
 */
class ForLoop {
    static def repeat(val, repeat = 5) {
//        for (def i = 0 ; i < 5; i++) {
//            println val
//        }
        for (i in 0..<repeat) {
            println val
        }
    }

    static void main(args) {
        def s = "123"
        def i = 1
        repeat(s, 2)
        repeat(i);
    }
}
