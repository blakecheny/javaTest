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
	public void CheckIn() throws MyException{//添加操作
		Car car = new Car();//存放汽车信息的类
		Driver driver = new Driver();//存放驾驶员信息的类
		System.out.println("请输入车辆信息(车辆ID,车辆类型:");
		Scanner scanner = new Scanner(System.in);
		car.setCarID(scanner.nextLine());//将输入的一行字符串放到car的carid。下面的同理
		car.setCarType(scanner.nextLine());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		car.setParkTime(df.format(new Date()));
		
		System.out.println("请输入驾驶员信息(姓名，性别，身份证id，驾驶证id)：");
		driver.setName(scanner.nextLine());
		driver.setSex(scanner.nextLine());
		driver.setIDcard(scanner.nextLine());
		driver.setDirverCardID(scanner.nextLine());
		System.out.println("你输入的信息是："+car.toString() + "\n" + driver.toString());
		Services services = new ServicesDao();//接口回调（懂不起没关系）,
		services.create(car,driver);//这里就是调用service的方法
		
	}
	
	public  void CheckOut() throws IOException{
		System.out.println("请输入要出去车辆的id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		List<String> cars= services.queryAll();//将文件里面的内容全部放到 链表里面
		File file = new File("Info.txt");
		FileWriter write = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(write);
		out.write("");//将文件里面的内容全部删除
		out.close();//io流用了要关闭
		write.close();
		//我这里用了两次文件访问。因为要重写文件里面的内容 ，时间有限，我没有想到其他好的办法
		
		File file_1 = new File("Info.txt");
		FileWriter write_1 = new FileWriter(file_1,true);//后面那个true就是我用了两次访问文件的原因。有true的话，就是后面写文件
												//的时候是直接加到原有文件的后面，而不是将文件重写，上面没有true，所以out.write就用
												//空格将文件覆盖掉了。				
		BufferedWriter out_1 = new BufferedWriter(write_1);
		for(int i = 0 ; i<cars.size();i++){//循环链表，找到id和我们输入id相同的那个车
			String str = cars.get(i);
			StringTokenizer tmp = new StringTokenizer(str, " ");//因为链表里存的是字符串，所有用这个类将字符串解析，他会用空格将字符串
																//分割得到很多小的字符串
			String firstTmp = tmp.nextToken();//nexttoken就是指想下一个字符串。但这是是第一个。
			
			if(string.equals(firstTmp)){	//如果找到了和我们输入的id相等的信息。输出到控制台		
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
			    String time = df.format(new Date());
			    System.out.println("目前时间："+time);
			    System.out.println("checkout的车辆信息："+str);
			}
			else {
				out_1.write(str+"\r\n");//如果不是 和我们输入的相等的话就将字符串写到文件，\r\n就是文件中的换行符
			}
			
		}
		out_1.close();
		write_1.close();
	}
	
	public void QueryInfo(){
		System.out.println("请输入要查询的id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		if(services.query(string) == null){
			System.out.println("没有改车辆");
		}
		
	}
	
	public void UpdateInfo(){//这里的思想就是先输入我们要更新的车辆id，然后打印到控制台，然后再输入对应的信息重新写入到文件
		System.out.println("请输入要更新的id:");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		Services services = new ServicesDao();
		services.query(string);
		
		Car car = new Car();
		Driver driver = new Driver();
		System.out.println("请输入车辆信息(车辆ID,车辆类型:");
		car.setCarID(scanner.nextLine());
		car.setCarType(scanner.nextLine());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		car.setParkTime(df.format(new Date()));
		
		System.out.println("请输入驾驶员信息(姓名，性别，身份证id，驾驶证id)：");
		driver.setName(scanner.nextLine());
		driver.setSex(scanner.nextLine());
		driver.setIDcard(scanner.nextLine());
		driver.setDirverCardID(scanner.nextLine());
		System.out.println("你输入的信息是："+car.toString() + "\n" + driver.toString());
		List<String> cars= services.queryAll();
		try {
			File file = new File("Info.txt");
			FileWriter write = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(write);
			out.write("");
			out.close();
			write.close();
			//同样用了两次读文件，第一次将内容全部读入到链表，然后在将文件置空，在判断链表中是否有和我们输入的id号相等的数据，有的就将新的数据写入文件，没有还是直接
			//将链表中的字符串一条一条的写入到文件

			File file_1 = new File("Info.txt");
			FileWriter write_1 = new FileWriter(file_1,true);
			BufferedWriter out_1 = new BufferedWriter(write_1);
		
		for(int i = 0 ; i<cars.size();i++){
			String str = cars.get(i);
			StringTokenizer tmp = new StringTokenizer(str, " ");
			String firstTmp = tmp.nextToken();
			
			if(string.equals(firstTmp)){//就是判断是否和我们的输入id相等。
				String string_1 = car.getCarID() +"  " + car.getCarType() + "  " + driver.getName() + "  "
						+ driver.getSex() + "  " + driver.getIDcard() + "  " + driver.getDirverCardID()+ "  " + car.getParkTime()+"\r\n";
				//上面string_1就是将我们车辆和驾驶员的信息变成字符串
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
