package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description �������������Ϳ��Խ�����������
 * @description forѭ��������static�����У����Բ��ø����������������ͣ�Ҳ����ʹ��def�ؼ���
 * @description Groovy�п���ʹ��..�޶���Χ������forѭ���ܷ���
 * @description ��������ָ��Ĭ��ֵ�������ڵ��õ�ʱ��ʡ�Ըò���
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
