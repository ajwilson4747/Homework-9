import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap; 

public class Main {
	public static File myLRFile; 
	public static String fileLocation; 
	public static LinearRegression myLR; 
	public static View_Layout myLay; 
	public static void main(String[] args) {
		
		//create View obj
		myLay = new View_Layout();
		
		//create LinearRegression obj 
		myLR = new LinearRegression(0);	
	}
	
	/*
	 * private static int predictedForValue(int pFDV) { //PRELIMINARY WORK //VERIFY
	 *
	 * 
	 * }
	 * 
	 * int nValues = hourData.length; //sum the hour data sum bug data 
	 * double sumHourData = 0.0; double sumBugData = 0.0;
	 * 
	 * for (int i=0; i<hourData.length; i++) { sumHourData+=hourData[i]; }
	 * 
	 * for(int i=0; i<codeBugs.length; i++) { sumBugData +=codeBugs[i]; }
	 * 
	 * //compute the mean of the hours data values and the bug data values double
	 * hourDataBar = sumHourData/nValues; double bugDataBar = sumBugData/nValues;
	 * 
	 * 
	 * //compute the least squares regression line //subtract the hour mean value
	 * from the hour data values and square it double xxBar = 0.0; double xyBar =
	 * 0.0;
	 * 
	 * for(int i=0; i<nValues; i++) { xxBar += (hourData[i] - hourDataBar) *
	 * (hourData[i] - hourDataBar); xyBar +=(hourData[i] - hourDataBar) *
	 * (codeBugs[i] - bugDataBar); } //compute the slope and the intercept double
	 * slope = xyBar / xxBar; double intercept = bugDataBar - slope * hourDataBar;
	 * 
	 * //compute the predication double predictedBugs = intercept + slope * pFDV;
	 * return (int) predictedBugs; }
	 */

}
