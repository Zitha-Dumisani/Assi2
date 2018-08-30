//sequential map program

//imports
import java.io.*;

public class sequential{
    public static void main(String[] args) {
        FileReader fr=new FileReader("sample_input.txt");    
        BufferedReader br=new BufferedReader(fr);    

        String sLine;    
        while((sLine=br.readLine())!=-1){  
          //readfile
          System.out.print(sLine);  
        }  
        br.close();    
        fr.close(); 
    }
}