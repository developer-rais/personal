package com.razorpay.model.datatypes;

public class StringDataType<T> extends BaseDataType<T> {

    private final long charLimit = 20;

    @Override
    public boolean isValid(T t) {
        if (t == null) {
            return true;
        }

        if (t instanceof String) {
            String string = (String) t;
            return string.length() <= charLimit;
        }
        return false;

    }
}
