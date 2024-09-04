package datastructure.designPattern.ChainResponsibility;

public class InfoLogProcessor extends LogProcessor{

	InfoLogProcessor(LogProcessor nextLogProcessor) {
		super(nextLogProcessor);
		
	}
	
	public void log(int logLevel,String msg){
		if(logLevel==Info){
			System.out.println("info");
		}else{
			System.out.println("Info can't handle request goes to nextProcessor via parent");
			super.log(logLevel,msg);
		}
			
	}
	

}
