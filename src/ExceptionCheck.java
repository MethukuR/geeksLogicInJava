public class ExceptionCheck {
	public static void main(String[] args) {
				
				try {
					System.out.println("i1 out");
					for (int i = 0; i <5; i++) {
						System.out.println("i2:"+i);
						if(i == 2){
							throw new Exception();
						}
						System.out.println("i3:"+i);
					}
					System.out.println("i4 out");
					
				} catch (Exception e) {
					System.out.println("Inside catch");
				}
				
		

	}

}
