package parkmanger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.WriteAbortedException;
import java.security.Provider.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.sound.midi.VoiceStatus;

public class Control {
	public void CheckIn() throws MyException{//��Ӳ���
		Car car = new Car();//���������Ϣ����
		Driver driver = new Driver();//��ż�ʻԱ��Ϣ����
		System.out.println("�����복����Ϣ(����ID,��������:");
		Scanner scanner = new Scanner(System.in);
		car.setCarID(scanner.nextLine());//�������һ���ַ����ŵ�car��carid�������ͬ��
		car.setCarType(scanner.nextLine());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		car.setParkTime(df.format(new Date()));
		
		System.out.println("�������ʻԱ��Ϣ(�������Ա����֤id����ʻ֤id)��");
		driver.setName(scanner.nextLine());
		driver.setSex(scanner.nextLine());
		driver.setIDcard(scanner.nextLine());
		driver.setDirverCardID(scanner.nextLine());
		System.out.println("���������Ϣ�ǣ�"+car.toString() + "\n" + driver.toString());
		Services services = new ServicesDao();//�ӿڻص���������û��ϵ��,
		services.create(car,driver);//������ǵ���service�ķ���
		
	}
	
	public  void CheckOut() throws IOException{
		System.out.println("������Ҫ��ȥ������id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		List<String> cars= services.queryAll();//���ļ����������ȫ���ŵ� ��������
		File file = new File("Info.txt");
		FileWriter write = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(write);
		out.write("");//���ļ����������ȫ��ɾ��
		out.close();//io������Ҫ�ر�
		write.close();
		//���������������ļ����ʡ���ΪҪ��д�ļ���������� ��ʱ�����ޣ���û���뵽�����õİ취
		
		File file_1 = new File("Info.txt");
		FileWriter write_1 = new FileWriter(file_1,true);//�����Ǹ�true�������������η����ļ���ԭ����true�Ļ������Ǻ���д�ļ�
												//��ʱ����ֱ�Ӽӵ�ԭ���ļ��ĺ��棬�����ǽ��ļ���д������û��true������out.write����
												//�ո��ļ����ǵ��ˡ�				
		BufferedWriter out_1 = new BufferedWriter(write_1);
		for(int i = 0 ; i<cars.size();i++){//ѭ�������ҵ�id����������id��ͬ���Ǹ���
			String str = cars.get(i);
			StringTokenizer tmp = new StringTokenizer(str, " ");//��Ϊ�����������ַ���������������ཫ�ַ��������������ÿո��ַ���
																//�ָ�õ��ܶ�С���ַ���
			String firstTmp = tmp.nextToken();//nexttoken����ָ����һ���ַ������������ǵ�һ����
			
			if(string.equals(firstTmp)){	//����ҵ��˺����������id��ȵ���Ϣ�����������̨		
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//���ڸ�ʽ
			    String time = df.format(new Date());
			    System.out.println("Ŀǰʱ�䣺"+time);
			    System.out.println("checkout�ĳ�����Ϣ��"+str);
			}
			else {
				out_1.write(str+"\r\n");//������� �������������ȵĻ��ͽ��ַ���д���ļ���\r\n�����ļ��еĻ��з�
			}
			
		}
		out_1.close();
		write_1.close();
	}
	
	public void QueryInfo(){
		System.out.println("������Ҫ��ѯ��id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		if(services.query(string) == null){
			System.out.println("û�иĳ���");
		}
		
	}
	
	public void UpdateInfo(){//�����˼���������������Ҫ���µĳ���id��Ȼ���ӡ������̨��Ȼ���������Ӧ����Ϣ����д�뵽�ļ�
		System.out.println("������Ҫ���µ�id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		services.query(string);
		
		Car car = new Car();
		Driver driver = new Driver();
		System.out.println("�����복����Ϣ(����ID,��������:");
		car.setCarID(scanner.nextLine());
		car.setCarType(scanner.nextLine());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		car.setParkTime(df.format(new Date()));
		
		System.out.println("�������ʻԱ��Ϣ(�������Ա����֤id����ʻ֤id)��");
		driver.setName(scanner.nextLine());
		driver.setSex(scanner.nextLine());
		driver.setIDcard(scanner.nextLine());
		driver.setDirverCardID(scanner.nextLine());
		System.out.println("���������Ϣ�ǣ�"+car.toString() + "\n" + driver.toString());
		List<String> cars= services.queryAll();
		try {
			File file = new File("Info.txt");
			FileWriter write = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(write);
			out.write("");
			out.close();
			write.close();
			//ͬ���������ζ��ļ�����һ�ν�����ȫ�����뵽����Ȼ���ڽ��ļ��ÿգ����ж��������Ƿ��к����������id����ȵ����ݣ��еľͽ��µ�����д���ļ���û�л���ֱ��
			//�������е��ַ���һ��һ����д�뵽�ļ�

			File file_1 = new File("Info.txt");
			FileWriter write_1 = new FileWriter(file_1,true);
			BufferedWriter out_1 = new BufferedWriter(write_1);
		
		for(int i = 0 ; i<cars.size();i++){
			String str = cars.get(i);
			StringTokenizer tmp = new StringTokenizer(str, " ");
			String firstTmp = tmp.nextToken();
			
			if(string.equals(firstTmp)){//�����ж��Ƿ�����ǵ�����id��ȡ�
				String string_1 = car.getCarID() +"  " + car.getCarType() + "  " + driver.getName() + "  "
						+ driver.getSex() + "  " + driver.getIDcard() + "  " + driver.getDirverCardID()+ "  " + car.getParkTime()+"\r\n";
				//����string_1���ǽ����ǳ����ͼ�ʻԱ����Ϣ����ַ���
				System.out.print(string_1);
				out_1.write(string_1+"\r\n");
				
			}
			else {
				out_1.write(str+"\r\n");
			}
			
		}
		out_1.close();
		write_1.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
