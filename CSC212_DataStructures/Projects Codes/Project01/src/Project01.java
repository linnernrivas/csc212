
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project01 extends Frame implements ActionListener {
    // program description displayed in About menu
    String[] description = new String[] {
    		" This program receives one integer numbers and calculates in to base 2-9",
			"   and Displays the calculation in binary of the numbers entered",
			" Input:",
			"      - One integer numbers  ",
			" Output:",
			"      - base of input numbers" 
			};
   
    /// private variable
    private int decimal;
    // This two variable have to defined Globally.
    BinaryMath t = new BinaryMath();
    
    // Retrieved command code

    String command = "";

    // end of Globally

    public static void main(String[] args) {
	Frame f = new Project01();

	f.setResizable(true);
	f.setSize(550, 500);
	f.setVisible(true);

    }

    public Project01() {
	setTitle("Simple Binary Conversion Rivas-Linner ");

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

	Menu binarymathsMenu = new Menu("Binary Math");

	// Add it to Menu Bar

	mb.add(binarymathsMenu);

	// Create Menu Items
	// Add action Listener
	// Add to "Triangle" Menu Group
	

	MenuItem miEnterNumbers = new MenuItem("Enter Numbers");
	miEnterNumbers.addActionListener(this);
	binarymathsMenu.add(miEnterNumbers);

	// This Base2 menu items
    System.out.println("code reached BASE 2");
	MenuItem miBase2 = new MenuItem("Base2");
	miBase2.addActionListener(this);
	binarymathsMenu.add(miBase2);
    System.out.println("code reached BASE 2 END");
    
    MenuItem miBase3 = new MenuItem("Base3");
	miBase3.addActionListener(this);
	binarymathsMenu.add(miBase3);
    
	
	MenuItem miBase4 = new MenuItem("Base4");
	miBase4.addActionListener(this);
	binarymathsMenu.add(miBase4);
    
	MenuItem miBase5 = new MenuItem("Base5");
	miBase5.addActionListener(this);
	binarymathsMenu.add(miBase5);
	
	MenuItem miBase6 = new MenuItem("Base6");
	miBase6.addActionListener(this);
	binarymathsMenu.add(miBase6);
	
	MenuItem miBase7 = new MenuItem("Base7");
	miBase7.addActionListener(this);
	binarymathsMenu.add(miBase7);
	
	MenuItem miBase8 = new MenuItem("Base8");
	miBase8.addActionListener(this);
	binarymathsMenu.add(miBase8);
    
	MenuItem miBase9 = new MenuItem("Base9");
	miBase9.addActionListener(this);
	binarymathsMenu.add(miBase9);
    
    
    
      MenuItem All = new MenuItem("All");
      All.addActionListener(this);
	binarymathsMenu.add(All);
    
    	/*MenuItem miBaseAll = new MenuItem("All");
    miBaseAll.addActionListener(this);
	binarymathsMenu.add(miBaseAll);*/
	
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
    	
    	else if ("Enter Numbers".equals(command)) {
    	    System.out.println("code reached");
    	    decimal= t.getNumber();
    	    System.out.println("code NOT reached");
    	    description[0] = Integer.toString(decimal);
    	} 
    	/*else
			if("Base2".equals(command) || "Base3".equals(command) || "Base4".equals(command) || "Base5".equals(command) || "Base6".equals(command) ||"Base7".equals(command) || "Base8".equals(command) ||"Base9".equals(command) || "AllBase".equals(command)){								
				repaint(); 
			}*/
    	
    	else if("Base2".equals(command)) {
    	  
    	    description[0] = t.decimalToBinary(decimal, 2);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base3".equals(command)) {
      	  
    	    description[0] = t.decimalToBinary(decimal, 3);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base4".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 4);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base5".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 5);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base6".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 6);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base7".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 7);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base8".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 8);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
    	else if("Base9".equals(command)) {
        	  
    	    description[0] = t.decimalToBinary(decimal, 9);
    	    description[1] = "";
    	    description[2] = "";
    	    description[3] = "";
    	    description[4] = "";
    	    description[5] = "";
    	    repaint();
        }
        
        
       else if("All".equals(command)) {
      	 // System.out.println("HELLLLLLLLLLLLOOOOOOOOO");
    	    description[0] = t.decimalToBinary(decimal, 2);
    	    repaint();
        }
        
        else{}
    }

        public void paint(Graphics g) {
           //HERHEHREHRER
           //EHRERHERHER
           //EHRewREWJFDSFNSGSDg
           //SDKFHSDJLHGSDGAFDg
           ///klsdkfhsdakjfsadkjf;adf
           //THE LINE BELOW THIS 
           //THSE PRINTLIN BELOW THIS 
        System.out.println("This is the command"  + command);
    	int x = 150;
    	int y = 150;
    
    	if ("About".equals(command)) {
    	    for (int i = 0; i < 6; i++) {
    		g.drawString(description[i], x - 120, y + 40);
    		y = y + 25;
    	    }
    	}
    	else if ("Enter Numbers".equals(command)) {
    	    g.drawString("The  number entered are:", x, y);
    	    y = y + 25;
    	    g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    	    g.drawString("First  Number", x, y);
    	    g.drawString(" = " + Integer.toString(decimal), x + 100, y);
    	    y = y + 25;
    	    // g.drawString("SecondNumber" ,x,y);
    	    // g.drawString(" = "+Integer.toString(t.getSecond()),x+100,y);
    	    // y = y+25;
        }
        
        else if ("Base2".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 2" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 300, y);
    	    y = y + 25;
    		g.drawString("2" +"    " +"     "+ description[0], x-50 , y );
    		y = y - 55;
        }
    	
        else if ("Base3".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 3" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("3" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
        
        else if ("Base4".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 4" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("4" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
    	
        /*else if ("Base4".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
        	//g.drawString("The  number entered are:", x, y);
        	System.out.println("THIS IS THE NuMBER ::: " + decimal );
    		g.drawString(" = " + Integer.toString(decimal), x+100, y);
    		g.drawString(description[0], x , y + 200);
        }*/
    	
        else if ("Base5".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 5" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("5" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
        
        else if ("Base6".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 6" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("6" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
    	
        else if ("Base7".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 7" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("7" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
    	
        else if ("Base8".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 8" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("8" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
        else if ("Base9".equals(command)) {
        	x = 175;
            y = 120;
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
            y = y + 25;
            g.drawString("Base" + "           " +"         "+ "Number in Base 9" , x, y);
            y = y + 25;
            g.drawLine(x - 50, y, x + 200, y);
    	    y = y + 25;
    		g.drawString("9" +"    " +"     "+ description[0], x , y );
    		y = y + 25;
        }
    	
                else if ("All".equals(command)) {
        
        	System.out.println("All Base's");
        String num2 = t.decimalToBinary(decimal, 2);
        String num3 = t.decimalToBinary(decimal, 3);
        String num4 = t.decimalToBinary(decimal, 4);
        String num5 = t.decimalToBinary(decimal, 5);
        String num6 = t.decimalToBinary(decimal, 6);
        String num7 = t.decimalToBinary(decimal, 7);
        String num8 = t.decimalToBinary(decimal, 8);
        String num9 = t.decimalToBinary(decimal, 9);

        System.out.println(decimal + " BASE 2: " + num2); 
        System.out.println(decimal + " BASE 3: " + num3);
        System.out.println(decimal + " BASE 4: " + num4);
        System.out.println(decimal + " BASE 5: " + num5);
        System.out.println(decimal + " BASE 6: " + num6);
         	x = 20;
            y = 90;
        g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
        y = y + 25;
        g.drawString("Base" + "           " +"         "+ "Number in Base " , x, y);
        y = y + 25;
        g.drawLine(x - 50, y, x + 900, y);
        g.drawString("2 "+ "            "+ num2 , x, y+20);
        g.drawString("3 "+ "            "+ num3 , x, y+40);
        g.drawString("4 "+ "            "+ num4 , x, y+60);
        g.drawString("5 "+ "            "+ num5 , x, y+80);
        g.drawString("6 "+ "            "+ num6 , x, y+100);
        g.drawString("7 "+ "            "+ num7 , x, y+120);
        g.drawString("8 "+ "            "+ num8 , x, y+140);
        g.drawString("9 "+ "            "+ num9 , x, y+160);
       
        
        /*	System.out.println("THIS IS TESTVAL SHOULD BE 65" + Integer.toString(decimal));
          for(int i =0; i < 3; i++){
            t.decimalToBinary(decimal, 3);
            t.decimalToBinary(decimal, i);
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
        	//g.drawString("The  number entered are:", x, y);
        	System.out.println("THIS IS THE NuMBER ::: " + decimal );
    		g.drawString(" = " + Integer.toString(decimal), x+50, y);
    		g.drawString(description[0], x , y);
    		num+=20;
          }
          */
        }
        
         /* else if ("All".equals(command)) {
              
              System.out.println ("REEEEEEEEEEEEEEEAAAAAAAACHED");
        	x = 175;
            y = 120;
            for(int i =0; i < 10; i++){
            t.decimalToBinary(decimal, i);
            g.drawString("Original Number in Base(10): "+ Integer.toString(decimal) , x, y);
        	//g.drawString("The  number entered are:", x, y);
        	System.out.println("THIS IS THE NuMBER ::: " + decimal );
    		g.drawString(" = " + Integer.toString(decimal), x+100, y);
    		g.drawString(description[0], x , y + 50);
    		
            }*/
    		
    		//y=y+25;
        	//for (int i = 0; i < 6; i++) {
        	//	g.drawString(description[i], x - 120, y + 40);
        	//	System.out.println("DESCRIPTIONS" +description[i] ); 
        	//	y = y + 25;
    	    //}
        }
    }
