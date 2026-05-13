package com.builderdesignpattern.directorbuilder;

// Burger.java — Product
class Burger {
    private String bread;
    private String patty;
    private String cheese;
    private String sauce;

    public void setBread(String bread)   { this.bread  = bread; }
    public void setPatty(String patty)   { this.patty  = patty; }
    public void setCheese(String cheese) { this.cheese = cheese; }
    public void setSauce(String sauce)   { this.sauce  = sauce; }

    @Override
    public String toString() {
        return "Burger {" +
               " bread=" + bread +
               ", patty=" + patty +
               ", cheese=" + cheese +
               ", sauce=" + sauce + " }";
    }
}