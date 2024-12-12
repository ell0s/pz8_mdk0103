package com.example.pz8_mdk0103;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setPadding(16,16,16,16);
        textView.setTextSize(26);

        Bundle arg = getIntent().getExtras();

        if(arg!=null){
            String name = arg.getString("name");
            String company = arg.getString("company");
            int age = arg.getInt("age");
            String contact = arg.getString("contact");

            textView.setText("имя :"+name+"\nОрганизация :"+company+"\nВозраст: "+age+"\nПочта: "+contact);
        }


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setContentView(textView);
    }
}