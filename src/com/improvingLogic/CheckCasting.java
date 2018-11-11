package com.improvingLogic;

class Parent{
	void methodOne(){
		System.out.println("INside method one of class A");
	}
}
class Child extends Parent{
	@Override
	void methodOne(){
		System.out.println("Inside methos sone of class B");
	}
}
public class CheckCasting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent a=new Parent();
		a.methodOne();
		Child b=new Child();
		b.methodOne();
		
		Parent ab=new Child();
		ab.methodOne();
		//Child ba= (Child)new Parent();
		//ba.methodOne();
	}

}
