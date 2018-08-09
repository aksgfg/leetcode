// link : https://leetcode.com/problems/maximum-subarray/description/ 
// improvment from the previous version. use dictionary instead of 
// 2-d array 
import java.util.Hashtable;
class Solution {
    public int maxSubArray(int[] nums) {
    //initiallizing the lookup array at the diagonals 
    Hashtable<String,Integer> lookup = new Hashtable<String,Integer>();  
    int max = nums[0];
    int imax ,jmax;
    for(int k= 0; k<nums.length; k++){
      lookup.put(at(k,k), nums[k]);
      if(max < nums[k]){
        max = nums[k];
        imax = jmax = k;
      }
    }
    //traversing the subarray
    // i rows and j columns
    //the sum rule ; sum(i,j) = sum(i,j-1)+sum(j,j) for all i>j
    for(int i = 0; i < nums.length; i++)
    {
      for(int j = i+1; j < nums.length; j++){
        lookup.put(at(i,j), lookup.get(at(i,j-1))+nums[j]);
        //lookup[i][j] = lookup[i][j-1]+lookup[j][j];
        if(max < lookup.get(at(i,j))){
          max = lookup.get(at(i,j));
          imax = i;
          jmax = j;
        }
      }
     
    }
 return max; 

  }
public String at(int i,int j){
  return i+","+j;
}
   //driver program
  
  public static void main(String[] args){
    Solution s = new Solution();
int[] n = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("max sum ="+s.maxSubArray(n));
  }
 

}
