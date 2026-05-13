package com.builderdesignpattern.directorbuilder;

// NonVegBurgerBuilder.java — Concrete Builder 2
class NonVegBurgerBuilder implements Builder {
    private Burger burger = new Burger();

    public void setBread()  { burger.setBread("Sesame Bun"); }
    public void setPatty()  { burger.setPatty("Chicken Patty"); }
    public void setCheese() { burger.setCheese("Double Cheese"); }
    public void setSauce()  { burger.setSauce("BBQ Sauce"); }
    public Burger build()   { return burger; }
}
