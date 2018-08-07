
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project02 extends Frame implements ActionListener {
    //Beginning of the Programs.
    String[] description = new String[] {
    	// program description displayed in About menu
    		" This program reads a text file selected by user",
			"   and Displays the selected attributes of the file",
			" Input:",
			"      - A text file ",
			" Output:",
			"Frequency of ASCII Characters",
			"      - Integer value of ASCII character",
			"      - Printed character",
			"      - Frequency of the character is the file",
			"Frequency of Letters",
			"Frequency of Digits",
			"Frequency of Words(Length 1-20)" 
			
			};
    String[] freqofascII = new String[]{
    "Int Count      Int Count       Int Char Count      Int Char Count      Int Char Count"
    };
    String [] charfreq = new String[]{
    		//program 
    		" Frequency of Letters"
			};
    String[] wordfreq = new String[]{
    "Length of Word           Number of Words(Split)         Number of Words(Character Scan)"
    };
    Font f = new Font(Font.SANS_SERIF,Font.BOLD,18);
    /// private variable
	private String[] freq_ascii = new String[256];
	private String[] freq_Upper = new String[26];
	private String[] freq_Lower = new String[26];
	private String[] freq_digits= new String[10]; 
	private String[] freq_words2 = new String[20];
    
    // This two variable have to defined Globally.
    TextFile t = new TextFile();
    
    // Retrieved command code
    String command = "";

    // end of Globally

    public static void main(String[] args) {
    	Frame f = new Project02();

    		f.setResizable(true);
    		f.setSize(550, 500);
    		
    		f.setVisible(true);
    		

    }

    public Project02() {
    	setTitle("TextFile Operation- Rivas-Linner ");

	// Create Menu Bar
    	MenuBar mb = new MenuBar();// if you want to add a menu you have to add
    	setMenuBar(mb);// menubar

	// Create Menu Group Labeled "File"
    	Menu fileMenu = new Menu("File");
	// Add it to Menu Bar
    	mb.add(fileMenu); // add the menu group to the menu bar

	// Create Menu Items 
	// Add action Listener
	// Add to "File" Menu Group
    	MenuItem miAbout = new MenuItem("About");
    	miAbout.addActionListener(this); // if someone clicks on the menu, let me know
    
    	fileMenu.add(miAbout); // add the menu items to the menu

    	MenuItem miExit = new MenuItem("Exit");
    	miExit.addActionListener(this);
    	fileMenu.add(miExit);

	// Create Menu Group Labeled "Triangle"
    	Menu OperationsMenu = new Menu("Operations");

	// Add it to Menu Bar
    	mb.add(	OperationsMenu);

	// Create Menu Items
	// Add action Listener
	// Add to "Triangle" Menu Group
    	MenuItem miOpenFile = new MenuItem("Open File");
    	miOpenFile.addActionListener(this);
    	OperationsMenu.add(miOpenFile);

    // Create Menu Group Labeled "Triangle"
    	Menu ReportsMenu = new Menu("Reports");
	
	// Add it to Menu Bar
    	mb.add(	ReportsMenu);

	// Create Menu Items
	// Add action Listener
	// Add to "Triangle" Menu Group
		
    // This Frequency of ASCII character menu items
		MenuItem miAscII = new MenuItem("Frequency of ASCII characters");
		miAscII.addActionListener(this);
		ReportsMenu.add(miAscII);

	// This Frequency of Letter menu items
	     MenuItem miLetters = new MenuItem("Frequency of Letters");
	     miLetters.addActionListener(this);
	     ReportsMenu.add(miLetters);
	     
	//This  Frequency of Digits menu items
	     MenuItem miDigits = new MenuItem("Frequency of Digits");
	     miDigits.addActionListener(this);
	     ReportsMenu.add(miDigits);
	     
	//This is  Frequency of Words ( Length 1-20) menu items
	     MenuItem miWords = new MenuItem("Frequency of Words ( Length 1-20)");
	     miWords.addActionListener(this);
	     ReportsMenu.add(miWords);
	    
	    
	
	/*This is where the window is repaint so that I would have
	 * repaint the window 
	 * */
		WindowListener l = new WindowAdapter() {

			public void windowClosing(WindowEvent ev) {
				System.exit(0);
			}

	    	public void windowActivated(WindowEvent ev) {
	    		repaint();
	    	}

	    	public void windowStateChanged(WindowEvent ev) {
	    		repaint();
	    	}

		};


		ComponentListener k = new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				repaint();
			}
		};

	// register listeners

		this.addWindowListener(l);
		this.addComponentListener(k);

    }
    
    //******************************************************************************
  	//  called by windows manager whenever the application window performs an action
  	//  (select a menu item, close, resize, ....
  	//******************************************************************************  
    
    public void actionPerformed(ActionEvent ev) {
    	// figure out which command was issued
    
    	command = ev.getActionCommand();
    
    	// take action accordingly
    	if ("About".equals(command)) {
    	    repaint();// call paint to display comments
    	} 
    	
    	else if ("Exit".equals(command)) { // call a method of mathematics
    		// class to get number
    	    System.exit(0);
    	} 
    	else if  ("Open File".equals(command)){
    	   	t.openFile();
    	   //	System.out.println(	"File" +"--" + t.openFile(i)+ "--"+"was succesfully opened");
    		t.processFile();
    		repaint();
    		//for(){
    			
    		//}
    		
    		//description[0] = Character.toString ((char) i) + " " + t.getCountItem(i);
            
        }
        
        	else if ("Frequency of ASCII characters".equals(command)) {
        		 for(int i=0; i<256; i++){
         	        freq_ascii[i] = i+" "+(char) i + " " + t.getCountItem(i) ;
         	    }
         	    
         	    repaint();
        	}
        	else if ("Frequency of Letters".equals(command)) {
        	    for(int i=0; i<26; i++){
         	        freq_Upper[i] = (char) (i+65) + " " + t.getCountItem(i+65) ;
         	    }
         	    for(int i=0; i<26; i++){
         	        freq_Lower[i] = (char) (i+97) + " " + t.getCountItem(i+97) ;
         	    }
         	   repaint();
        	    
        	}
        	else if ("Frequency of Digits".equals(command)) {
        		for (int i= 0;i < 10 ;i++){
        			freq_digits[i] = (char) (i+48) + "        " + t.getCountItem(i+48) ;
        		}
        		repaint();
        	    
        	}
        	else if ("Frequency of Words ( Length 1-20)".equals(command)) {
        	   for (int i= 0; i < 20; i++ ){
        	   freq_words2[i]=  i + "                         " + t.getCountWord(i) +"                         "+t.getCountWord2(i);
        	    	
        	   }
        	   repaint();
        	    
        	}
        	
    }
    
  //********************************************************
  // called by repaint() to redraw the screen
  //********************************************************
  

        public void paint(Graphics g) {
           
        //System.out.println("This is the command"  + command);
    	int x = 200;
    	int y = 150;
    
    	if ("About".equals(command)) {
    	    for (int i = 0; i < 12; i++) {
    		g.drawString(description[i], x-120,y );//use x and y to fit into screen
    		y = y + 25;
    	    }
    	}
    	else if  ("Open File".equals(command))
            
        {
        	x=200;//make it 50+25
     	    y=150;
            g.setColor(Color.black);
            g.drawString(" File"+ "--"+ t.dataFileName +"--"+"was succesfully opened",x-120,y+40);
            y+=25;
        }
    	
    	else if ("Frequency of ASCII characters".equals(command)) {
    		
 	    	x = 100;
			y = 80;
			
			g.setColor(Color.red);
     	   g.drawString( "Int Char Count               Int Char Count                  Int Char Count                  Int Char Count                  Int Char Count                           Int Char Count",x,y);
     	        	    g.setColor(Color.black);
     	        	   y+=25;   
     	        	  g.setColor(Color.black);
     	     		g.drawLine(x-120,y,x+1000,y);
     	     		y+=40;
			
     	    for(int j=0;j<256;j+= 43){
     	    	g.setColor(Color.black);
     	    
         	    for(int i=j; i<j+42; i++){
         	        g.drawString(freq_ascii[i], x, y-20);
                        y+=15;
         	    }
         	   x+=175;//make it 50+25
        	   y=160;
        	 
     	    
     	    }
        }
    	
    	
    	else if ("Frequency of Digits".equals(command)) {
    		x=175;
    		y=120;
     	    g.setColor(Color.black);
        	   g.drawString("Frequency of Digits in the file",x-25,y);
        	        	    g.setColor(Color.black);
        	        	    y+=25;
        	        	    g.drawLine(x-40,y,x+200,y);
        	       	      y+=25;
        	       	      
        	 g.drawString("Digits",x+25,y);
   	        	    g.setColor(Color.black);
   	        	 y+=25;
   	        	    g.drawLine(x-20,y,x+110,y);
   	       	      y+=25;	      
         	    for(int i=0; i<10; i++){
         	        g.drawString(freq_digits[i], x+25, y+25);
                        y+=25;
         	    }
         	    
         	   
     	    
    	}
    	
    	else if ("Frequency of Letters".equals(command)) {
    		x=175;
    		y=120;
    		for(int j=0;j<2;j+=16){
     	    	 g.setColor(Color.red);
 				g.drawString(charfreq[j],x+20,y-25);
     	  
    		
     	    //g.setColor(Color.red);
     	      //g.drawString("Char Freq",x,y-50);
 				g.setColor(Color.black);
    		g.drawLine(x-120,y,x+340,y);
    		y+=25;
    		}
     	      g.setColor(Color.black);
     	      //g.setFont(f);
     	      g.drawString("Upper Case Letters ",x-20,y+30);
     	     y+=60;
     	      g.drawLine(x-20,y,x+110,y);
     	      
         	    for(int i=0; i<26; i++){
         	        g.drawString(freq_Upper[i], x, y+50);
                        y+=25;
         	    }
         	  x+=175;//make it 50+25
         	  y=150;
         	  g.setColor(Color.black);
         	 // g.setFont(f);
         	  g.drawString("Lower Case Letters ",x-20,y +30);
         	  y+=60;
         	  g.drawLine(x-20,y,x+125,y);
         	  
         	    for(int i=0; i<26; i++){
         	        g.drawString(freq_Lower[i], x, y+50);
                        y+=25;
                       
         	   
    		  
    		}
        }
        
    	
        else if ("Frequency of Words ( Length 1-20)".equals(command)) {
        	x = 175;
			y = 100;
			//g.setFont(f);
            g.setColor(Color.red);
            g.drawString("Frequency of Words ( Length 1-20)",x,y);
            y+=20;
            g.setColor(Color.black);
            g.drawLine(x-120,y,x+400,y);
    		y+=35;
    		
    		for(int j=0;j<2;j+=16){
    			y+=25;
    			g.setColor(Color.black);
    			g.drawString(wordfreq[j],x-120,y-25);
    			g.drawLine(x-120,y,x+400,y);
         		y+=25;
    		}
            for(int i=0;i<20;i++){
            	 
                g.drawString(freq_words2[i],x,y+25);
                y+=25;
            }
        }
   //End of the Program.
       }
    }
