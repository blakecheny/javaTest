package parkmanger;

import java.io.IOException;
import java.util.Scanner;

public class Index {

	 public static void main(String[] args) throws MyException{
		int tmp;
		
		while(true){//从这里开始，
			System.out.println("欢迎来到blake停车场");
			System.out.println("1.车辆登记");
			System.out.println("2.车辆查询");
			System.out.println("3.车辆checkout");
			System.out.println("4.车辆信息更新");
			System.out.println("请输入你的操作");
			Scanner scanner = new Scanner(System.in);//java内置的从控制台输入类
			tmp = scanner.nextInt();//接受一个整数
			switch (tmp) {//判断是哪一个整数，然后进入相关操作
			case 1:
				new Control().CheckIn();
				break;
			case 2:
				new Control().QueryInfo();
				break;
			case 3:
				try {
					new Control().CheckOut();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				new Control().UpdateInfo();
			default:
				break;
			}
		}
		
		
	 }
}
