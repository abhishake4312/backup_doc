package factory;

public class Flutter {

   private  SupportedPlatforms supportedPlatforms;
   public Flutter(SupportedPlatforms supportedPlatforms){
        this.supportedPlatforms = supportedPlatforms;
    }

    public void refreshRate(){

    }

// As in the flutter we are voilating OCP so create a simple Factory of UIFactory which will return UIFactory
//    UIFactory createUIFactory(){
//       if(supportedPlatforms == SupportedPlatforms.ANDROID){
//           return new AndroidUIFactory();
//       }else if(supportedPlatforms == SupportedPlatforms.IOS){
//           return new IOSUIFactory();
//       }
//       return null;
//    }
    UIFactory createUIFactory(){
       return UIFactoryFactory.getUIFactory(supportedPlatforms);
    }
}
