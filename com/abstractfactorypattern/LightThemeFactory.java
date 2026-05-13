package com.abstractfactorypattern;

public class LightThemeFactory implements AbstractUiFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
    
}