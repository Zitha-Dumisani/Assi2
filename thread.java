//thread class

public class thread extends java.lang.Thread{
    

    int lo; 
    int hi;
    int[][] Trees;
    int CUTOFF=10;

    double[][] rAve;
    String ans;
    //constructor
    SumThread(double[][] map,int[][] tree, int l, int h) {
        lo=l; hi=h;
        rAve=map; Trees=tree;
    }

    //thread code
    public void run(){
        if(hi - lo < CUTOFF) {
            String s="";
            for (int i=lo;i<hi+1;i++){
                double sum=0;
                //sum pieces of tree
                for (int j1=0;j1<Trees[i][2];j1++){
                    for (int j2=0;j2<Trees[i][2];j2++){
                        if (j1+Trees[i][0]<Trees.length && j2+Trees[i][0]<Trees[i].length )
                        sum=sum+rAve[j1+Trees[i][0]][j2+Trees[i][1]];                
                    }
                }
                
                s=s+sum+"\n";
            }
            //calculate these trees 
        }else{
            thread left = new thread(rAve,Trees,lo,(hi+lo)/2);
            thread right = new thread(rAve,Trees,(hi+lo)/2,hi);
            left.start();
            right.start();
            left.join();
            right.join();
            ans=left.ans+right.ans;
        }

    }

}

