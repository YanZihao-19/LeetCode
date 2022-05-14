package 哈希表_两个数组的交集II350;

import java.util.*;
/**
 * @author 燕子豪
 */
public class Main {
    public static void main(String[] args) {
        int[] num1 = {8, 0, 0, 3};
        int[] num2 = {0, 0};
        for (int i : intersection(num1, num2)) {
            System.out.print(i + " ");
        }
    }
    /**
     * 思路1:使用哈希表,第一个数组用于存入哈希表中，其中key是数组元素,value表示数组元素个数。 第二个数组用于遍历时取共同数据，每次取数据就对value-1表示取出，同时放入集合c中。
     * 最后将集合c的数据复制到数组中，返回数组即可。
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Collection<Integer> c = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums1) {
            if (map.get(i) != null) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (int i : nums2) {
            if (map.get(i) != null && map.get(i) >= 1) {
                map.put(i, map.get(i) - 1);
                c.add(i);
            }
        }
        int cont = 0;
        int[] ans = new int[c.size()];
        for (int i : c) {
            ans[cont++] = i;
        }
        return ans;
    }
    /**
     * 思路2:使用排序+双指针，首先对两个数组进行排序，两个指针分别指向数组首元素，比较所指向元素的大小，
     *      对于较小元素就向前移动指针，两个元素相同就将该元素加入到集合中，并同时向前移动指针。
     */
    public static int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0;
        int index2 = 0;
        Collection<Integer> c=new ArrayList<>();
        for (; index1 < nums1.length && index2 < nums2.length; ) {
            if(nums1[index1]<nums2[index2]){
                index1++;
            }else if(nums1[index1]>nums2[index2]){
                index2++;
            }else {
                c.add(nums1[index1]);
                index1++;
                index2++;
            }
        }
        int cont = 0;
        int[] ans = new int[c.size()];
        for (int i : c) {
            ans[cont++] = i;
        }
        return ans;
    }
}
