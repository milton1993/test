package com.mitong.test.groovy

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 2015/10/10
 * @description groovy�з���Ȩ��Ĭ��Ϊpublic
 * @description groovy�п���ʡ����������
 * @description def�ؼ��ִ������ͣ����ݸ����ֵ�Զ�ʶ������
 */
class NoTypeDeclaration {

    private static def noType

    static void main(args) {
        this.noType = "123"
        println this.noType
        //�Զ�������������ʶ��ΪString
        println this.noType.class
    }
}
