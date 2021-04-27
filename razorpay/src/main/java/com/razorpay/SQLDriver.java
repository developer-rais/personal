package com.razorpay;

import com.razorpay.model.Field;
import com.razorpay.model.constraints.RangeConstraints;
import com.razorpay.model.datatypes.IntegerDataType;
import com.razorpay.model.datatypes.StringDataType;
import com.razorpay.model.db.Column;
import com.razorpay.model.db.DBManager;
import com.razorpay.model.db.DataBase;
import com.razorpay.model.db.Table;
import com.razorpay.service.TableService;

import java.util.ArrayList;
import java.util.List;

public class SQLDriver {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome");

        DBManager dbManager=DBManager.getDbManagerInstance();
        TableService tableService=new TableService();



        dbManager.createDB("sql1");
        DataBase dataBase=dbManager.getDataBaseConnection("sql1");

        Column column1=new Column("id",new IntegerDataType(),new ArrayList(){{
            add(new RangeConstraints(1,20,true,true));
        }});
        Column column2=new Column("name",new StringDataType(),new ArrayList<>());


        dataBase.createTable("table1",10,new ArrayList(){{
            add(column1);
            add(column2);
        }});

       Table table= dataBase.getTable("table1");


        Field field1=new Field(1,new IntegerDataType());
        Field field2=new Field("Rais",new StringDataType());

        table.insertRecord(new ArrayList(){{
            add(field1);
            add(field2);
        }});

        List<List<Field>> rows =table.getData();
        tableService.printTableData(rows);

        Field  field3=new Field(2,new IntegerDataType());
        Field field4=new Field("Ali",new StringDataType());

        table.insertRecord(new ArrayList(){{
            add(field3);
            add(field4);
        }});


        Field  field5=new Field(1000,new IntegerDataType());
        Field field6=new Field("dwvidw",new StringDataType());

        table.insertRecord(new ArrayList(){{
            add(field5);
            add(field6);
        }});


        rows =table.getData();
        tableService.printTableData(rows);

        System.out.println("\n\n\n");

        List<List<Field>> filteredRecords=  table.getFilteredRecords("id",new Field(2,new IntegerDataType()));

        tableService.printTableData(filteredRecords);


        System.out.println("End");
    }
}
