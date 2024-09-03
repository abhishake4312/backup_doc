package factory;

public class UIFactoryFactory {

    //Practical Factory
    // A method that returns object of same class
   public static UIFactory getUIFactory(SupportedPlatforms supportedPlatforms){
        if(supportedPlatforms==SupportedPlatforms.ANDROID){
            return new AndroidUIFactory();
        }else if(supportedPlatforms==SupportedPlatforms.IOS){
            return new IOSUIFactory();
        }
        return null;
    }
}
