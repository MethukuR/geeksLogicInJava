package com.shapes;

public class PrintEllipse {

	public static void main(String[] args) {
		printKite("HAPPY NEW YEAR");
		printCake();
		printKite("HAPPY PONGAL");
	}

	private static void printKite(String message) {
		int n = 5;
		int i, j, k, sp, space = n - 1;
		String prt = "$";

		/*
		 * ************************ First two lines*
		 * ***************************************
		 */
		for (int l = 0; l < 2; l++) {
			for (int l2 = 0; l2 < 50; l2++) {
				System.out.print(".  ");
			}
			System.out.println();
		}
		/*
		 * ************************* First two lines *
		 ****************************************/

		/*
		 * ************************************** Printing top half of kite
		 ******************/
		for (i = 1; i <= n; i++) {

			/*
			 * Handled this manually because we have custom message to be printed Raju ..
			 * your logic is not up to the mark.... you have to improve
			 */
			if (i == n) {
				System.out.print(
						".  .  .  .  .  .  .  .  .  .  $      "+ message+"      $  .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .   .");
				break;
			}

			// For left indentation
			for (sp = space + 10; sp >= 1; sp--) {
				System.out.print(".  ");
			}
			// For left indentation

			// For printing left half of top part of kite
			for (j = 1; j <= i; j++) {
				if (j == 1) {
					System.out.print(prt);
				} else {
					System.out.print(" ");
				}
			}
			// For printing left half of top part of kite

			// For printing right half of top part of kite
			for (k = 1; k <= (i - 1); k++) {
				if (i == 1) {
					continue;
				}

				if (k == i - 1) {
					System.out.print("     " + prt);
				} else {
					System.out.print("     ");
				}
			}
			// For printing right half of top part of kite

			// For right indentation
			for (sp = space + 30; sp >= 1; sp--) {
				System.out.print("   .");
			}
			// For right indentation

			System.out.println();
			space--;
		}

		/*
		 * ************************************** Printing top half of kite
		 ******************/

		/*
		 * ************************************* Printing bottom half of kite
		 ******************/
		space = 1;
		System.out.println();
		for (i = n - 1; i >= 1; i--) {

			// For left indentation
			for (sp = space + 10; sp >= 1; sp--) {
				System.out.print(".  ");
			}
			// For left indentation

			for (j = 1; j <= i; j++) {
				if (j == 1) {
					System.out.print(prt);
				} else {
					System.out.print(" ");
				}
			}

			for (k = 1; k <= (i - 1); k++) {
				if (k == i - 1) {
					System.out.print("     " + prt);
				} else {
					System.out.print("     ");
				}
			}

			// For right indentation
			for (sp = space + 30; sp >= 1; sp--) {
				System.out.print("   .");
			}
			// For right indentation

			space++;
			System.out.println();
		}

		/*
		 * ************************************** Printing bottom half of kite
		 ******************/

		space = n / 2 - 1;

		for (i = n / 2 - 1; i <= n; i++) {
			if (i == n / 2 - 1) {
				continue;
			}
			if ((i % 2) != 0) {
				// For left indentation
				for (sp = space + 11; sp >= 1; sp--) {
					System.out.print(".  ");
				}
				// For left indentation

				for (j = 1; j <= i; j++) {
					System.out.print("   " + prt);
				}

				// For right indentation
				for (sp = space + 30; sp >= 1; sp--) {
					System.out.print("   .");
				}
				// For right indentation
			}

			if ((i % 2) != 0) {
				System.out.println();
				space--;
			}
		}
		
		/* ************************* Last two lines ******************************************/
		for (int l = 0; l < 2; l++) {
			for (int l2 = 0; l2 < 50; l2++) {
				System.out.print(".  ");
			}
			System.out.println();
		}
		/* ************************** Last two lines *****************************************/
		
		
	}

	private static void printCake() {
		String dots = ".  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .  .";
		System.out.println(dots+ "\t     *        *        *\t"+dots);
		System.out.println(dots + "\t    ***      ***      ***\t"+dots);
		for (int x = 0; x < 3; x++) {
			System.out.println(dots + "\t    |-|      |-|      |-|\t"+dots);
		}
		System.out.println(dots + "\t____|-|______|-|______|-|___\t"+dots);
		System.out.println(dots + "\t|==========================|\t"+dots);
		for (int x = 0; x < 2; x++) {
			System.out.println(dots + "\t|      HAPPY BIRTHDAY      |\t"+dots);
			System.out.println(dots + "\t|~~~~~~~~~~~~~~~~~~~~~~~~~~|\t"+dots);
		}
		System.out.println(dots + "\t|__________________________|\t"+dots);
		System.out.println(dots + "\t\t🎶🎶🎶🎶🎶🎶🎶"+dots);
	}
}
