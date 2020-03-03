public class Gauss {


        // 高斯消元法
        public double[] Leave(double[][] arr,int row,int column) {

            double[] result = solution(arr);
            for (int i = 0; i < arr.length; i++) {
                result[i] = arr[i][arr[0].length - 1];
            }

            System.out.println("结果如下：");
            printArr(arr,row,column);

            for (double f : result) {
                System.out.print(f + " ");
            }
            return result;
        }

        /*
         * 结果在行列式中 所以 列式比行数多1
         */
        public double[] solution(double[][] arr) {
            int row = arr.length; // 行数
            int col = arr[0].length; // 列数
//		System.out.println("row = " + row + " col = " + col);
            double[] result = new double[row]; // 有多少个方程就有多少个未知数， 所以结果的个数为 行数

            for (int i = 0; i < row; i++) {
                int maxRow = SelectIndex(arr, i);

                // 寻找最大行、交换
                if (maxRow != i) {
                    swapRow(arr, i, maxRow);
                }

                // 归一化 当前行 每一个元素都除以当前 arr[i][i] 上的元素，归一化
                double divNum = arr[i][i];
                for (int k = i; k < col; k++) { // 当前行 的每一列元素都除以这个数
                    arr[i][k] /= divNum;
                }

                // 用这个1， 消去下面所有行的数
                arr = elimination(arr, i);

            }

//		System.out.println("回代啦");
            // 回代 从最后一行开始
            backProgram(arr);

            return result;
        }

        /*
         * 从最后一行回代，得到结果
         */
        public double[][] backProgram(double[][] arr) {

            int row = arr.length; // 行
            int col = arr[0].length; // 列
            for (int i = row - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
//				System.out.println("arr[" + j + "][" + (col - 1) + "] = " + arr[j][col - 1]);
//				System.out.println("arr[" + j + "][" + i + "] = " + arr[j][i]);
//				System.out.println("arr[" + i + "][" + i + "] = " + arr[i][i]);
//				System.out.println("arr[" + j + "][" + i + "] * arr[" + i + "][" + (col - 1) + "] = "
//						+ arr[j][i] * arr[i][col - 1]);
//				printArr(arr);
                    arr[j][col - 1] -= arr[j][i] * arr[i][col - 1];
                    arr[j][i] = 0;

//				printArr(arr);
                }

            }

            return arr;
        }

        /*
         * 用当前行消去下面的所有元素
         */
        public double[][] elimination(double[][] arr, int i) {
            int row = arr.length;
            int col = arr[0].length;
            double subNum;
            for (int k = i + 1; k < row; k++) { // i行消去下面的行
                subNum = arr[k][i];
                for (int j = i; j < col; j++) {
                    arr[k][j] -= (arr[i][j] * subNum);
                }
            }

            return arr;
        }

        /*
         * arr 为行列式 i行，j列 寻找 i -> row 这些行中 j列上最大的元素 并返回该行的下标
         */
        public int SelectIndex(double[][] arr, int j) {
            int row = arr.length;
            int index = j;

            // 寻找 j列中最大的元素的下标
            for (int k = j; k < row; k++) {
                if (Math.abs(arr[k][j]) > Math.abs(arr[index][j])) {
                    index = k;
                }
            }

            return index;
        }

        /*
         * 交换 i, j 两行上的所有元素
         */
        public double[][] swapRow(double[][] arr, int i, int j) {
            int col = arr[0].length; // 行列式的列数
            double tmp;

            for (int k = 0; k < col; k++) {
                tmp = arr[i][k];
                arr[i][k] = arr[j][k];
                arr[j][k] = tmp;
            }

            return arr;
        }

        public void printArr(double arr[][],int row,int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    System.out.print(arr[i][j] + "   ");
                }
                System.out.println();
            }
            System.out.println();
        }

        /*public static void main(String[] args) {
            float arr[][] = { { 2, 3, 11, 5, 2 }, { 1, 1, 5, 2, 1 }, { 2, 1, 3, 2, -3 }, { 1, 1, 3, 3, -3 } };


            Gauss gauss = new Gauss();
            System.out.println("高斯消元求解前：");
            gauss.printArr(arr);
            gauss.Gauss(arr);

        }*/



}
