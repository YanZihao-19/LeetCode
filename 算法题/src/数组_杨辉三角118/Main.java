//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
// Related Topics 数组 动态规划 👍 760 👎 0
package 数组_杨辉三角118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: 燕子豪
 * @Date: 2022/5/16 17:40
 */
public class Main {
    public static void main(String[] args) {
        for (List<Integer> l : generate(5)) {
            for (Integer i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    /**
     * 思路：首先会发现规律，从第三行起，每一行从第二个元素到倒数第二个元素，该元素=上一行对应下标元素+上一行(对应下标-1)元素，
     *      此外每行第一个元素和最后一个元素均为1。
     * 总结：本题发现上述规律并不难，主要是如何在集合的基础上实现上述操作
     * */
    public static List<List<Integer>> generate(int numRows) {
        //定义所要返回的集合
        List<List<Integer>> ll = new ArrayList<>();
        //添加第1个元素[1]
        ll.add(new ArrayList<>(Arrays.asList(1)));
        //从第二行开始每个元素都可以通过下面两次循环实现
        for (int i = 1; i < numRows; i++) {
            //创建每行集合对象(且该集合对象首元素默认为1)
            List<Integer> l = new ArrayList<>(Arrays.asList(1));
            for (int j = 1; j < i; j++) {
                //根据规律填充该行第二道倒数第二个元素
                l.add(ll.get(i - 1).get(j - 1) + ll.get(i - 1).get(j));
            }
            //添加集合对象默认末尾元素1
            l.add(1);
            //将该行添加到所需要返回集合
            ll.add(l);
        }
        return ll;
    }
}
