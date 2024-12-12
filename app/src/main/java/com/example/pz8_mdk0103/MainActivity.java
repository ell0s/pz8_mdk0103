package com.example.pz8_mdk0103;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClick(View v){
        EditText nameText = findViewById(R.id.name);
        EditText companyText = findViewById(R.id.company);
        EditText ageText = findViewById(R.id.age);
        EditText contactText = findViewById(R.id.contact);

        String name = nameText.getText().toString();
        String company = companyText.getText().toString();

        String contact = contactText.getText().toString();



        if (name.isEmpty()) {
            nameText.setError("Обязательное поле");
        } else if (!contact.contains("@")) {
            contactText.setError("Некорректная почта");
        } else if (!TextUtils.isDigitsOnly(ageText.getText())) {
            ageText.setError("Некорректный возраст");
        } else{
            int age = Integer.parseInt(ageText.getText().toString());
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("company", company);
            intent.putExtra("age", age);
            intent.putExtra("contact", contact);
            startActivity(intent);
        }


    }
}