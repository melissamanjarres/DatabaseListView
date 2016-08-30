package com.uninorte.cardview;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by admin on 23/08/16.
 */
public class Persona extends SugarRecord implements Serializable{

    private String name;
    private String lastname;
    private String age;


    public Persona() {}


    public Persona( String name, String lastname, String age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAge(){
        return age;
    }

    public void setAge(String age){
        this.age = age;
    }
}
