package com.xxm.todolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDbHelper extends SQLiteOpenHelper {

    // 如果数据库的表schema更改了，就是升级数据库，要增加数据库版本
    private static final String DB_NAME = "todo.db";        // 数据库名字
    private static final int DB_VERSION = 2;                // 数据库版本

    public TodoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 执行创建数据库的SQL语句
        sqLiteDatabase.execSQL(TodoContract.SQL_CREATE_NOTES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        // 数据库升级步骤，一步一步升级
        for (int i = oldVersion; i < newVersion; i++) {
            switch (i) {
                case 1:
                    // 从 1 升级到 2， 增加一个字段
                    try {
                        sqLiteDatabase.execSQL(TodoContract.SQL_ADD_PRIORITY_COLUMN);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
