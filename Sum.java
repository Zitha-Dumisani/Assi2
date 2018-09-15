import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<String>{
    int lo;
    int hi;
    int[][] Trees;
    int maxX;
    int maxY;
    double[][] rAve;
    static int Seq_cut=1000;
    

    Sum(double[][] R,int[][] T,int l,int h,int x,int y ){
        rAve=R;
        Trees=T;
        lo=l;hi=h;
        maxX=x;maxY=y;
    }

    protected String compute(){
        if (hi-lo<Seq_cut){
            String s="";
            double sum=0;
            for (int i=lo;i<hi;i++){
                
                sum=0;
                
                for (int j1=0;j1<Trees[i][2];j1++){
                    for (int j2=0;j2<Trees[i][2];j2++){
                      //  if (j1+Trees[i][0]<maxX && j2+Trees[i][1]<maxY){
        
                             try{ sum=sum+rAve[j1+Trees[i][0]][j2+Trees[i][1]]; }
                             catch(Exception e){}
                     //   }             
                    }
                }

                
                s=s+(i+1)+"_"+sum+"\n";
              //  System.out.println(s);
              //  s=s+i+":Sum_"+sum+":maxX_"+maxX+" tre_len"+Trees[i][2]+" tree len_"+ "\n";
            }
           // System.out.println(s);
            return s;
        }
        else{
            Sum left=new Sum(rAve,Trees,lo,(hi+lo)/2,maxX,maxY);
            Sum right=new Sum(rAve,Trees,(hi+lo)/2,hi,maxX,maxY);
            left.fork();
            String s1=right.compute();
            String s2=left.join();
            return s2+s1;//
        }
    }   
}