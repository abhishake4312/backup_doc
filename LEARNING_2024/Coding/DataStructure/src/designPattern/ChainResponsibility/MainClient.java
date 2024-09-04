package designPattern.ChainResponsibility;

public class MainClient {

	public static void main(String args[]){
		
		LogProcessor logObj= new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
		
		logObj.log(LogProcessor.Error, "this is error log");
		
		logObj.log(LogProcessor.Info, "this is error log");
		logObj.log(LogProcessor.Debug, "this is error log");
		
		logObj.log(4, "this is can't handled log");
	}
}
