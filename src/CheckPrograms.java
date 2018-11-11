import java.util.Scanner;


public class CheckPrograms {

	public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        
        int i1=scan.nextInt();
        
        double d2= scan.nextDouble();
        scan.nextLine();
        String s2=scan.nextLine();

        

        System.out.println(i+i1);

        System.out.println(d+d2);

        System.out.println(s+s2);
        
        
	}
	
	private static void checkPerfect(double d)
	{
		double x;
		for(int i=1;i<=d/2;++i)
		{
			x=d*i;
			int copy=(int)x;
			if(x-copy==0)
			{
			System.out.println(i);
			break;
			}
		}
		
	}
	
	private static void pattern2(int a){
		int i,j,k;
		for ( i = 0; i < a; i++){ 
			for ( j = 0; j < a - i; j++){ 
				System.out.print(" ");
			} 
			for ( k = 0; k <= i; k++) { 
				System.out.print("* ");
			} 
			System.out.println();
		}

	}
	
	private static void pattern3(int a) {
        int i, j, k;
        for (i = 1; i <= a; i++) {
            for (j = 0; j < a - i; j++) {
                System.out.print(" ");
            }
            for (k = 0; k < i; k++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
	
	private static void pattern4(int a) {
        int i, j, k;
        for (i = 1; i <= a; i++) {
            for (j = 0; j < a - i; j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();

        }
    }
	
	private static void pattern5(int a) {
        int i, j, k;
        for (i = a; i > 0; i--) {
            for (k = 0; k < a - i; k++) {
                System.out.print(" ");
            }
            for (j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
