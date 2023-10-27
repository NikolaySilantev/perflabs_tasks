package org.example;

import java.util.ArrayList;

public class Test {

    private Integer id;
    private String title;
    private String value;
    private ArrayList<Test> values;

    public Test() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<Test> getValues() {
        return values;
    }

    public void setValues(ArrayList<Test> values) {
        this.values = values;
    }
}
