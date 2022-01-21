package 斐波那契_dp;

/*动态规划优化斐波那契数列
 核心：使用数组a存储了中间数据，大量减少了相同数据的地递归，以空间换取时间
 */
import java.util.Scanner;

public class Main {
    private static long[] a=new long[100000000];
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n= sc.nextInt();
        System.out.println(digui(n));
        //展示中间数据
        for (int i=0;i<n;i++) {
            System.out.println(a[i]);
        }
    }

    public static long digui(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        //读取中间数据
        if(a[n] != 0) {
            return a[n];
        }
        //存储中间数据
        a[n]= digui(n-1) + digui(n-2);
        return a[n];
    }
    //循环实现
//    public static long xunhuan(int n) {
//        if (n == 1) return 1;
//        if (n == 2) return 2;
//
//        int result = 0;
//        int pre = 1;
//        int next = 2;
//
//        for (int i = 3; i < n + 1; i ++) {
//            result = pre + next;
//            pre = next;
//            next = result;
//        }
//        return result;
//    }
}
