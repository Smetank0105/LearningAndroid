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

import java.util.ArrayList;

import kotlin.text.HexExtensionsKt;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button buttonAdd;
    private ListView listView;
    private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        buttonAdd = findViewById(R.id.buttonAdd);
        listView = findViewById(R.id.listView);

        items = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString();
                if(!item.isEmpty()){
                    items.add(item);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                items.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
    }
}