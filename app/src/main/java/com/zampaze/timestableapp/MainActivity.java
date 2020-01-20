package com.zampaze.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public void submission(View view) {
        EditText txtEdit = (EditText) findViewById(R.id.editText);
        createList(grabInput(txtEdit), 100);
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }


    public int grabInput(EditText txtEdit) {
        String text = txtEdit.getText().toString();
        int num = Integer.parseInt(text);
        return num;
    }

    public void createList(int num, int listLimit) {
        // grab the listview
        ListView list = findViewById(R.id.listView);
        // clear before update if not first time
        list.setAdapter(null);
        // create an array of numbers
        Integer arr[] = new Integer[listLimit];
        arr[0] = 0;
        for (int i = 0; i < listLimit; i++) {
            arr[i] = num * i;
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, arr);

        list.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
