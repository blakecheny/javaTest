package parkmanger;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class test {

	@Test
	public void test() {
		Date endDate= new Date();
		Date nowDate = new Date();
		long diff = endDate.getTime() - nowDate.getTime();
		System.out.println(nowDate.getTime());
		System.out.println(diff);
	}

}
