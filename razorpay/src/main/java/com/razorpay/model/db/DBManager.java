package com.razorpay.model.db;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

// singleton  object to mange db;
@Getter
public class DBManager {

    private Map<String, DataBase> dbMap;

    public static DBManager dbManagerInstance;

    private DBManager() {
        dbMap = new HashMap<>();
    }

    public static DBManager getDbManagerInstance() {
        if (dbManagerInstance == null) {

            synchronized (DBManager.class) {
                if (dbManagerInstance == null) {
                    dbManagerInstance = new DBManager();
                }
            }
        }
        return dbManagerInstance;

    }

    synchronized public void createDB(String dbName) throws Exception // can have specific impl of exceptions
    {
        if (dbMap != null) {
            if (dbMap.containsKey(dbName)) {
                throw new Exception("db already exist");
            }
            dbMap.put(dbName, new DataBase(dbName));
            return;
        }
        throw new Exception("Unknown Exception");

    }

    public DataBase getDataBaseConnection(String dbName)
    {
        if (dbMap != null) {
            if (dbMap.containsKey(dbName)) {
                return dbMap.get(dbName);
            }
        }
        return null;
    }

}
