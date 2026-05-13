package com.builderdesignpattern.directorbuilder;

// Director.java — Controls the build sequence
class Director {
    private Builder builder;

    Director(Builder builder) {
        this.builder = builder;
    }

    // Same build sequence — different builder = different burger
    public Burger construct() {
        builder.setBread();
        builder.setPatty();
        builder.setCheese();
        builder.setSauce();
        return builder.build();
    }
}