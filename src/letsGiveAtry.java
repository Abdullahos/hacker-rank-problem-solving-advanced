
public class letsGiveAtry {

	static int mostProbIndexOfMAx(int[][] queries) {
        int a;
        int b;
        int avrIndex = 0;
	        for(int i = 0; i <queries.length; i++){
	            a = queries[i][0]-1;
	            b = queries[i][1]-1;
	            avrIndex = avrIndex+ b-a;  
	        }
	        avrIndex = avrIndex/queries.length;
		return avrIndex;
		}
	static long arrayManipulation(int n, int[][] queries) {
		int a;
        int b;
        int k;
        long sum = 0;
        int mostProb = mostProbIndexOfMAx(queries);
		for(int i = 0; i <queries.length; i++){
            a = queries[i][0]-1;
            b = queries[i][1]-1;
            k = queries[i][2];
            
            if(mostProb>=a && mostProb<=b)
	            sum = sum + k;
		}
		return sum;
}
