import core.lang.Logger;


public class Test {

	public static void main(String[] args) {
		 int g = 2;
	      int b = "WKO".hashCode() % 3000;
	      int a = "EKD".hashCode() % 3000;
	      for (int w = 0; w <= a; w++)
	         g = (g ^ w) % b;
	      Logger.debug(g);
	}

}
