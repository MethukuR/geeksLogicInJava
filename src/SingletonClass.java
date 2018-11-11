/**
 * Reference : http://www.java2novice.com/java_constructor_examples/singleton/
 * 
 * Java Singleton Class Example Using Private Constructor 
 * We can make constructor as private. So that We can not create an object outside of the
 * class. This property is useful to create singleton class in java. Singleton
 * pattern helps us to keep only one instance of a class at any time. The
 * purpose of singleton is to control object creation by keeping private
 * constructor. 
 * 
 * @author Raju Rockzz :P
 *
 */
public class SingletonClass {
	private static SingletonClass mySingletonObj;

	private SingletonClass() {

	}

	/**
	 * Create a static method to get instance.
	 */
	public static SingletonClass getInstance() {
		if (mySingletonObj == null) {
			mySingletonObj = new SingletonClass();
		}
		return mySingletonObj;
	}

	public void getSomeThing() {
		// do something here
		System.out.println("I am here....");
	}

	public static void main(String[] args) {
		SingletonClass singletonClass = new SingletonClass();
		singletonClass.getSomeThing();

	}

}
