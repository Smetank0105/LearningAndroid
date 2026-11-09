package com.academy.learningandroid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

import kotlin.text.HexExtensionsKt;

public class MainActivity extends AppCompatActivity {
    Button btnAdd;
    Button btnRead;
    Button btnClear;
    Button btnId;

    EditText etName;
    EditText etSurname;
    EditText etEmail;
    EditText etPhone;
    EditText etId;

    AppDataBase db;
    UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        btnRead = findViewById(R.id.btnRead);
        btnClear = findViewById(R.id.btnClear);
        btnId = findViewById(R.id.btnId);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etEmail = findViewById(R.id.etEmail);
        etPhone= findViewById(R.id.etPhone);
        etId = findViewById(R.id.etId);

        db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "myDB").addMigrations(AppDataBase.MIGRATION_1_2, AppDataBase.MIGRATION_2_3).allowMainThreadQueries().build();
        userDao = db.userDao();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String surname = etSurname.getText().toString();
                String email = etEmail.getText().toString();
                String phone = etPhone.getText().toString();

                User user = new User();
                user.name = name;
                user.surname = surname;
                user.email = email;
                user.phone = phone;

                long id = userDao.insert(user);

                Log.d("SQL", "Add user id " + id);

                etName.setText("");
                etSurname.setText("");
                etEmail.setText("");
                etPhone.setText("");
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User> users = userDao.getAll();
                if (users.size() == 0) {
                    Log.d("SQL", "Empty");
                    return;
                }
                for (User user : users) {
                    Log.d("SQL", "ID " + user.id + ", full name " + user.name + " " + user.surname + ", email " + user.email+", phone "+user.phone);
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = userDao.clearAll();
                userDao.reset();
                Log.d("SQL", "Delete rows count " + count);
            }
        });

        btnId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etId.getText().toString();

                if(text.isEmpty()){
                    Log.d("SQL", "Enter id");
                    return;
                }
                int id = Integer.parseInt(text);
                int deleteCount = userDao.deleteById(id);
                if(deleteCount>0){
                    Log.d("SQL", "User delete by id "+id);
                }else{
                    Log.d("SQL", "User with id "+ id + " not found");
                }
                etId.setText("");
            }
        });

    }
}