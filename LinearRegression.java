public class LinearRegression extends View_Layout {
	private int nValues; //sum the hour data sum bug data double
	private int sumHourData; 
	private int sumBugData; 
	private int hourDataBar; 
	private int bugDataBar;
	private int nE;
	private int xxBar; 
	private int xyBar;
	
	public LinearRegression(int n) {
		this.nE = n;
		nValues = View_Layout.myHashMap.size();
		sumHourData =0; 
		sumBugData =0; 
	}
	
	public int meanOfHours() {
		 
		 	  for (Integer key : myHashMap.keySet()) { 
		 		  sumHourData+=key; }
		 	 
		 	  return sumHourData /nValues;
		 	
	}
	
	public int meanOfBugs() {
		
		for(Integer key: myHashMap.keySet()) { 
		 		  sumBugData +=myHashMap.get(key); }
		
		return sumBugData/nValues;
		
	}
	
	public int computeLSRL(int nE) {
		//compute the least squares regression line 
		//subtract the hour mean value
		//from the hour data values and square it 
	  xxBar = 0;  xyBar =0;
	  
	  for(Integer key : myHashMap.keySet()) {
		  xxBar += (key - hourDataBar) * (key- hourDataBar);
		  xyBar +=(key - hourDataBar) *(myHashMap.get(key) - bugDataBar); } //compute the slope and the intercept double
	  	 int slope = xyBar / xxBar; 
	  	 int intercept = bugDataBar - slope * hourDataBar;
	  
	  //compute the predication 
	  	 int predictedBugs = intercept + slope * nE;
	 
	  	 return predictedBugs;
	}
	  

	   
	  
	  
	  
	
}
