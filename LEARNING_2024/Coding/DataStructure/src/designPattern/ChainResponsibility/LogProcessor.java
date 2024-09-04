package designPattern.ChainResponsibility;

public abstract class LogProcessor {
 
	public static int Info = 1;
	public static int Debug=2;
	public static int Error=3;
	
	LogProcessor nextLogProcessor;
	
	LogProcessor(LogProcessor logprocessor){
		this.nextLogProcessor=logprocessor;
	}
	
	public void log(int logLevel, String msg){
		if(nextLogProcessor!=null){
			System.out.println("nextLogProcessor called "+nextLogProcessor);
			nextLogProcessor.log(logLevel, msg);
		}
	}
	
}
