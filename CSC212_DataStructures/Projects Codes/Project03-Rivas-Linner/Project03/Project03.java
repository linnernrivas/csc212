import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.InputStreamReader;

public class Project03 extends Frame implements ActionListener {
	SortArray tn = new SortArray();
	// Retrieved command code

	String command = "";

	// Program Description displayed from About sub-menu
	String[] description = new String[] { " Thisprogram to compare the performance of data retrieval ",
			"for the following search methods:", " - Sequential Search", " - Binary Search of a sorted array",
			" Input:", "     - The file have Data File,Search Files and Key files  ", " Output:",
			"     - Will be provided with several datasets, Data Files (DataFile) containing unique integer",
			"	  - numbers and Search Keys files (Keys) containing keys to search among data files.", };

	public static void main(String[] args) {
		Frame f = new Project03();

		f.setResizable(true);
		f.setSize(1000, 650);
		f.setVisible(true);

	}

	public Project03() {
		// Creates the title for frame
		setTitle("Search Routines-Rivas-Linner");

		// Create Menu Bar
		MenuBar mb = new MenuBar();
		setMenuBar(mb);

		// Create Menu Group Labeled "File"
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);// Add it to Menu Bar

		// Create Menu Group Label "Search"
		Menu searchMenu = new Menu("Search");
		mb.add(searchMenu);// Add it to Menu Bar

		// Creates the subMenu for the Menu Group label "File"
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);

		MenuItem miOpenFile = new MenuItem("Open File");
		miOpenFile.addActionListener(this);
		fileMenu.add(miOpenFile);

		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);

		// Create the subMenu for the Menu Group label "Search"
		MenuItem miSSearch = new MenuItem("Sequential Search");
		miSSearch.addActionListener(this);
		searchMenu.add(miSSearch);

		MenuItem miBSearch = new MenuItem("Binary Search");
		miBSearch.addActionListener(this);
		searchMenu.add(miBSearch);

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

	/*
	 * Called by windows manager whenever the application window performs an
	 * action (Select a menu item, close, resize, etc)
	 */
	public void actionPerformed(ActionEvent ev) {
		// figure out which command was issued
		command = ev.getActionCommand();

		// take action accordingly
		if ("About".equals(command)) {
			repaint();
		}

		else if ("Exit".equals(command)) {
			System.exit(0);
		} else if ("Open File".equals(command)) {
			try {
				tn.OpenDataFile();
				tn.OpenKeyFile();
			} catch (IOException ioe) {
				System.exit(0);
			}
			repaint();
		}
		else if ("Sequential Search".equals(command)) {
			tn.SequentialSearch();
			repaint();
		}

		else if ("Binary Search".equals(command)) {
			tn.BinarySearch();
			repaint();
		}

	}
	// ********************************************************
	// called by repaint() to redraw the screen
	// ********************************************************

	public void paint(Graphics g) {
		int x = 250;
		int y = 100;

		if ("About".equals(command)) {
			for (int i = 0; i < 12; i++) {
				g.drawString(description[i], x - 220, y);
				y = y + 25;
			}
		}

		if ("Open File".equals(command)) {
			x=200;//make it 50+25
			y=150;

			/* This is the Search Data file Open File */
			if (tn.fileName != null) {
				g.drawString(" File" + "--" + tn.fileName + "--" + "was succesfully opened", x - 120, y + 40);
				g.drawString("Number of Data Items " + "=" + Integer.toString(tn.dataItems), x - 120, y + 70);
				y += 25;
			}
			//else {
			//	g.drawString(" File" + "--" + tn.fileName + "--" + "was unsuccessfully opening",x - 120, y + 70);
			//}

			/* This is the Search Key file Open File */
			if (tn.keyName != null) {
				g.drawString(" File" + "--" + tn.keyName + "--" + "was succesfully opened", x - 120, y + 80);
				g.drawString("Number of Keys " + "=" + Integer.toString(tn.numbOfKeys), x - 120, y + 100);
				y += 25;
			}
			//else {
			//	g.drawString(" File" + "--" + tn.fileName + "--" + "was unsuccessfully opening",x - 120, y + 70);
			//}
			return;
		}

		if ("Sequential Search".equals(command) || "Binary Search".equals(command)) {
			g.setColor(Color.black);
			g.drawLine(50,110,800,110);
			g.drawLine(50,110,50,360);
			y+=25;
			g.drawString("Experiment", 110, 200);

			//y+=25;	 
			g.setColor(Color.black);
			g.drawLine(250,110,250,360);
			y+=25;
			g.drawString("Data File Attributes -- " + Integer.toString(tn.dataItems) + " Data Items", 450, 129);
			g.drawString("Key File Attributes -- " + Integer.toString(tn.numbOfKeys) + " Keys", 450, 154);
			//g.drawLine(250,100,250,550);
			//y+=25;
			g.setColor(Color.red);// this is setting the color red only for "Measure Criteria"
			g.drawString("Measured Criteria", 475, 190);

			g.setColor(Color.black);
			g.drawLine(250,175,800,175);
			y+=25;
			g.drawLine(364,200,800,200);
			y+=25;
			g.drawString("Successful Search", 410, 230);
			g.setColor(Color.black);
			g.drawString("UnSuccessful Search", 640, 230);

			g.setColor(Color.black);
			g.drawLine(50,310,800,310);
			g.setColor(Color.red);
			g.drawString("Sequential Search", 110, 325);
			g.setColor(Color.black);
			g.drawLine(364,235,800,235);
			y+=25;
			g.drawLine(50,335,800,335);
			y+=25;
			g.drawString(String.valueOf(tn.AATx), 290, 332);
			g.drawString(Double.toString(tn.numKeys),400, 332);
			g.drawString(Double.toString(tn.numComps),510, 332);
			g.drawString(Double.toString(tn.numUnsucess), 620, 332);
			g.drawString(Double.toString(tn.numUnsComps), 730, 332);

			g.setColor(Color.red);
			g.drawString("Binary Search", 110, 355);
			g.setColor(Color.black);
			g.drawLine(50,360,800,360);
			y+=25;
			g.drawLine(365,175,365,360);
			y+=25;
			g.drawString(Double.toString(tn.AATBinary), 290, 358);
			g.drawString(Double.toString(tn.numKeysBinary),400, 358);
			g.drawString(Double.toString(tn.numComsBinary),510, 358);
			g.drawString(Double.toString(tn.numUnBinary), 620, 358);
			g.drawString(Double.toString(tn.numUnComBinary), 730, 358);


			g.setColor(Color.black);
			g.drawLine(465,235,465,360);
			y+=25;
			g.drawString("Average", 285, 260);
			g.drawString("Access", 285, 275);
			g.drawString("Time", 290, 290);

			g.drawString("#", 400, 260);
			g.drawString("Keys", 400, 275);
			g.drawString("Found", 390, 290);


			g.setColor(Color.black);
			g.drawLine(590,200,590,360);
			y+=25;
			g.drawString("Average", 500, 260);
			g.drawString("No. Of", 500, 275);
			g.drawString("Comparisons", 485, 290);


			g.setColor(Color.black);
			g.drawLine(690,235,690,360);
			y+=25;
			g.drawString("# ", 620, 260);
			g.drawString("Keys", 620, 275);
			g.drawString("Not Found", 600, 290);
			g.drawString("Average", 720, 260);
			g.drawString("No. Of", 720, 275);
			g.drawString("Comparisons", 700, 290);
			g.setColor(Color.black);
			g.drawLine(800,110,800,360);
			y+=25;

		}
	}

}
