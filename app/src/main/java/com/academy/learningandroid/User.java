package com.academy.learningandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mytable")
public class User {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String surname;
    String email;
    String phone;


}
