package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description
 */
class Classes {
    //Ĭ����������������˽�е�
    def field1
    def field2
    def field3
    def field4
    def field5

    @Override
    String toString() {
        //����Ҫreturn��䣬GroovyĬ�Ϸ��ط���������һ��
        "${field1}, ${field2}, ${field3}, ${field4}"
    }

    static def main(args) {
        def classes = new Classes(field1: "field1", field2: "field2")
        classes.field3 = "field3"
        classes.setField4("field4")
        assert "field1" == classes.getField1()
        println classes
        //ʹ��?�����ָ���쳣
        println classes.field5?.toUpperCase()
    }
}
