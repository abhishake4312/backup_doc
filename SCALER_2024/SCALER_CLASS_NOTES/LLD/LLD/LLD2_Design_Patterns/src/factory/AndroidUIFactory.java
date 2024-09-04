package factory;

import factory.button.*;

import factory.dropdown.AndroidDropDown;
import factory.dropdown.DropDown;
import factory.menu.AndroidMenu;
import factory.menu.Menu;


public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }

    @Override
    public DropDown createDropDown() {
        return new AndroidDropDown();
    }
}
