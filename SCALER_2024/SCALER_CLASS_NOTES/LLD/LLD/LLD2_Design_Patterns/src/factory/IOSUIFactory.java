package factory;


import factory.button.Button;
import factory.button.IOSButton;

import factory.dropdown.DropDown;
import factory.dropdown.IOSDropDown;

import factory.menu.IOSMenu;
import factory.menu.Menu;


public class IOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new IOSDropDown();
    }
}