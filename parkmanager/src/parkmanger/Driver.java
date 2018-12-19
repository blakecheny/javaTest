package parkmanger;


public class Driver {
   private  String IDcard;
   private String name;
   private String sex;
   private String dirverCardID;
public String getIDcard() {
	return this.IDcard;
}
public void setIDcard(String iDcard) {
	IDcard = iDcard;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getDirverCardID() {
	return dirverCardID;
}
public void setDirverCardID( String dirverCardID) {
	this.dirverCardID = dirverCardID;
}

public Driver (){}
public Driver(String iDcard, String name, String sex,  String dirverCardID) {
	super();
	IDcard = iDcard;
	this.name = name;
	this.sex = sex;
	this.dirverCardID = dirverCardID;
}
@Override
public String toString() {
	return "Dirver [IDcard=" + IDcard + ", name=" + name + ", sex=" + sex
			+ ", dirverCardID=" + dirverCardID + "]";
}
  
}
