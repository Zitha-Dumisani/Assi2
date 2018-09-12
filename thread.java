//thread class

import java.util.concurrent.RecursiveTask;

public class thread extends RecursiveTask<String>{
    

    int lo; 
    int hi;
    int[][] Trees;
    int CUTOFF=10;

    double[][] rAve;
    //String ans;
    //constructor
    thread(double[][] map,int[][] tree, int l, int h) {
        lo=l; hi=h;
        rAve=map; Trees=tree;
    }

    //thread code
    public String compute(){
        if(hi - lo < CUTOFF) {
            String s="";
			//trees average sunlight list
            for (int i=lo;i<hi+1;i++){
                double sum=0;
                //sum pieces of tree
                for (int j1=0;j1<Trees[i][2];j1++){
                    for (int j2=0;j2<Trees[i][2];j2++){
                        if (j1+Trees[i][0]<Trees.length && j2+Trees[i][1]<Trees[i].length )
                        sum=sum+rAve[j1+Trees[i][0]][j2+Trees[i][1]];                
                    }
                }
                
                s=s+i+"_"+sum+"\n";
            }
            //calculate these trees 
			return s;
			
        }else{
            thread left = new thread(rAve,Trees,lo,(hi+lo)/2);
            thread right = new thread(rAve,Trees,(hi+lo)/2,hi);
            left.fork();
            String s2 = right.compute();
            String s1 =left.join();
     
            return s1+s2;
        }

    }

}

