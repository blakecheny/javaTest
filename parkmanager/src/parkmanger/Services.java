package parkmanger;

import java.util.List;

import javax.swing.JInternalFrame;

public interface Services {

	
	public boolean create(Car car,Driver driver);
	public boolean delete(int id);
	public Car query(String carID);
	public boolean update(Car car);
	public List<String> queryAll();
	
}
