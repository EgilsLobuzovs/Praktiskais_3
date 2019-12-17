package lv.olgerts.praktiskais3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lv.olgerts.praktiskais3.R;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtA1NameText = findViewById(R.id.txtA1Name);
        txtA1NameText.setText(getResources().getString(R.string.txt_a1_name));

        Button btnActivity2 = findViewById(R.id.btnActivity2);
        btnActivity2.setText(getResources().getString(R.string.btn_activity2));

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setText(getResources().getString(R.string.btn_save));

        final EditText ed1 = findViewById(R.id.ptxtSharedPreferences);

        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);


        btnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n  = ed1.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("nameKey", n);
                editor.commit();
                Toast.makeText(MainActivity.this, "Saglabāts" ,Toast.LENGTH_LONG).show();
                EditText SharedPref = findViewById(R.id.ptxtSharedPreferences);
                SharedPref.setText(getResources().getString(R.string.shared_preferences));
            }
        });
    }
}
