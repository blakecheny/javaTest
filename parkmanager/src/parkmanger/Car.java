package parkmanger;

import java.util.Date;

public class Car {
   private String carID;
   private String carType;
   private String parkStartTime;
   
public String getCarID() {
	return carID;
}
public void setCarID(String carID) {
	this.carID = carID;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
public String getParkTime() {
	return getParkStartTime();
}
public void setParkTime(String string) {
	this.setParkStartTime(string);
}
public Car(){}

public Car(String carID, String carType, Date parkTime) {
	super();
	this.carID = carID;
	this.carType = carType;
	
}
@Override
public String toString() {
	return "Car [carID=" + carID + ", carType=" + carType + ", parkStartTime="
			+ getParkStartTime() + "]";
}
public String getParkStartTime() {
	return parkStartTime;
}
public void setParkStartTime(String string) {
	this.parkStartTime = string;
}
   
   		
}
