//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
//
// 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
//
//
//
// 示例 1:
//
//
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。
//
// 示例 2:
//
//
//输入: gas = [2,3,4], cost = [3,4,3]
//输出: -1
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。
//
//
//
// 提示:
//
//
// gas.length == n
// cost.length == n
// 1 <= n <= 10⁵
// 0 <= gas[i], cost[i] <= 10⁴
//
// Related Topics 贪心 数组 👍 911 👎 0

package 贪心_加油站134;
import java.util.Scanner;
/**
 * @author 燕子豪
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] gas = {5, 1, 2, 3, 4};
        int[] cost = {4, 4, 1, 5, 1};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    /**
     * 思路：首先要能想通加油量的总和减去耗油量的总和大于等于0，就一定有解。若有解，则找出sumSet的最小值的下一个元素即为其实下标，
     *     类比：加速度=sub，实际速度=sumSet
     * */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // sub[i]表示gas[i]-cost[i]
        int[] sub = new int[n];
        //填充sub数组
        for (int i = 0; i < n; i++) {
            sub[i] = gas[i] - cost[i];
        }
        // sum表示数组sub的和
        int sum = sub[0];
        // sumSet表示记录计算sum每一步过程的集合
        int[] sumSet = new int[n];
        sumSet[0] = sum;
        for (int i = 1; i < n; i++) {
            sum += sub[i];
            sumSet[i] = sum;
        }
        // 如果sum<0则一定无解，反之一定有解
        if (sum < 0) {
            return -1;
        }
        // 若有解，则sumSet第一个最小值的下一个元素的下标就是起始位置
        int sumSetMin = sumSet[0];
        for (int data : sumSet) {
            if (data < sumSetMin) {
                sumSetMin = data;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sumSet[i] == sumSetMin) {
                // 注意下标可能会越界
                return (i + 1) % n;
            }
        }
        return -1;
    }
}
// 大佬的简介代码(思路同上)
 /* public int canCompleteCircuit(int[] gas, int[] cost) {
  int len = gas.length;
  int spare = 0;
  int minSpare = Integer.MAX_VALUE;
  int minIndex = 0;

  for (int i = 0; i < len; i++) {
    spare += gas[i] - cost[i];
    if (spare < minSpare) {
      minSpare = spare;
      minIndex = i;
    }
  }
  return spare < 0 ? -1 : (minIndex + 1) % len;
}*/
