package lv.olgerts.praktiskais3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import lv.olgerts.praktiskais3.R;

public class Activity2 extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView txtA2NameText = findViewById(R.id.txtA2Name);
        txtA2NameText.setText(getResources().getString(R.string.txt_a2_name));

        Button btnActivity1 = findViewById(R.id.btnActivity1);
        btnActivity1.setText(getResources().getString(R.string.btn_activity1));

        Button btnRead = findViewById(R.id.btnRead);
        btnRead.setText(getResources().getString(R.string.btn_read));

        sharedpreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String read = sharedpreferences.getString("nameKey","");
                EditText SharedPreferences = findViewById(R.id.ptxtSharedPreferences_read);
                SharedPreferences.setText(read);
            }
        });

        btnActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
