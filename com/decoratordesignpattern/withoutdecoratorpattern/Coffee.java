package com.decoratordesignpattern.withoutdecoratorpattern;

// Problem: Class explosion due to inheritance for every combination of features

// BAD — using inheritance to add features
// Class explosion! Every combination needs a new class
class Coffee { }
class CoffeeWithMilk extends Coffee { }
class CoffeeWithSugar extends Coffee { }
class CoffeeWithMilkAndSugar extends Coffee { }
class CoffeeWithMilkAndCaramel extends Coffee { }
class CoffeeWithSugarAndCaramel extends Coffee { }
class CoffeeWithMilkAndSugarAndCaramel extends Coffee { } // endless!
