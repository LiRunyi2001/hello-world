public class Eye extends Juzhen {
    public Eye(int row,int column){
        super(row,column);
    }
    public void makeEye(double[][] a){
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
            {
                a[i][j]=0;
            }
        for(int i=0;i<row;i++)
        {
            a[i][i]=1;
        }
    }

}
