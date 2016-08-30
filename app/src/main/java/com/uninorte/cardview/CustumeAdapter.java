package com.uninorte.cardview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23/08/16.
 */
public class CustumeAdapter extends BaseAdapter {

    private Context activity;
    private List<Persona> items;

    public CustumeAdapter (Context activity, List<Persona> items) {
        this.activity = activity;
        this.items = items;
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Persona> persona) {
        for (int i = 0; i < persona.size(); i++) {
            items.add(persona.get(i));
        }
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inf.inflate(R.layout.cardview, null);
        }

        Persona dir = items.get(i);

        TextView name = (TextView) view.findViewById(R.id.textviewname);
        name.setText(dir.getName());

        TextView lastname = (TextView) view.findViewById(R.id.textviewlastname);
        lastname.setText(dir.getLastname());

        TextView age = (TextView) view.findViewById(R.id.textviewage);
        age.setText(dir.getAge());

        return view;
    }

    public interface CardviewClickListener{

        public void itemClick(View view, int i);
    }
}
