package com.dan.weather.holders;


public class Model {
    private String name;
    private boolean selected;
    private boolean hasClick;

    public Model(String name) {
        this.name = name;
        selected = false;
        hasClick = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isHasClick() {
        return hasClick;
    }

    public void setHasClick(boolean hasClick) {
        this.hasClick = hasClick;
    }
}
