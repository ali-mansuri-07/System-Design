package com.builderdesignpattern.directorbuilder;

public interface Builder {
    void setBread();
    void setPatty();
    void setCheese();
    void setSauce();
    Burger build();
}
