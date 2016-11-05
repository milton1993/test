package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description
 */
class Ranger {
    static void main(args) {
        def range = 1..4
        println range.class
        assert range instanceof List

        def coll = ["mitong", "abc", "123"]
        println coll.class
        assert coll instanceof Collection
        assert coll instanceof ArrayList
        coll.add("dfad")
        coll << "fdaf"
        coll[5] = "12"
        println coll.size()

        def numbers = [1, 2, 3, 4]
        //对集合进行增减操作实际上创建了新的集合对象
        assert numbers + 5 == [1, 2, 3, 4, 5]
        assert numbers - [1, 2] == [3, 4]
        println numbers.size()
        assert numbers.join(",") == "1,2,3,4"
        assert [1,2,3,4,3,3].count(3) == 3

        assert "JAVA" == "Java".toUpperCase();
        //*表示将集合中的所有项都执行toUpperCase方法
        assert ["JAVA", "GROOVY"] == ["Java", "Groovy"]*.toUpperCase()
    }
}
