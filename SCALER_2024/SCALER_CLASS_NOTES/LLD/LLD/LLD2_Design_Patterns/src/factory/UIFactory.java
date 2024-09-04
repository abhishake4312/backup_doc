package factory;


import factory.button.Button;
import factory.dropdown.DropDown;
import factory.menu.Menu;

// createButton createMenu createDropDown are factory method that is declare in interface but different subclass will
// return different type of object of related class
public interface UIFactory {
    Button createButton();
    Menu createMenu();
    DropDown createDropDown();
}
