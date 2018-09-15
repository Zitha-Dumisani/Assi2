//sequential program

//imports
import java.io.*;

public class sequential{
    public static void main(String[] args) {
        try{
            long startT=System.currentTimeMillis();
            FileReader fr=new FileReader("sample_input.txt"); 
            //FileReader fr=new FileReader("1.txt");   
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
       
        br.close();    
        fr.close(); 

        System.out.println("input loaded");
        long inputT=System.currentTimeMillis();
        //==============================================================================================
        
        double[] TAve=new double[iTrees];
        double sumTot=0;
        //calculate trees averages  
        for (int i=0;i<iTrees;i++){
            double sum=0;
            //sum pieces of tree
            for (int j1=0;j1<LTrees[i][2];j1++){
                for (int j2=0;j2<LTrees[i][2];j2++){
                    if (j1+LTrees[i][0]<size[0] && j2+LTrees[i][1]<size[1] ){
                      sum=sum+rAve[j1+LTrees[i][0]][j2+LTrees[i][1]]; 
                    }             
                }
            }
            TAve[i]=sum;
            sumTot=sum+sumTot;
        }

        long end=System.currentTimeMillis();
        //System.out.println("input time:"+(inputT-startT)+"\nProcessing time:"+(end-inputT));
        
        //print out
        System.out.println(sumTot/iTrees);
        System.out.println(iTrees);
        for (int i=0;i<iTrees;i++){
            System.out.println(TAve[i]);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());

        }
    }
}