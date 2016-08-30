package com.uninorte.cardview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.orm.SugarContext;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private String TAG = "ELTag";
    ListView lv2;
    List<Persona> personas = new ArrayList<>();
    CustumeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SugarContext.init(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv2 = (ListView) findViewById(R.id.lv2);

        personas = Persona.listAll(Persona.class);
        adapter= new CustumeAdapter(this, personas);
        lv2.setAdapter(adapter);

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Persona alguien = personas.get(i);
                Intent intent = new Intent(getApplicationContext(), com.uninorte.cardview.ListView.class);
                intent.putExtra("person", (Serializable) alguien);
                intent.putExtra("tipo", "1");
                intent.putExtra("id", i);
                startActivity(intent);

            }
        });


    }
    public void onClickGo(View view) {
        Intent i = new Intent(this, com.uninorte.cardview.ListView.class);
        startActivityForResult(i,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                Persona persona = (Persona) data.getSerializableExtra("person");
                persona.save();
                personas = Persona.listAll(Persona.class);
                adapter= new CustumeAdapter(this, personas);
                lv2.setAdapter(adapter);


            }
        }


    }



}
