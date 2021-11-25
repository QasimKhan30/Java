
import java.util.*;

/**
 *  * This class describes a single Java Byte Code instruction.
 * @author W. Masri
 * @author Qasim Khan
 */
public class Instruction
{
	/**
	 * Offset is the number at the beginning of the instruction.
	 */
	private int offset;
	/**
	 * opcode is the instruction.
	 */
	private String opcode;
	/**
	 * ArrayList of integers is used for the parameters.
	 */
	private ArrayList<Integer> parameters;  

	/**
	 * Constructor for Instruction.
	 * @param s String that contains instruction information.
	 */
	public Instruction(String s) {  

		s = s.trim();
		parameters = new ArrayList<Integer>();

		String[] tokens = s.split("[:|,|\\s]+");
		int count = 1;
		for (String token : tokens) {
			String item = token.trim();
			if (item.length() == 0) {
				System.out.println("blank item");
				continue;
			}
			if (count == 1) {
				offset = Integer.valueOf(item);
			} else if (count == 2) {
				opcode = item;
			} else if (count == 3) {			
				parameters.add(Integer.valueOf(item));  
			} else if (count == 4) {
				parameters.add(Integer.valueOf(item));  
			} else {
				throw new RuntimeException("Illegal format: " + item);
			}
			count++;
		}

	}

	/**
	 * This method returns the string representation for the class.
	 * @return String representation of instruction.
	 */
	public String toString() {
		String s = offset + ": " + opcode + " ";
		if (parameters != null) {
			for (int param : parameters) {
				s += param + " ";
			}
		}
		return s;
	}

	/**
	 * Getter for Offset.
	 * @return int Offset
	 */
	public int getOffset() { return offset; }

	/**
	 * Getter for Opcode.
	 * @return String Opcode
	 */
	public String getOpcode() { return opcode; }

	/**
	 * Getter for number of parameters.
	 * @return int number of parameters
	 */
	public int getNumParameters() { return parameters.size(); }

	/**
	 * Getter for parameter one.
	 * @return int parameter one.
	 */
	public int getParam1() { 
		if (getNumParameters() < 1) {
			throw new RuntimeException("instruction takes zero parameters");
		}
		return parameters.get(0); 
	}

	/**
	 * Getter for parameter two.
	 * @return int parameter two.
	 */
	public int getParam2() { 
		if (getNumParameters() < 2) {
			throw new RuntimeException("instruction takes zero or one parameters");
		}
		return parameters.get(1); 
	}

	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String args[]) {

		Instruction ins = new Instruction("0: iconst_2");
		if ( (ins.getOffset() == 0) && 
				(ins.getOpcode().equals("iconst_2")) && 
				(ins.getNumParameters() == 0)) {
			System.out.println("Yay1");
		}

		ins = new Instruction("21 : bipush         6");
		if ( (ins.getOffset() == 21) && 
				(ins.getOpcode().equals("bipush")) && 
				(ins.getNumParameters() == 1) &&
				(ins.getParam1() == 6) )
		{
			System.out.println("Yay2");
		}

		ins = new Instruction("40:iinc 4, 1");
		if ( (ins.getOffset() == 40) && 
				(ins.getOpcode().equals("iinc")) && 
				(ins.getNumParameters() == 2) &&
				(ins.getParam1() == 4) && (ins.getParam2() == 1)) {
			System.out.println("Yay3");


		}
	}

}