package factory;

import factory.button.Button;
import factory.dropdown.DropDown;
import factory.menu.Menu;

public class Client {
    public static void main(String[] args) {
        Flutter flutter=new Flutter(SupportedPlatforms.ANDROID);
        UIFactory uiFactory=flutter.createUIFactory();
        Button button=uiFactory.createButton();
        Menu menu=uiFactory.createMenu();
        DropDown dropDown=uiFactory.createDropDown();
        button.changeSize();

    }
}
