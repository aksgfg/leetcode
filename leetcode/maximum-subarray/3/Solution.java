// link : https://leetcode.com/problems/maximum-subarray/description/ 
// improvment from the previous version. dont use dictionary or array 
class Solution {
    public int maxSubArray(int[] nums) {
    int max = nums[0],sum=0;
    int imax ,jmax;
    for(int k= 0; k<nums.length; k++){
      if(max < nums[k]){
        max = nums[k];
        imax = jmax = k;
      }
    }
    for(int i = 0; i < nums.length; i++)
    {
      sum = nums[i];
      for(int j = i+1; j < nums.length; j++){
        sum += nums[j];
        if(max < sum){
          max = sum;
          imax = i;
          jmax = j;
        }
      }
      sum = 0;
    }
 return max; 

  }
   
   //driver program
  
  public static void main(String[] args){
    Solution s = new Solution();
int[] n = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println("max sum ="+s.maxSubArray(n));
  }
 

}
