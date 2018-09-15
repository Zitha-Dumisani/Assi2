
import java.util.concurrent.ForkJoinPool;
import java.io.*;

public class test{
    static final ForkJoinPool fjPool = new ForkJoinPool();
	static String sum(double[][] a,int[][] b, int c,int d,int i0,int i1){
        
	    return fjPool.invoke(new Sum(a,b,c,d,i0,i1));
    }
    public static void main(String args[]){
        //===========================================================================================================\
        try{
            FileReader fr=new FileReader("sample_input.txt");
           // FileReader fr=new FileReader("2.txt");
            BufferedReader br=new BufferedReader(fr);
            
            //varibales
            int[] size=new int[2];
            String sLine;    
            int ibuffer=0;
            int iTrees=0;
            int[][] LTrees;
            boolean b=true;

            // read input =================================================================================


            //map size
            sLine=br.readLine();
            String[] s=new String[2];
            s=sLine.split(" ");
            size[0]=Integer.parseInt(s[0]);
            size[1]=Integer.parseInt(s[1]);

            //save terrain
            sLine=br.readLine(); 
            String[] sAve=sLine.split(" "); 
            double[][] rAve=new double[size[0]][size[1]]; 
            for (int i=0;i<size[0]*size[1];i++){
            rAve[i / size[1] ][i % size[1]]=Double.parseDouble(sAve[i]);
            }

            System.out.println("terrain saved");
            

            //number of trees
            sLine=br.readLine();
            iTrees=Integer.parseInt(sLine);
        
            //tree positions and size
            LTrees=new int[iTrees][3];
            for (int i=0;i<iTrees;i++){
                sLine=br.readLine();
                String[] s1=sLine.split(" ");
                LTrees[i][0]=Integer.parseInt(s1[0]);
                LTrees[i][1]=Integer.parseInt(s1[1]);
                LTrees[i][2]=Integer.parseInt(s1[2]);
            
            }  
            System.out.println("trees data saved saved. \n\nComputing...");
        
            br.close();    
            fr.close();

            System.out.println(iTrees+"_"+LTrees.length);
            
            String[] sTreeAve= sum(rAve,LTrees,0,iTrees,size[0],size[1]).split("\n");
            double sum=0;
            
            int ic=0;
            for (int i=0;i<sTreeAve.length;i++){
                
                sum=sum+Double.parseDouble(sTreeAve[i].split("_")[1]);
                System.out.println(sTreeAve[i].split("_")[1]);
            }
            
           
            System.out.println(sum/sTreeAve.length);
            System.out.println(sTreeAve[sTreeAve.length-1]+"_"+sTreeAve.length+"_"+iTrees);

        }catch(Exception e){
            System.out.println(e.getMessage());
            
        }

        //===========================================================================================================
        //
        
    } 
   

}