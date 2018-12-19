package parkmanger;

public class  MyException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public MyException() {
	}

	public void showMessage(String str){
        System.out.println(str);
    }

}
