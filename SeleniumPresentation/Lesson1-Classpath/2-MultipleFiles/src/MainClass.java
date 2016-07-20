import second_package.SecondClass;

public class MainClass {
	String name = "Main Class";

	public static void main(String[] args) {
		SecondClass secondary = new SecondClass();
		secondary.sayHello();
	}
}
