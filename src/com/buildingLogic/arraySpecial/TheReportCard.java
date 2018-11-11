package com.buildingLogic.arraySpecial;
/**
 *  Problem: Priyanka is Professor at Zing University. Help the professor in assigning grades to her 
 *  students. 
	The mean score of three subjects is to graded into 'A', 'B', 'C' or 'D' or 'F' depending upon the 
	marks scored. 
	For the score >90 and score =<100, 'A' is graded. 
	For score >80 and score =<90, 'B' is graded. 
	For the score >70 and score <=80, 'C' is graded. 
	For the score >60 and score <=70, 'D' is graded. 
	For the score =< 60  'F' is graded. 
	Input: Input contains the marks obtained by student in 3 subjects separated by a space.
	Output: Output should be the grade scored by the student.
	Constraints: 0 ≤ Marks obtained in each subject ≤ 100 
	Sample Input: 100 75 54
	Sample Output: 
	C
 * @author Raju Rockzz :P
 *
 */
public class TheReportCard {

	public static void main(String[] args) {
		int[] marks={100,75,54};
		char grade=findGrade(marks);
		System.out.println("Grade : "+grade);
	}
	
	static char findGrade(int[] marks){
		int sum=0;
		char grade;
		for (int i = 0; i < 3; ++i) {
			sum+=marks[i];
		}
		int mean=(sum/3);
		if( mean > 90 && mean <=100){
			grade='A';
		}
		else if( mean > 80 && mean <=90){
			grade='B';
		}
		else if( mean > 70 && mean <=80){
			grade='C';
		}
		else if( mean > 60 && mean <=70){
			grade='D';
		}
		else {
			grade='F';
		}
		
		return grade;
	}

}
