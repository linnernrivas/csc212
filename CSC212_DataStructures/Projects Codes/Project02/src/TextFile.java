import java.io.FileReader; 		// both needed
import java.io.BufferedReader;  // for line input
import java.io.IOException;
import javax.swing.JFileChooser;
import java.io.File;

import java.util.Scanner;

public class TextFile 
{
      // File Parameters
	
		String dataFilePath ;
		String dataFileName;
		int[] count = new int[256];
		int[] countWord= new int[20];
		int[] token = new int[20];
		
	public TextFile	()
	{
	    dataFilePath = null;
		dataFileName = null;
		for (int i = 0; i<count.length; i++)
			count[i] = 0;
		for (int i = 0; i<token.length; i++)
			token[i] = 0;
	}
	public void openFile()
	{
		dataFilePath = null;
		dataFileName = null;
		
	  JFileChooser chooser = new JFileChooser();
	  chooser.setDialogType(JFileChooser.OPEN_DIALOG );
	  chooser.setDialogTitle("Open Data File");
      
      int returnVal = chooser.showOpenDialog(null);
      if( returnVal == JFileChooser.APPROVE_OPTION) 
      	{
          dataFilePath = chooser.getSelectedFile().getPath();
          dataFileName = chooser.getSelectedFile().getName();
        }
	}
	public void processFile()
	{
	    
		try 
		{   
			// initialize counting array
			for (int k=0; k<256; k++)
				count[k]=0;
			
			// Instantiate streams
			BufferedReader inputStream  = new BufferedReader(new FileReader(dataFilePath));
			System.out.println(dataFilePath);
			// read the file line by line and count the characters read
			int integerValue;
			char ch;
			String entireFile = "";
			
			while ((integerValue = inputStream.read()) != -1) 
			{
			    ch = (char) integerValue;
                //System.out.print(ch + " ");
                if(integerValue < 256)count[integerValue]++;
			}
			for(int i=0;i<256;i++){
			    System.out.println(count[i]);
			}
			tokenizeFile();
			inputStream.close();
		}
		catch(IOException ioe)
		{
			System.exit(0);
		}
		
	}
	
	public int getCountItem(int index){
	    return count[index];
	}
	
	public int getCountWord(int index){
	    return countWord[index];
	    
	}
	public int getCountWord2(int index){
	    return token[index];
	}
	public void tokenizeFile() 
	{
	    String integerValue;
	    for(int i=0;i<20;i++){
	        countWord[i]=token[i]=0;
	    }
		// Bonus
		try{
		    BufferedReader inputStream  = new BufferedReader(new FileReader(dataFilePath));
		while((integerValue = inputStream.readLine())!=null){
		   
		    String[] var = integerValue.split(" ");
		    for(String str : var){
		        //System.out.println(str);
		        if(str.length()<20){
		            countWord[str.length()]++;
		            
		            token[str.length()]++;
		        }
		    }
		}
		}catch(IOException ioe){
		    System.exit(0);
		}
		
		
		
	}
}
