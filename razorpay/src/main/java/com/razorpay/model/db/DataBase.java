package com.razorpay.model.db;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class DataBase {

    private String dbName;
    Map<String, Table> tableMap;

    public DataBase(String dbName) {
        this.dbName = dbName;
        tableMap = new HashMap<>();
    }

    // final String tableName, final long recordsLimit, final List<Column> columns
    synchronized public void createTable(final String tableName, final long recordsLimit,
                                         final List<Column> columns) throws Exception {
        if (tableMap != null) {
            if (tableMap.containsKey(tableName)) {
                throw new Exception("table already exists");
            }
            tableMap.put(tableName, new Table(tableName,recordsLimit,columns));
            return;
        }
        throw new Exception("Unknown Exception");

    }

    synchronized public void deleteTable(String tableName) throws Exception {
        if (tableMap != null) {
            if (tableMap.containsKey(tableName)) {
                tableMap.remove(tableName);
            }
        }
        throw new Exception("Unknown Exception");

    }

    public Table getTable(String tableName)
    {
        if (tableMap != null) {
            if (tableMap.containsKey(tableName)) {
                return tableMap.get(tableName);
            }
        }
        return null;
    }

}
