package com.academy.learningandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kotlin.text.HexExtensionsKt;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));
        contacts.add(new Contact("Ivan Ivanov", "1234567890", R.drawable.ic_launcher_background));
        contacts.add(new Contact("Boris Borisov", "0987654321", R.drawable.ic_launcher_foreground));

        adapter = new ContactAdapter(MainActivity.this, contacts);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
    }
}