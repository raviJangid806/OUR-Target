import java.util.ArrayList;
import java.util.List;

public class PairSubset {
    public boolean canPartition(int[] nums) {
        int max=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return call(nums,sum,max,false,-1);
    }

    boolean call(int[] nums,int sum,int max,boolean yes,int index){
        if(index==nums.length-1){
            return false;
        }
        if(sum==max){
            return true;
        }
        if(sum<=0){
            return false;
        }
        if(yes){
            max = max + nums[index];
            sum = sum-max;
           
        }
        return (call(nums,sum,max,true,index+1) || call(nums,sum,max,false,index+1));
    }
}
