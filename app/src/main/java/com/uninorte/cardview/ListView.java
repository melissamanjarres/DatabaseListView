package com.uninorte.cardview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class ListView extends Activity {
    EditText etname;
    EditText etlastname;
    EditText etage;
    private String TAG = "TAG";
    Button playButton;
    private int mess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        etname = (EditText) findViewById(R.id.etname);
        etlastname = (EditText) findViewById(R.id.etlastname);
        etage = (EditText) findViewById(R.id.etage);
        playButton = (Button) findViewById(R.id.button);

        try {
            Intent intent = getIntent();
            String message = intent.getStringExtra("tipo");
            mess = intent.getIntExtra("id", -1);
            Persona persona = (Persona) intent.getSerializableExtra("person");
            if (message.equals("1")) {
                etname.setFocusable(false);
                etlastname.setFocusable(false);
                etage.setFocusable(false);
                etname.setText(persona.getName());
                etlastname.setText(persona.getAge());
                etage.setText(persona.getAge());
                playButton.setVisibility(View.INVISIBLE);
            }
        } catch (Exception e){

        }



    }

    public void onClickSave(View view) {
        Persona persona = new Persona();
        persona.setName(etname.getText().toString());
        persona.setLastname(etlastname.getText().toString());
        persona.setAge(etage.getText().toString());
        Intent returnIntent = new Intent();
        returnIntent.putExtra("person", (Serializable) persona);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }


    public void onClickBack(View view) {
        Intent intent = getIntent();
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
