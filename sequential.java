//sequential program

//imports
import java.io.*;

public class sequential{
    public static void main(String[] args) {
        try{
         FileReader fr=new FileReader("sample_input.txt");    
        BufferedReader br=new BufferedReader(fr);
        
        
        int[] size=new int[2];
        String sLine;    
        int ibuffer=0;
        int iTrees=0;
        int[][] LTrees;
        boolean b=true;

        // read input =================================================================================
        while((sLine=br.readLine())!=null){
          if (ibuffer==0){
            //save saze
            String[] s=new String[2];
            s=sLine.split(" ");
            size[0]=Integer.parseInt(s[0]);
            size[1]=Integer.parseInt(s[1]);
          } else if (ibuffer==1){
              //save terrain
              String[] sAve=sLine.split(" ");
              double[][] rAve=new double[size[0]][size[1]]; 
              for (int i=0;i<size[0]*size[1];i++){
                  rAve[i / size[1] ][i % size[1]]=Double.parseDouble(sAve[i]);
              }
          //save tries
          }else if (ibuffer==2){
              iTrees=Integer.parseInt(sLine);
          }

          if (ibuffer>2) {
            String[] s=sLine.split(" ");
            if (b){
                b=false;
                LTrees=new int[iTrees][3];
            }else{
              LTrees[ibuffer-3][0]=Integer.parseInt(s[0]);
              LTrees[ibuffer-3][1]=Integer.parseInt(s[1]);
              LTrees[ibuffer-3][2]=Integer.parseInt(s[2]);
            }
          }
          System.out.print(ibuffer+" : "+sLine);  
          ibuffer++;
        }  
        br.close();    
        fr.close(); 
        //==============================================================================================

        double[] TAve=new double[iTrees];
        double sumTot=0;
        //calculate trees averages 
        for (int i=0;i<iTrees;i++){
            double sum=0;
            //sum pieces of tree
            for (int j1=0;j1<LTrees[i][2];j1++){
                for (int j2=0;j2<LTrees[i][2];j2++){
                    if (j1+LTrees[i][0]<size[0]+1 && j2+LTrees[i][0]<size[1]+1 )
                    sum=sum+rAve[j1+LTrees[i][0]][j2+LTrees[i][1]];                
                }
            }
            TAve[i]=sum;
            sumTot=sum+sumTot;
        }

        //print out
        System.out.println(sumTot/iTrees);
        System.out.println(iTrees);
        for (int i=0;i<iTrees;i++){
            System.out.println(TAve[i]);
        }

        }catch(Exception e){

        }
    }
}