package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description
 */
class Map {
    static void main(args) {
        //Groovy���name�Զ�ת����String����
        def hashMap = [name : "mitong", "sex" : 1]
        assert hashMap.getClass() == java.util.LinkedHashMap
        assert hashMap instanceof java.util.Map
        //���ӳ��
        hashMap.put("1", "123")
        hashMap.a1 = "123"
        assert hashMap.get("1") == "123"
        assert hashMap.a1 == "123"
        assert hashMap["name"] == "mitong"
        assert hashMap["sex"] == 1
    }
}
