package datastructure.designPattern.ChainResponsibility;

public class DebugLogProcessor extends LogProcessor{
 
	DebugLogProcessor(LogProcessor nextLogProcessor){
		super(nextLogProcessor);
	}
	
	public void log(int logLevel,String msg){
		if(logLevel==Debug){
			System.out.println("debug");
		}else{
			System.out.println("DEBUG cannot handle request goes to error via parent");
			super.log(logLevel,msg);
		}
	}
}
