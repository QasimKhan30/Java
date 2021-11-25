import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * Basic interpreter for a very small subset of the Java Byte Code language.
 * @author Qasim Khan
 */
public class Interpreter {


	/**
	 * Stack used to evaluate a list of instructions.
	 */
	private Stack<Integer> stack = new Stack<>();


	/**
	 * HashMap used to map the index of a variable to its value.
	 */
	private HashMap<Integer,Integer> numberHashMap = new HashMap<>();
	/**
	 * HashMap used to map the offset of an instruction to its corresponding node in the LList.
	 */
	private static HashMap<Integer,Node<Instruction>> nodeHashMap = new HashMap<>();


	/**
	 * Reads the file and creates a linked list with the instructions and a HashMap where the offset is the key and the corresponding node is the value.
	 * @param filename File to be parsed for instructions.
	 * @return LList of type Instruction where instructions are stored.
	 * @throws IOException when encounter difficulty in reading file.
	 */
	public static LList<Instruction> readFile(String filename) throws IOException {

		File file = new File(filename);
		if(filename.length() < 0 || file == null) {throw new IOException();}

		Scanner scnr = new Scanner(file);
		LList<Instruction> linkedList = new LList<>();
		while(scnr.hasNextLine()) 
		{
			String s = scnr.nextLine();
			Instruction i = new Instruction(s);
			nodeHashMap.put(i.getOffset(), new Node<Instruction>(i));
			linkedList.insertLast(new Node<Instruction>(i));


		}
		scnr.close();

		return linkedList;
	}
	
	/**
	 * This function traverses and evaluates the LList of instructions.
	 * @param list where the instructions come from.
	 */
	public void evaluateInstructions(LList<Instruction> list) {

		Node<Instruction> current = list.getFirst();
		while(current != null) 
		{
			Instruction i = current.getValue();
			String s = i.getOpcode();
			
			if(s.equals("iconst_0"))
			{
				stack.push(0);
			}
			if(s.equals("iconst_1")) 
			{
				stack.push(1);
			}
			if(s.equals("iconst_2")) 
			{
				stack.push(2);
			}
			if(s.equals("iconst_3")) 
			{
				stack.push(3);
			}
			if(s.equals("iconst_4")) 
			{
				stack.push(4);
			}
			if(s.equals("iconst_5")) 
			{
				stack.push(5);
			}
			if(s.equals("bipush")) 
			{
				stack.push(i.getParam1());
			}
			if(s.equals("iadd")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				stack.push(num1 + num2);
			}
			if(s.equals("imul")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				stack.push(num1 * num2);
			}
			if(s.equals("idiv")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				stack.push(num2 / num1);
			}
			if(s.equals("isub")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				stack.push(num2 - num1);
			}
			if(s.equals("irem")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				stack.push(num2 % num1);
			}
			if(s.equals("print")) 
			{
				System.out.print(stack.pop() + " ");
			}
			if(s.equals("return"))
			{
				return;
			}
			
			//PHASE 2
			
			if(s.equals("iload_0")) 
			{
				stack.push(numberHashMap.get(0));
			}
			
			if(s.equals("iload_1")) 
			{
				stack.push(numberHashMap.get(1));
			}
			
			if(s.equals("iload_2")) 
			{
				stack.push(numberHashMap.get(2));
			}
			
			if(s.equals("iload_3")) 
			{
				stack.push(numberHashMap.get(3));
			}
			
			if(s.equals("iload")) 
			{
				stack.push(numberHashMap.get(i.getParam1()));
			}
			
			if(s.equals("istore_0")) 
			{
				numberHashMap.put(0, stack.pop());
			}
			
			if(s.equals("istore_1")) 
			{
				numberHashMap.put(1, stack.pop());
			}
			if(s.equals("istore_2")) 
			{
				numberHashMap.put(2, stack.pop());
			}
			if(s.equals("istore_3")) 
			{
				numberHashMap.put(3, stack.pop());
			}
			if(s.equals("istore")) 
			{
				numberHashMap.put(i.getParam1(), stack.pop());
			}
			if(s.equals("iinc")) 
			{
				numberHashMap.put(i.getParam1(), numberHashMap.get(i.getParam1()) + i.getParam2());
			}
			
			// Jumps and Conditionals
			
			if(s.equals("goto")) 
			{
				current = list.getFirst();
				while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
				{
					current = current.getNext();
				}
				continue;
			}
			
			if(s.equals("if_icmpeq")) 
			{
				if(stack.pop() == stack.pop()) 
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}

			if(s.equals("if_icmpne")) 
			{
				if(stack.pop() != stack.pop()) 
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}

			if(s.equals("if_icmpge")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				if(num1 <= num2)
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}
			
			if(s.equals("if_icmpgt")) 
			{
				int num1 = stack.pop(),num2 = stack.pop();
				if(num1 < num2)
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}
			
			if(s.equals("if_icmple")) 
			{
				if(stack.pop() >= stack.pop())
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}
			
			if(s.equals("if_icmplt")) 
			{
				if(stack.pop() > stack.pop())
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}

			if(s.equals("ifne")) 
			{
				if(stack.pop() != 0)
				{
					current = list.getFirst();
					while(current.getValue().getOffset() != nodeHashMap.get(i.getParam1()).getValue().getOffset()) 
					{
						current = current.getNext();
					}
					continue;
				}
			}


			current = current.getNext();
		}


	}

	
	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		

	
		if(args.length != 1) {
			System.out.println("Usage: java Interpreter [filename]");
			System.exit(0);
		}
		
		try {
			LList<Instruction> input = readFile(args[0]);		
			new Interpreter().evaluateInstructions(input);		
		}
		catch(IOException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}
}