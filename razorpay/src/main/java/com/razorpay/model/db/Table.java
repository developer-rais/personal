package com.razorpay.model.db;

import com.razorpay.model.Field;
import com.razorpay.model.constraints.Constraints;
import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Table {

    @NotNull
    private String name;
    @NotNull
    private long recordsLimit;
    @NonNull
    List<Column> columns;
    List<List<Field>> data;

    public Table(final String tableName, final long recordsLimit, final List<Column> columns) {
        this.name = tableName;
        this.recordsLimit = recordsLimit;
        this.columns = columns;
        this.data = new ArrayList<>();
    }

    public void insertRecord(List<Field> fields) throws Exception {

        if (data.size() >= recordsLimit) {
            throw new Exception("Overflow");
        }

        if (fields == null) {
            return;
        }

        if (fields.size() != columns.size()) {
            throw new Exception("invalid entry");
        }


        List<Field> newRow = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            Column column = columns.get(i);

            boolean typeMatch = field.getType().getClass().equals(column.getDataType().getClass());

            if (!typeMatch) {
                throw new Exception("invalid columns type");
            }

            boolean isDataTypeCorrect = column.getDataType().isValid(field.getValue());
            if (!isDataTypeCorrect) {
                throw new Exception("invalid column value ");
            }

            for (Constraints constraint : column.getConstraints()) {
                boolean isValidValue = constraint.isValid(field.getValue());
                if (!isValidValue) {
                    throw new Exception("invalid column value  acc to constraints");
                }
            }

            newRow.add(field);
        }
        data.add(newRow);
    }

    public List<List<Field>> getTableData() {
        return data;
    }

    public List<List<Field>> getFilteredRecords(String columnName, Field field) {
        Column column = null;
        int columnIndex = 0;

        List<List<Field>> result = new ArrayList<>();

        for (Column col : columns) {
            if (columnName.equals(col.getName())) {
                column = col;
                break;
            }
            columnIndex++;
        }
        if(column==null)
        {
            return null;
        }

        for (List<Field> row : data) {
            if (row.get(columnIndex).getValue() == field.getValue()) {
                result.add(row);
            }
        }
        return result;

    }


}
