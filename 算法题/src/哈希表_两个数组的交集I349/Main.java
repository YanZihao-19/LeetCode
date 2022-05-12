//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
//
//
// 示例 2：
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
//
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 540 👎 0
package 哈希表_两个数组的交集I349;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 燕子豪
 */
public class Main {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 2};
        int[] num2 = {2, 2};
        for (int i : intersection(num1, num2)) {
            System.out.print(i + " ");
        }
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Collection<Integer> c=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i: nums1) {
            map.put(i,i);
        }
        for (int i: nums2) {
            if(map.get(i)!=null){
                c.add(i);
                map.put(i,null);
            }
        }
        int cont=0;
        int[] ans =new int[c.size()];
        for (int i :c ) {
            ans[cont++]=i;
        }
        return ans;
    }
}