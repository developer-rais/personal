package com.razorpay.model.constraints;

public interface Constraints<T> {

    public boolean isValid(T t);
}
