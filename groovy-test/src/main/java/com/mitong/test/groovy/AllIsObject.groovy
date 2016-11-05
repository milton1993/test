package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description 在Groovy中，一切都是对象
 */
def a = 12
//输出类型为Integer，而不是int
println a.class

def l = 12L
println l.class

//小数默认识别为BigDecimal类型
def bd = 1.2
println bd.class

def d = 1.2D
println d.class

def f = 1.2F
println f.class

def bool = true
println bool.class