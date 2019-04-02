package com.example.panczopc.todolist;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private Button applytxtbtn;
    private Button savebtn;
    private Switch switch1;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    private String text;
    private boolean switchonoff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        applytxtbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(editText.getText().toString());
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

            }
        });
        loadData();
        updateViews();
    }

    private void init(){
        textView = (TextView)findViewById(R.id.tv);
        editText = (EditText)findViewById(R.id.editText);
        applytxtbtn = (Button)findViewById(R.id.appbtn);
        savebtn = (Button)findViewById(R.id.savebtn);
        switch1 = (Switch)findViewById(R.id.switch1);


    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT,textView.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply();
        Toast.makeText(getApplicationContext(),"udało się",Toast.LENGTH_SHORT).show();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
        switchonoff =sharedPreferences.getBoolean(SWITCH1,false);
    }

    public void updateViews(){
        textView.setText(text);
        switch1.setChecked(switchonoff);
    }
}

// zrobione 01.04.19 M.P