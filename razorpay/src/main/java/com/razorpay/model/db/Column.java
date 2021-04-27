package com.razorpay.model.db;

import com.razorpay.model.constraints.Constraints;
import com.razorpay.model.datatypes.BaseDataType;
import lombok.Getter;

import java.util.List;

@Getter
public class Column {
    // int age
    private String name;
    private BaseDataType dataType;
    private List<Constraints> constraints;

    public Column(String name, BaseDataType dataType, List<Constraints> constraints) {
        this.name = name;
        this.dataType = dataType;
        this.constraints = constraints;
    }


}
