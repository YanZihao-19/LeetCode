// 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
// 的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
//
//
// 示例 1：
//
//
// 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// 输出：[1,2,2,3,5,6]
// 解释：需要合并 [1,2,3] 和 [2,5,6] 。
// 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
//
//
// 示例 2：
//
//
// 输入：nums1 = [1], m = 1, nums2 = [], n = 0
// 输出：[1]
// 解释：需要合并 [1] 和 [] 。
// 合并结果是 [1] 。
//
//
// 示例 3：
//
//
// 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
// 输出：[1]
// 解释：需要合并的数组是 [] 和 [1] 。
// 合并结果是 [1] 。
// 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -10⁹ <= nums1[i], nums2[j] <= 10⁹
//
//
//
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
// Related Topics 数组 双指针 排序 👍 1424 👎 0

package 双指针_合并两个有序数组88;

/**
 * @author 燕子豪
 */
public class Main {
  public static void main(String[] args) {
    int[] nums1 = {2,0};
    int[] nums2 = {1};
    int n = nums2.length;
    int m = nums1.length - n;
    merge(nums1, m, nums2, n);
    for (int i : nums1) {
      System.out.print(i + " ");
    }
  }
/**
 * 这里用到了双指针分别指向num1和num2的最后一个（有效数字）元素，还有一个指针指向num1的最后,让这三个指针向前移动。
 * 如何移动：nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
 * 解释：比较num1和num2最后（有效）数字的大小,将较大值放在len指针指向的位置,并将对应的指针（较大值和len）后移一位。
 * */
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int len1 = m - 1;
    int len2 = n - 1;
    int len = m + n - 1;
    while (true) {
      //对临界情况的处理
      if(len1<0){
        while (len2>=0){
          //拷贝数组
          nums1[len--]=nums2[len2--];
        }
        return;
      }else if(len2<0){
        while (len1>0){
          //拷贝数组
          nums1[len--]=nums1[len1--];
        }
        return;
      }
      nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
    }
  }
  //数组拷贝+排序解法
//  public static void merge(int[] nums1, int m, int[] nums2, int n) {
//    System.arraycopy(nums2, 0, nums1, m, n);
//    Arrays.sort(nums1);
//  }
}
