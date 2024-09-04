package designPattern.ChainResponsibility;

public class ErrorLogProcessor extends LogProcessor{

	ErrorLogProcessor(LogProcessor logprocessor) {
		super(logprocessor);
		// TODO Auto-generated constructor stub
	}
	
	public void log(int logLevel,String msg){
		if(logLevel==Error){
			System.out.println("error");
		}else{
			System.out.println("error can't handle it so this request can't be handled");
			super.log(logLevel,msg);
		}
	}

}
