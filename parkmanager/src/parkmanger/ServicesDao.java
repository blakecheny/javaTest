package parkmanger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.transform.Templates;

public class ServicesDao implements Services{

	@Override
	public boolean create(Car car,Driver driver) {
		String string = car.getCarID() +"  " + car.getCarType() + "  " + driver.getName() + "  "
						+ driver.getSex() + "  " + driver.getIDcard() + "  " + driver.getDirverCardID()+ "  " + car.getParkTime()+"\r\n";
		try {
			File file = new File("Info.txt");
			FileWriter write = new FileWriter(file,true);
			BufferedWriter out = new BufferedWriter(write);
			out.write(string);
			out.close();
			write.close();
			
		} catch (IOException e) {
			System.out.println("文件写入出错");
			e.printStackTrace();
		}
		

		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car query(String carId) {
		Car car = new Car();
		try {
			File file = new File("Info.txt");
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String string;
			while ((string = in.readLine()) != null) {
				StringTokenizer tmp = new StringTokenizer(string, " ");
				String firstTmp = tmp.nextToken();
				if(carId.equals(firstTmp)){
					car.setCarID(carId);
					while(tmp.hasMoreTokens()){
						car.setCarType(tmp.nextToken());
					}
					System.out.println("车辆ID，车辆类型，驾驶员姓名，性别，身份证id，驾驶证id");
					System.out.println(string);
					break;
				}
			}
			
			in.close();
			reader.close();
		} catch (IOException e) {
			System.out.println("查询出错");
			e.printStackTrace();
		}
		return car;
	}



	@Override
	public List<String> queryAll() {
		int panduan = 0;
		List<String> strings = new ArrayList<String>();
		Car car = new Car();
		try {
			File file = new File("Info.txt");
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String string;
			while ((string = in.readLine()) != null) {
				strings.add(string);
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return strings;
	}

	@Override
	public boolean update(Car car) {
		// TODO Auto-generated method stub
		return false;
	}

}
