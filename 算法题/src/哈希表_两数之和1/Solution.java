// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,7,11,15], target = 9
// 输出：[0,1]
// 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
// 输入：nums = [3,2,4], target = 6
// 输出：[1,2]
//
//
// 示例 3：
//
//
// 输入：nums = [3,3], target = 6
// 输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 10⁴
// -10⁹ <= nums[i] <= 10⁹
// -10⁹ <= target <= 10⁹
// 只会存在一个有效答案
//
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？
// Related Topics 数组 哈希表 👍 14367 👎 0
package 哈希表_两数之和1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 燕子豪
 */
public class Solution {
  public static void main(String[] args) {
    int[] nums = {3, 3, 4};
    int target = 6;
    int[] ans;
    ans = twoSum(nums, target);
    for (int i : ans) {
      System.out.print(i+" ");
    }
  }
/**
 * 思路：遍历数组，以数组的值作为key下标作为value放入hash表中,再次遍历数组,以target-nums[i]为key值,
 *     判断对应的value是否为null以及保证key与当前数组值的下标不能相同(一个元素只能用一次),若value不为null
 *     则返回i和target-i所组成的数组即可。
 * */
  public static int[] twoSum(int[] nums, int target) {
    int n = nums.length;
    int[] ans = new int[2];
    Map<Integer, Integer> m = new HashMap<>();
    for (int i = 0; i < n; i++) {
      m.put(nums[i], i);
    }
    for (int i = 0; i < n; i++) {
      if (m.get(target - nums[i]) != null && i != m.get(target - nums[i])) {
        ans[0] = i;
        ans[1] = m.get(target - nums[i]);
        return ans;
      }
    }
    return ans;
  }
}
