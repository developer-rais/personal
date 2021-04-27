package com.razorpay.service;

import com.razorpay.model.Field;

import java.util.List;

public class TableService {


    public void printTableData(List<List<Field>> tableData) {
        for (List<Field> row : tableData) {

            for (Field column : row) {
                System.out.print(column.getValue() + " ");
            }
            System.out.println();
        }
    }
}
