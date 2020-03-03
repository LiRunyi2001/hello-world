public class Calculator {

    public double[][] plus(Juzhen m,Juzhen n){
        double[][] c=new double[20][20];
        for(int i=0;i<m.row;i++)
            for(int j=0;j<m.column;j++)
            {
                c[i][j]=m.a[i][j]+n.a[i][j];
            }
        return c;
    }
    public double[][] minus(Juzhen m,Juzhen n){
        double[][] c=new double[20][20];
        for(int i=0;i<m.row;i++)
            for(int j=0;j<m.column;j++)
            {
                c[i][j]=m.a[i][j]-n.a[i][j];
            }
        return c;
    }
    public double[][] multiply(Juzhen m,Juzhen n){
        double[][] result = new double[20][20];
        for(int r = 0;r < m.row;r++){
            for(int col = 0;col < n.column;col++){
                double num = 0;
                for(int i = 0;i <m.column;i++){
                    num+=m.a[r][i]*n.a[i][col];
                }

                result[r][col]=num;
            }
        }
        return result;

    }
    public double[][] power(Juzhen a,int n){
        double [][] c=new double[20][20];
        Juzhen b=new Juzhen(a.row,a.column);
        b.setA(a.a);
        for(int i=1;i<n;i++)
        {
            c=multiply(b,a);
            b.setA(c);
        }
        return c;
    }




}


