import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("矩阵计算器——加减乘");
        while(true)
        {
            System.out.println("输入第一个行、列：(小于20，下同)");
            int row=in.nextInt();
            int column=in.nextInt();
            System.out.println("输入第二个行、列：");
            int row1=in.nextInt();
            int column1=in.nextInt();
            Juzhen m=new Juzhen(row,column);
            Juzhen n=new Juzhen(row1,column1);
            System.out.println("现在输入两个行、列小于20的矩阵：");
            System.out.println("求幂默认选择第一个矩阵");
            //TODO:System.out.println("高斯消元法默认选择第一个矩阵");
            double[][] temp=new double[20][20];
            for(int i=0;i<row;i++)
                for(int j=0;j<column;j++)
                {
                    temp[i][j]=in.nextInt();
                }
            m.setA(temp);
            System.out.println("矩阵A输入完毕");
            double[][] temp1=new double[20][20];
            for(int i=0;i<row1;i++)
                for(int j=0;j<column1;j++)
                {
                    temp1[i][j]=in.nextInt();
                }
            n.setA(temp1);
            System.out.println("矩阵B输入完毕");
            System.out.println("选择功能：1加法，2减法，3乘法，4求幂，5消元(暂不可用)");
            Calculator cr=new Calculator();
            int ch=in.nextInt();
            switch(ch)
            {
                case 1:
                    double[][] result1=cr.plus(m,n);
                    Juzhen r1=new Juzhen(row,column);
                    r1.setA(result1);
                    r1.show();
                    break;
                case 2:
                    double[][] result2=cr.minus(m,n);
                    Juzhen r2=new Juzhen(row,column);
                    r2.setA(result2);
                    r2.show();
                    break;
                case 3:
                    double[][] result3=cr.multiply(m,n);
                    Juzhen r3=new Juzhen(row,column1);
                    r3.setA(result3);
                    r3.show();
                    break;
                case 4:
                    System.out.println("输入幂次");
                    int p=in.nextInt();
                    double[][] result4=cr.power(m,p);
                    Juzhen r4=new Juzhen(row,column);
                    r4.setA(result4);
                    r4.show();
                    break;
                case 5:
                    Gauss g=new Gauss();
                    g.Leave(m.a,m.row,m.column);
                    break;
                default:
                    System.out.println("输入无效");
            }
            System.out.println("退出按0，继续使用按其他任意字符");
            int exit=in.nextInt();
            if(exit==0) break;
        }



    }
}
