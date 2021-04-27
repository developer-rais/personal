package com.razorpay.model;

import com.razorpay.model.datatypes.BaseDataType;
import lombok.Getter;

@Getter
public class Field<T> {

    private T value;
    private BaseDataType type;

    public Field(T value, BaseDataType type) {
        this.value = value;
        this.type = type;
    }
}
