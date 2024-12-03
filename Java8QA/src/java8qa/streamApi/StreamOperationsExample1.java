package java8qa.streamApi;

import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.io.*;

public class StreamOperationsExample1 {

	public static void main(String[] args) {

		List<Integer> listNum = Arrays.asList(13, 3, 10, 20, 30, 15, 1, 13, 1, 2, 2, 10, 40, 19, 3, 40);
		//average
		System.out.println("the original list is: " + listNum + "\n");
		System.out.println("the average1: " +findAverage(listNum));
		System.out.println("the average2: " +calculateAvg(listNum));
		System.out.println("the average3: " +computeAverage(listNum));
		System.out.println("\nduplicate elements: " +findDuplicateNumbers(listNum));
		
		//maximum
		System.out.println("\n\nmaximum num: " +findMax(listNum));
		System.out.println("maximum num: " +fetchMaximumNumber(listNum));
		System.out.println("maximum num: " +calculateMaximumNumber(listNum));
		
		
		//minimum
		
		System.out.println("\n\nminimum num: " +findMinNum(listNum));
		System.out.println("minimum num: " +findMinimumNumber(listNum));
		System.out.println("minimum num: " +findMinimumNumber(listNum));
		
		//number starts with 2
		
		System.out.println("\nnumber starts with 2: " +findNumStartsWith2(listNum));
		
		//Sorting: Natural sorting
		System.out.println("\n\nNatural SOrting: " +sortingInAscendingOrder1(listNum));
		System.out.println("\nNatural SOrting: " +sortingInAscendingOrder2(listNum));
		
		//Sorting: Reverse sorting
		
		System.out.println("\n\nReverse SOrting: " +sortingInDescendingOrder1(listNum));
		System.out.println("\nReverse SOrting: " +sortingInDescendingOrder2(listNum));
		
		//first 5 numbers and last 5 numbers
		
		System.out.println("\n\nfirst 5 numbers: " +findFirst5Num(listNum));
		System.out.println("\nLast 5 numbers: " +findLast5Num(listNum));
		
		//total sum
		System.out.println("\n\ntotal sum: " +findTotalSum(listNum));
		
		//sum of first 5 numbers
		
		System.out.println("\n\nsum of first 5 numbers: " +findSumOfFIrst5Num(listNum));
		System.out.println("\nsum of last 5 numbers: " +findSumOfLast5Num(listNum));
		
		// 2nd lowest and highest number
		System.out.println("\n\n2nd highest number: " +findSecondHighestNumber(listNum));
		System.out.println("\n2nd lowest number: " +findSecondLowestNumber(listNum));

	}

	// 1.resource to find Average: approach-1
      public static double findAverage(List<Integer> l) {
    	  double avg=l.stream().mapToInt(e->e).summaryStatistics().getAverage();
    	  
    	  return avg;
      }
      
      //2. resource to find average: approach-2
      
      public static double calculateAvg(List<Integer> l) {
    	  
    	  double avg=l.stream().mapToInt(e->e).average().getAsDouble();
    	  
    	  return avg;
      }
      //3. resource to find average by using simple average formula
      public static double computeAverage(List<Integer> l) {
    	  
    	  int totalSum= (l.stream().reduce((a,b)->(a+b))).get();
    	  int totalNumberOfElements=l.size();
    	  double avg=(totalSum)/(totalNumberOfElements);
    	  return avg;
      }
      
      //4. resource to find duplicate 
      public static List<Integer> findDuplicateNumbers(List<Integer> l){
    	  List<Integer> dup=l.stream().filter(t->Collections.frequency(l, t)>1).collect(Collectors.toList());
    	  
    	  return dup;
      }
      //5.resource to find maximum number approach-1
      public static int findMax(List<Integer> l) {
    	  
    	  return l.stream().max(Comparator.comparing(e->Integer.valueOf(e))).get();
      }
      //6. resource to find maximum number approach-2
      public static int fetchMaximumNumber(List<Integer> l) {
    	  
    	  return l.stream().mapToInt(e->e).summaryStatistics().getMax();
      }
      //7. resource to find maximum number approach-3
      public static int calculateMaximumNumber(List<Integer> l) {
    	  return l.stream().sorted((a,b)->b.compareTo(a)).findFirst().get();
      }
      
      //8. resource to find minimum number approach-1
      
      public static int findMinNum(List<Integer> l ) {
    	  
    	  return l.stream().sorted((a,b)->a.compareTo(b)).findFirst().get();
      }
      
    //9. resource to find minimum number approach-2
      
      public static int findMiniumNum(List<Integer> l) {
    	  
    	  return l.stream().mapToInt(e->e).summaryStatistics().getMin();
      }
      
    //10. resource to find minimum number approach-3
      
      public static int findMinimumNumber(List<Integer> l) {
    	  
    	  return l.stream().min(Comparator.comparing(t->Integer.valueOf(t))).get();
      }
      
     //11. resource to find number starts with
      
      public static List<Integer> findNumStartsWith2(List<Integer> l){
    	  
    	  return l.stream().map(e->String.valueOf(e)).filter(e->e.startsWith("2"))
    			  .map(e->Integer.valueOf(e)).collect(Collectors.toList());
      }
      
      //12. resource to find list in ascending order: Natural Sorting: approach-1
       public static List<Integer> sortingInAscendingOrder1(List<Integer> l){
    	   
    	   return l.stream().sorted((a,b)->a.compareTo(b)).collect(Collectors.toList());
       }
       
     //13. resource to find list in ascending order: Natural Sorting: approach-2
       public static List<Integer> sortingInAscendingOrder2(List<Integer> l){
    	   
    	   return l.stream().sorted().collect(Collectors.toList());
       }
       
       //14. resource to find list in descending order: Reverse Sorting: approach-1
       
       public static List<Integer> sortingInDescendingOrder1(List<Integer> l){
    	    
    	   return l.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
       }
       
       //15. resource to find list in descending order: Reverse Sorting: approach-2
       public static List<Integer> sortingInDescendingOrder2(List<Integer> l){
    	   
    	   return l.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
       }
       
       //16. reource to find first 5 numbers
       public static List<Integer> findFirst5Num(List<Integer> l){
    	   return l.stream().limit(5).collect(Collectors.toList());
       }
       
     //17. resource to find last 5 numbers
       public static List<Integer> findLast5Num(List<Integer> l ){
    	   
    	   return l.stream().skip(l.size()-5).limit(5).collect(Collectors.toList());
       }
       
       //18. resource to find sum of the numbers in the list
       
       public static int findTotalSum(List<Integer> l ) {
    	   
    	   return l.stream().reduce((a,b)->(a+b)).get();
       }
       
       //19. resource to find sum of first 5 numbers in the list
       
       public static int findSumOfFIrst5Num(List<Integer> l) {
    	   
    	   return l.stream().limit(5).reduce((a,b)->(a+b)).get();
       }
       
     //20. resource to find sum of last numbers in the list
       public static int findSumOfLast5Num(List<Integer> l) {
    	   
    	   return l.stream().skip(l.size()-5).limit(5).reduce((a,b)->(a+b)).get();
       }
       
     //21. resource to find 2nd lowest and highest number
       public static int findSecondHighestNumber(List<Integer> l) {
    	   
    	   return l.stream().distinct().sorted(Collections.reverseOrder()).skip(1).findFirst().get();
       }
       
       public static int findSecondLowestNumber(List<Integer> l) {
    	   
    	   return l.stream().sorted().distinct().skip(1).limit(1).findFirst().get();
       }
       
}
