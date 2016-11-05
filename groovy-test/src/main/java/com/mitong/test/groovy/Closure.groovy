package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description
 */
class Closure {
    static def list = ["abc", "efg", "hij"]

    static def hash = [name : "mitong", age : 18]

    static def useIterator() {
        for (def iterator = list.iterator(); iterator.hasNext();) {
            println iterator.next()
        }
        for (Iterator iterator = hash.entrySet().iterator(); iterator.hasNext(); ) {
            def entry = (java.util.Map.Entry)iterator.next();
            println "${entry.getKey()}-${entry.getValue()}";
        }
    }

    static def groovyClosure() {
//        list.each {
//            println it  //默认用it指代迭代对象
//        }
        list.each { value ->
            println value
        }

        hash.each { key, value ->
            println "${key}-${value}"
        }
    }

    static def closureObject() {
        def closure = { word ->
            return "${word}!!!"
        }
        return closure
    }

    static void main(args) {
        useIterator()

        groovyClosure()

        def closure = closureObject()
        assert "Groovy!!!" == closure("Groovy")
        assert "Java!!!" == closure.call("Java")
    }
}
