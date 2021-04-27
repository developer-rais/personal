package com.razorpay.model.datatypes;


public class IntegerDataType<T> extends BaseDataType<T> {

    private final int lowerLimit = -1024;
    private final int upperLimit = 1024;


    @Override
    public boolean isValid(T t) {
        if (t == null) {
            return true;
        }
        if (t instanceof Integer) {
            int number = (Integer) t;
            return number >= lowerLimit && number <= upperLimit;

        }
        return false;
    }


}
