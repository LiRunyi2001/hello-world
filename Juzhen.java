public class Juzhen {
    double[][] a=new double [20][20];
    int row;
    int column;
    Juzhen(int row,int column)
    {
        this.row=row;
        this.column=column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

//    public void Note(){
//        System.out.println("This is my Matrix Class which max range is 20");
//    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public void show(){
        for(int i=0;i<row;i++)
            for(int j=0;j<column;j++)
            {
                System.out.printf("%f ",a[i][j]);
                if(j==column-1) System.out.printf("\n");
            }
    }









}
