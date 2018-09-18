import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Double>{
    int lo;
    int hi;
    int[][] Trees;
    int maxX;
    int maxY;
    double[][] rAve;
    double[] ans;
    
    static int Seq_cut=200;

    

    Sum(double[][] R,int[][] T,int l,int h,int x,int y,double[] A){
        rAve=R;
        Trees=T;
        lo=l;hi=h;
        maxX=x;maxY=y;
        ans=A;
    }

    protected Double compute(){
        if (hi-lo<Seq_cut){
            double rSum=0;
            for (int i=lo;i<hi;i++){
                double sum=0; 
                for (int j1=0;j1<Trees[i][2];j1++){
                    for (int j2=0;j2<Trees[i][2];j2++){
                             try{ sum=sum+rAve[j1+Trees[i][0]][j2+Trees[i][1]]; }
                             catch(Exception e){}            
                    }
                }
                ans[i]=sum;
                rSum=rSum+sum;
            }
            return rSum;
        }
        else{
            Sum left=new Sum(rAve,Trees,lo,(hi+lo)/2,maxX,maxY,ans);
            Sum right=new Sum(rAve,Trees,(hi+lo)/2,hi,maxX,maxY,ans);
            left.fork();
            Double s1=right.compute();
            Double s2=left.join();
            return s2+s1;//
        }
    }   
}