package com.mitong.test.guava.preconditions;

import com.google.common.base.Preconditions;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-7-16
 */
public class PreconditionsTest {
    private String label;
    private int[] values = new int[5];
    private int currentIndex;
    public PreconditionsTest(String label) {
        //returns value of object if not null
        this.label = Preconditions.checkNotNull(label, "Lable can't be null");
    }

    public void updateCurrentIndexValue(int index, int valueToSet) {
        //check if index is valid first
        this.currentIndex = Preconditions.checkElementIndex(index, values.length, "Index out of bounds for values");
        //validate valueToSet
        Preconditions.checkArgument(valueToSet <= 100, "valueToSet can't be more than 100");
        values[this.currentIndex] = valueToSet;
    }

    public void doOperation() {
        Preconditions.checkState(validateObjectState(), "Can't perform operation");
    }

    private boolean validateObjectState() {
        return this.label.equalsIgnoreCase("open") && values[this.currentIndex] == 10;
    }

    public static void main(String[] args) {
        PreconditionsTest preconditionsTest = new PreconditionsTest("open");
        preconditionsTest.doOperation();
    }
}
