	// GUI-related imports

	import java.awt.*;
	import java.awt.event.*;
    import javax.swing.*;
	
	public class  Project00 extends Frame implements ActionListener
	{
		// program description displayed in About menu
		String[] description = new String[] {
			" This program receives two integer numbers and calculates",
			"   and Displays the sum, difference and product of the numbers entered",
			" Input:",
			"      - Two integer numbers  ",
			" Output:",
			"      - sum, difference and product of input numbers"
		};
		
		//This two variable have to defined Globally.
		Mathematics t = new Mathematics();
		// Retrieved command code
		
		String command = "";
		//end of Globally
			
		public static void main(String[] args)
		{
			Frame f = new  Project00();
			
			f.setResizable(true);
			f.setSize(550,500);
			f.setVisible(true);
			
		}
		
		public  Project00()
		{
			setTitle("Simple Integer Mathematics Rivas-Linner ");
			
			// Create Menu Bar
			   			
			MenuBar mb = new MenuBar();// if you want to add a menu you have to add menubar
			setMenuBar(mb);
			
			// Create Menu Group Labeled "File"
			
			Menu fileMenu = new Menu("File");
			
			// Add it to Menu Bar
			
			mb.add(fileMenu); // add the menu group to the menu bar 
			
			// Create Menu Items
			// Add action Listener 
			// Add to "File" Menu Group
						
			MenuItem miAbout = new MenuItem("About");
			miAbout.addActionListener(this); //if someone clicks on the menu, let me know
			fileMenu.add(miAbout); //add the menu items to the menu
			
			MenuItem miExit = new MenuItem("Exit");
			miExit.addActionListener(this);
			fileMenu.add(miExit);
			
			// Create Menu Group Labeled "Triangle"
			
			Menu mathematicsMenu = new Menu("Mathematics");
			
			// Add it to Menu Bar
			
			mb.add(mathematicsMenu);
			
			// Create Menu Items
			// Add action Listener 
			// Add to "Triangle" Menu Group
			
			MenuItem miEnterNumbers = new MenuItem("Enter Numbers");
			miEnterNumbers.addActionListener(this);
			mathematicsMenu.add(miEnterNumbers);
			
			MenuItem miAdd = new MenuItem("Add");
			miAdd.addActionListener(this);
			mathematicsMenu.add(miAdd);
					
			// Add the rest of the menu items
			
			//This is the Subtract menu items
			MenuItem miSubtract = new MenuItem("Subtract");
			miSubtract.addActionListener(this);
			mathematicsMenu.add(miSubtract);
			
			//This is the Multiply menu items
			MenuItem miMultiply = new MenuItem("Multiply");
			miMultiply.addActionListener(this);
			mathematicsMenu.add(miMultiply);
			
			
			
			// End program when window is closed
			//This is all window class operation.
			
			WindowListener l = new WindowAdapter()
			{
							
				public void windowClosing(WindowEvent ev)
				{
					System.exit(0);
				}
				
				public void windowActivated(WindowEvent ev)
				{
					repaint();
				}
				
				public void windowStateChanged(WindowEvent ev)
				{
					repaint();
				}
			
			};
			
			ComponentListener k = new ComponentAdapter()
			{
				public void componentResized(ComponentEvent e) 
				{
	        		repaint();           
	    		}
			};
			
			// register listeners
				
			this.addWindowListener(l);
			this.addComponentListener(k);

		}
		
	//******************************************************************************
	//  called by windows manager whenever the application window performs an action
	//  (select a menu item, close, resize, ....)
	//******************************************************************************

		public void actionPerformed (ActionEvent ev)
			{
				// figure out which command was issued
				
				command = ev.getActionCommand();
				
				// take action accordingly
				if ("About".equals(command))
				{
					repaint();//call paint to display comments
				}
				else
				if("Exit".equals(command))
				{ //call a method of mathematics class to get number
					System.exit(0);
				}
				else
				if("Enter Numbers".equals(command))
				{
					t.getNumbers();
				}
				else
					if("Add".equals(command) || "Subtract".equals(command) || "Multiply".equals(command) )
					{								
						repaint();
					}
					

			}
	//********************************************************
	// called by repaint() to redraw the screen
	//********************************************************
			
			public void paint(Graphics g)
			{
				int x=200;
				int y=150;
				
				if ("About".equals(command))
				{
					for (int i=0; i<6; i++)
					{
						g.drawString(description[i],x-120,y+40);
						y=y+25;
					}
				}
				else
				
				if("Enter Numbers".equals(command))
				{
				    g.drawString("The Two numbers entered are:",x,y);
				    y=y+25;
				    g.drawLine(x-50,y,x+200,y);
				    y=y+25;
					g.drawString("First  Number" ,x,y);
					g.drawString(" = "+Integer.toString(t.getFirst()),x+100,y);
					y = y+25;
					g.drawString("SecondNumber" ,x,y);
					g.drawString(" = "+Integer.toString(t.getSecond()),x+100,y);
					y = y+25;
					
				}
				else
					if("Add".equals(command))
					{						
						x = 275;
						y = 220;
						g.drawString(Integer.toString(t.getFirst())+"  +",x,y);
						y=y+25;
						g.drawString(Integer.toString(t.getSecond()),x,y);
						y=y+15;
						g.drawLine(x-30,y,x+40,y);
						y=y+25;
						g.drawString(Integer.toString(t.getSum()),x,y);
					}
				// add the rest of the code
				else
					if("Subtract".equals(command))
					{		
						x = 275;
						y = 220;
						g.drawString(Integer.toString(t.getFirst())+"  -",x,y);
						y=y+25;
						g.drawString(Integer.toString(t.getSecond()),x,y);
						y=y+15;
						g.drawLine(x-30,y,x+40,y);
						y=y+25;
						g.drawString(Integer.toString(t.getDifference()),x,y);
					}
				else
					if("Multiply".equals(command))
					{			
						x = 275;
						y = 220;
						g.drawString(Integer.toString(t.getFirst())+"  x",x,y);
						y=y+25;
						g.drawString(Integer.toString(t.getSecond()),x,y);
						y=y+15;
						g.drawLine(x-30,y,x+40,y);
						y=y+25;
						g.drawString(Integer.toString(t.getProduct()),x,y);
					}
	}
}
