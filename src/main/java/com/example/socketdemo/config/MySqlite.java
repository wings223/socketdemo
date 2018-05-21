package com.example.socketdemo.config;

import com.enigmabridge.hibernate.dialect.SQLiteDialect;

import java.sql.Types;

public class MySqlite extends SQLiteDialect {
    public MySqlite(){
        super();
        registerHibernateType(Types.NULL, "null");
    }
}
