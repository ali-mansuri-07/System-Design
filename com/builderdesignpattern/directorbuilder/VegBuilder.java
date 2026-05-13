package com.builderdesignpattern.directorbuilder;

public class VegBuilder implements Builder {
    private Burger burger;

    public VegBuilder() {
        this.burger = new Burger();
    }

    @Override
    public void setBread() {
        burger.setBread("Whole Wheat");
    }

    @Override
    public void setPatty() {
        burger.setPatty("Veggie Patty");
    }

    @Override
    public void setCheese() {
        burger.setCheese("Cheddar");
    }

    @Override
    public void setSauce() {
        burger.setSauce("Mayo");
    }

    @Override
    public Burger build() {
        return this.burger;
    }
}
