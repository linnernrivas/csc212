import javax.swing.JOptionPane;


public class BinaryMath 
{
	
		private int decimal;
		
		public BinaryMath(){
		    
		}
		public int getNumber(){
			// get the first number
			String input = JOptionPane.showInputDialog(null, "Please enter an integer:",
					"Enter the First Number",	JOptionPane.QUESTION_MESSAGE);
			decimal = Integer.parseInt(input);
			
			return decimal;
		}
		
		public String decimalToBinary(int decimalnew, int base) {
		    String binary = "";
		    while(decimalnew != 0) {
		        int remainder = decimalnew % base;
		        binary = remainder + binary;
		        decimalnew /= base;
		    }
		    
		    int remainingLength = 32 - binary.length();
		    for(int i = 0; i < remainingLength; i++)
		        binary = "0" + binary;
		    
		    return binary;
		} 
		
	}
	
	


