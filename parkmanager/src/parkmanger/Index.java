package parkmanger;

import java.io.IOException;
import java.util.Scanner;

public class Index {

	 public static void main(String[] args) throws MyException{
		int tmp;
		
		while(true){//�����￪ʼ��
			System.out.println("��ӭ����blakeͣ����");
			System.out.println("1.�����Ǽ�");
			System.out.println("2.������ѯ");
			System.out.println("3.����checkout");
			System.out.println("4.������Ϣ����");
			System.out.println("��������Ĳ���");
			Scanner scanner = new Scanner(System.in);//java���õĴӿ���̨������
			tmp = scanner.nextInt();//����һ������
			switch (tmp) {//�ж�����һ��������Ȼ�������ز���
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
