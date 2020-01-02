package com.cool.wendao.admin.params;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {

    private String name;
    private String value;
    private boolean checked;
    private boolean disabled;
    private List<Node> list = new ArrayList<Node>();

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public List<Node> getList() {
        return list;
    }
    public void setList(List<Node> list) {
        this.list = list;
    }

}
