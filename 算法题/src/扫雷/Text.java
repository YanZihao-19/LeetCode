    package 扫雷;

    import java.util.Scanner;


    /**
     * #描述
     * 扫雷游戏是一款十分经典的单机小游戏。在nn行mm列的雷区中有一些格子含有地雷（称之为地雷格），其他格子不含地雷（称之为非地雷格）。玩家翻开一个非地雷格时，该格将会出现一个数字——提示周围格子中有多少个是地雷格。游戏的目标是在不翻出任何地雷格的条件下，找出所有的非地雷格。
     * 现在给出nn行mm列的雷区中的地雷分布，要求计算出每个非地雷格周围的地雷格数。
     * 注：一个格子的周围格子包括其上、下、左、右、左上、右上、左下、右下八个方向上与之直接相邻的格子。
     *
     * #输入格式
     * 第一行是用一个空格隔开的两个整数nn和mm，分别表示雷区的行数和列数。
     *
     * 接下来nn行，每行mm个字符，描述了雷区中的地雷分布情况。字符’*’表示相应格子是地雷格，字符’?’表示相应格子是非地雷格。相邻字符之间无分隔符。
     *
     * #输出格式
     * 输出文件包含nn行，每行mm个字符，描述整个雷区。用’*’表示地雷格，用周围的地雷个数表示非地雷格。相邻字符之间无分隔符。
     */
    public class Text {
        public static void main(String[] args) {
            //m代表行，n代表列
            int m, n;
            Scanner sc = new Scanner(System.in);
            m = sc.nextInt();
            n = sc.nextInt();
            //二维数组扩充了辅助区(无雷区)
            int[][] a = new int[m + 2][n + 2];
            int[][] b = new int[m+2][n+2];
            //初始化数组(有雷区)录入数据
            for (int i = 1; i < a.length - 1; i++) {
                String s = sc.next();
                for (int j = 1; j < a[i].length - 1; j++) {
                    a[i][j] = s.charAt(j - 1);
                    if (a[i][j] == '*') {
                        a[i][j] = 1;
                    } else {
                        a[i][j] = 0;
                    }
                }
            }

            //填充数组(无雷区)
            Filling(a,b);
            //遍历数组
            Iterate(b);
        }

        private static void Iterate(int[][] a) {
            for (int i = 1; i < a.length - 1; i++) {
                for (int j = 1; j < a[i].length - 1; j++) {
                    if(a[i][j]==-1) {
                        System.out.print('*');
                    } else {
                        System.out.print(a[i][j]);
                    }
                }
                System.out.println();
            }
        }

        private static void Filling(int[][] a,int[][] b) {
            for(int i=1;i< a.length-1;i++) {
                for(int j=1;j<a[i].length-1;j++){
                    if(a[i][j]==0){
                        b[i][j]=a[i-1][j-1]+a[i-1][j]+a[i-1][j+1]+a[i][j-1]+a[i][j+1]+a[i+1][j-1]+a[i+1][j]+a[i+1][j+1];
                    }else if(a[i][j]==1) {
                        b[i][j]=-1;
                    }
                }
            }
        }

    }