package 哈希表_存在重复元素217;

import java.util.*;

/**
 * @author 燕子豪
 */
public class Main {
    public static void main(String[] args) {
        int[] nums=new int[]{0,0};
        System.out.println(containsDuplicate1(nums));
    }
    /**
    *方法1：哈希表,遍历数组,判断哈希表的值是否为null,若是则返回true,否则将数组的值作为value放入表中 复杂度O(n)。
    * */
    public static boolean containsDuplicate1(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> m=new HashMap<>(n);
        for (int i : nums) {
            if(m.get(i)!=null){
                return true;
            }else {
                m.put(i,i);
            }
        }
        return false;
    }
    /**
     * 方法2：将nums放入set集合中，比较放入前和放入后长度是否一致
     * */
    public static boolean containsDuplicate2(int[] nums) {
        int n=nums.length;
        Set<Integer> s=new HashSet<>();
        for (Integer i : nums) {
            s.add(i);
        }
        int m=s.size();
        return m!=n;
    }
    /**
     * 方法2：先对数组排序，接着比较相邻的元素是否重复
     * */
    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }
}
