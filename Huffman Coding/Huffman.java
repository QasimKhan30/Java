import java.io.*;

/**
 * Huffman Encoding Tree Implementation.
 * @author Qasim Khan
 * @author Yutao Zhong.
 */
class Huffman implements Serializable {
	// Note: We define this class (and a couple of other classes of
	// this project) as Serializable in order to be able to save
	// the Huffman Object into a file for encoding/decoding.
	// (See main method below for details.)
	// You do not need to do anything special in your implementation
	// for this. When a serializable object gets output into a file,
	// "transient" members will be skipped.
	// -------------------------------------------------------------
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	// -------------------------------------------------------------

	/**
	 * Default length used to create hashtables.
	 */
	public static final int DEFAULT_TABLE_LENGTH = 11;

	/**
	 * Original input string to encode.
	 */
	private transient String inputContents = null;

	/**
	 * Hashtable used to count the frequencies of input characters.
	 */
	private transient HashTable<Character, Integer> counts = new HashTable<Character, Integer>(DEFAULT_TABLE_LENGTH);

	/**
	 * Priority queue used to build Huffman tree.
	 */
	private transient PriorityQueue<TreeNode> queue = new PriorityQueue<>();

	/**
	 * Huffman tree.
	 */
	private BinaryTree huffmanTree = new BinaryTree();

	/**
	 * Hashtable used to record the encoding for input characters.
	 */
	private HashTable<Character, String> encodings = new HashTable<>(DEFAULT_TABLE_LENGTH);

	/**
	 * Setter for counts.
	 * @param counts HashTable of type Character,Integer to be set as counts.
	 */
	public void setCounts(HashTable<Character, Integer> counts) {
		this.counts = counts;
	}

	/**
	 * Getter for Counts.
	 * @return HashTable of type Character,Integer counts.
	 */
	public HashTable<Character, Integer> getCounts() {
		return counts;
	}

	/**
	 * Setter for Priority Queue.
	 * @param queue Priority Queueof type TreeNode to be set as queue.
	 */
	public void setQueue(PriorityQueue<TreeNode> queue) {
		this.queue = queue;
	}

	/**
	 * Getter for Priority Queue.
	 * @return Priority Queue of type TreeNode.
	 */
	public PriorityQueue<TreeNode> getQueue() {
		return queue;
	}

	/**
	 * Setter for Huffman Tree.
	 * @param huffmanTree Binary Tree to be set as Huffman Tree.
	 */
	public void setTree(BinaryTree huffmanTree) {
		this.huffmanTree = huffmanTree;
	}

	/**
	 * Getter for Huffman Tree.
	 * @return Binary Tree.
	 */
	public BinaryTree getTree() {
		return huffmanTree;
	}

	/**
	 * Getter for encodings.
	 * @return HashTable of type Character,String encodings.
	 */
	public HashTable<Character, String> getEncodings() {
		return encodings;
	}

	/**
	 * Generates the encoding result from the Huffman Tree.
	 */
	public void computeEncodings() {
		computeEncodings(huffmanTree.root, "");
	}

	/**
	 * Recursive helper method for encoding.
	 * @param currentLoc TreeNode of current location.
	 * @param encoding String that is encoded.
	 */
	private void computeEncodings(TreeNode currentLoc, String encoding) {
		if (currentLoc.character != null) {
			this.encodings.put(currentLoc.character, encoding);
		} else {
			computeEncodings(currentLoc.left, encoding + "0");
			computeEncodings(currentLoc.right, encoding + "1");
		}
	}

	/**
	 * Use the encoding hashtable to generate a string of 0's and 1's as the
	 * encoding of the input.
	 * @param input string that is to be encoded.
	 * @return String that is encoded.
	 */
	public String encode(String input) {

		StringBuffer output = new StringBuffer();

		for (char ch : input.toCharArray()) {
			output.append(this.encodings.get(ch));
		}
		
		return output.toString();

	}

	/**
	 * This function encodes inputContents after encodings are computed.
	 * @return String encodings.
	 */
	public String encode() {

		StringBuffer output = new StringBuffer();

		for (char ch : inputContents.toCharArray()) {
			output.append(this.encodings.get(ch));
		}

		return output.toString();

	}

	// -------------------------------------------------------------
	// END OF PROVIDED "DO NOT EDIT" SECTION
	// -------------------------------------------------------------

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!

	/**
	 * Constructor for Huffman class.
	 * @param input is set to input contents.
	 */
	public Huffman(String input) {

		inputContents = input;

	}

	/**
	 * This void method counts the number of occurrences of each character and
	 * stores it in the hashtable counts.
	 */
	public void createCounts() {

		HashTable<Character, Integer> counts = new HashTable<Character, Integer>(DEFAULT_TABLE_LENGTH);

		
		for(int i = 0; i < inputContents.length(); i++) 
		{
			char c = inputContents.charAt(i);
			int count = 1;
			
			//check if we have already counted the character c.
			if(counts.get(c) == null) // we have not counted the character. 
			{
				for(int j = 0; j < inputContents.length(); j++) 
				{
					//make sure we do not count the same character twice.
					if(j == i) 
					{
						continue;
					}
					if(c == inputContents.charAt(j)) 
					{
						count ++;
					}
				}
				counts.put(c, count);
			}
		}
		this.counts = counts;

	}

	/**
	 * Frequency information from counts is used to create a leaf of type TreeNode.
	 * Characters are processed and nodes are added one by one to a priority queue.
	 * The original order of input contents is followed to process characters.
	 */
	public void initQueue() {

		PriorityQueue<TreeNode> queue = new PriorityQueue<TreeNode>();
		for (int i = 0; i < inputContents.length(); i++) {
			
			if (counts.get(inputContents.charAt(i)) != null) {
				
				TreeNode node = new TreeNode(counts.get(inputContents.charAt(i)), inputContents.charAt(i));
				
				if (queue.contains(node)) {
					continue;
				} else {
					queue.add(node);
				}
			}
		}
		this.queue = queue;

	}

	/**
	 * Nodes are merged together to create a binary tree. This binary tree is used
	 * for Huffman Encoding (Huffman encoding tree).
	 */
	public void buildTree() {
		
		while (queue.size() > 0) {
			TreeNode node1 = queue.remove();
			TreeNode node2 = queue.remove();
			TreeNode node3 = new TreeNode(node1.count + node2.count);

			node3.left = node1;
			node3.right = node2;
			queue.add(node3);
			if (queue.size() == 1) {
				huffmanTree.root = node3;
				return;
			}
		}

	}

	/**
	 * This function is used to decode a Huffman tree.
	 * 
	 * @param input string to decode.
	 * @return decoded string.
	 */
	public String decode(String input) {

		TreeNode current = huffmanTree.root;
		StringBuilder sb = new StringBuilder();
		char[] characterArray = input.toCharArray();

		for (char ch : characterArray) {
			int direction = Character.getNumericValue(ch);

			if (current.left == null && current.right == null) {
				sb.append(current.character);
				current = huffmanTree.root;
			}
			if (direction == 0) {
				current = current.left;
			}
			if (direction == 1) {
				current = current.right;
			}
		}
		if(current.character != null && (current.left == null) && (current.right == null)) 
		{
			sb.append(current.character);
		}
	
		return sb.toString();

	}

	// -------------------------------------------------------------
	// PROVIDED TESTING CODE: FEEL FREE TO EDIT
	// -------------------------------------------------------------
	/**
	 * Function used to help with testing.
	 */
	public static void testMain() {

		Huffman huff = new Huffman("cabbeadcdcdcdbbd");

		// step 1: count frequency
		huff.createCounts();
		HashTable<Character, Integer> counts = huff.getCounts();
		// System.out.println(counts);
		// System.out.println(counts.toStringDebug());


		if (counts.size() == 5 && counts.get('a') == 2 && counts.get('e') == 1
				&& counts.toString().equals("c:4\nd:5\ne:1\na:2\nb:4")) {
			System.out.println("Yay 1");
		}

		// step 2: initialize priority queue with leaf nodes
		huff.initQueue();
		PriorityQueue<TreeNode> queue = huff.getQueue();
		// System.out.println(queue);
		if (queue.size() == 5 && queue.element().character == 'e' && queue.element().count == 1) {
			System.out.println("Yay 2");
		}

		if (queue.toString().equals("<e,1> <a,2> <b,4> <c,4> <d,5>")) {
			System.out.println("Yay 3");
		}

		// step 3: build huffman tree with the help of priority queue
		huff.buildTree();
		BinaryTree tree = huff.getTree();

		if (tree.root.count == 16 && tree.root.left.count == 7 & tree.root.right.count == 9) {
			System.out.println("Yay 4");
		}

		// System.out.println(tree.toStringPreOrder());
		if (tree.toStringPreOrder().equals("<null,16><null,7><null,3><e,1><a,2><b,4><null,9><c,4><d,5>")) {
			System.out.println("Yay 5");
		}

		// step 4: encoding and decoding
		huff.computeEncodings();
		//System.out.println(huff.getEncodings());
		if (huff.decode("1000101").equals("cab") && huff.encode("cab").equals("1000101")) {
			System.out.println("Yay 6");
		}

	}
	// -------------------------------------------------------------
	// END OF TESTING CODE
	// -------------------------------------------------------------

	// -------------------------------------------------------------
	// DO NOT EDIT ANYTHING FOR THIS SECTION EXCEPT TO ADD JAVADOCS
	// -------------------------------------------------------------
	// --------------------------------------------------------------------------------
	// How to run:
	// - To run testMain: java Huffman
	// - To encode: java Huffman -e fileToEncode encodedOutputFile
	// HuffmanObjectOutputFile
	// - To decode: java Huffman -d fileToDecode decodedOutputFile
	// HuffmanObjectInputFile
	// --------------------------------------------------------------------------------

	/**
	 * Main method used for testing.
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		// no command-line args: provided testing of Huffman's algorithm
		if (args.length == 0) {
			testMain();
			return;
		}

		// with command-line args: file I/O for encoding/decoding
		if (args[0].equals("-e") && (args.length < 4 || args.length > 4)) {
			System.out.println("Usage: java Huffman -e fileToEncode encodedOutputFile HuffmanObjectOutputFile");
			return;
		} else if (args[0].equals("-d") && (args.length < 4 || args.length > 4)) {
			System.out.println("Usage: java Huffman -d fileToDecode decodedOutputFile HuffmanObjectInputFile");
			return;
		} else if (!args[0].equals("-d") && !args[0].equals("-e")) {
			System.out.println("Usage: java Huffman -[e|d]");
			return;
		}

		String fileAsString;
		Huffman huff;
		try {
			switch (args[0])
			{
				case "-e": // encoding

					// read in fileToEncode
					fileAsString = getFileContents(args[1]);
					// System.out.println(fileAsString);

					// Huffman's algorithm
					huff = new Huffman(fileAsString);
					huff.createCounts(); // step 1s
					//System.out.println(huff.counts);
					huff.initQueue(); // step 2
					//System.out.println(huff.queue);
					huff.buildTree(); // step 3
					


					huff.computeEncodings();
					


					// encoding
					String encoding = huff.encode();
					//System.out.println("Encoded: " + encoding);

					// output encoded contents as a sequence of bits into file
					writeEncodedMessage(encoding, args[2]);

					// output Huffman object into file
					writeEncodedObject(huff, args[3]);
					break;

				case "-d": // decoding

					// read in from file and construct Huffman object
					huff = getEncodedObject(args[3]);

					// read in from file the encoded bits and
					// convert into a string (with only characters '0' and '1')
					fileAsString = getFileBinaryContents(args[1]);
					// System.out.println(fileAsString);

					// decoding
					String decodedMessage = huff.decode(fileAsString);

					// output decoded contents into file
					writeDecodedMessage(decodedMessage, args[2]);
					break;
			}
		} catch (IOException e) {
			System.out.println("Problem reading or writing to specified file");
			System.out.println(e.toString());
		}

	}

	/**
	 * Output a Huffman Object to file.
	 * @param huff Huffman tree.
	 * @param filename where Huffman Object is to be output.
	 * @throws IOException Exception to be thrown.
	 */
	public static void writeEncodedObject(Huffman huff, String filename) throws IOException {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {
			output.writeObject(huff);
		}
	}

	/**
	 * Read from a file and create a Huffman Object based on the file contents.
	 * @param filename where Huffman Object is to be output.
	 * @return Huffman Tree.
	 * @throws IOException Exception to be thrown.
	 */
	public static Huffman getEncodedObject(String filename) throws IOException {
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {
			return (Huffman) input.readObject();
		} catch (ClassNotFoundException e) {
			throw new IOException("Can not read class from provided file.");
		}
	}

	/**
	 * Read the encoding result (as a string of 0's and 1's) from a file.
	 * @param filename where encoding is to be read from.
	 * @return String filecontents.
	 * @throws IOException Exception to be thrown.
	 */
	public static String getFileBinaryContents(String filename) throws IOException {
		StringBuffer fileContents = new StringBuffer();
		try (BitInputStream bs = new BitInputStream(new FileInputStream(filename), true)) {
			while (bs.hasNextBit()) {
				fileContents.append(bs.readBit());
			}
		}
		return fileContents.toString();
	}

	/**
	 * Output the encoding result (a string of 0's and 1's) as a bit sequence into a file.
	 * @param message  to be written.
	 * @param filename location where encoding result is to be stored.
	 * @throws IOException Exception to be thrown.
	 */
	public static void writeEncodedMessage(String message, String filename) throws IOException {
		try (BitOutputStream bs = new BitOutputStream(new FileOutputStream(filename), true)) {
			bs.writeBits(message);
		}
	}

	/**
	 * Read from file and return file contents as a string.
	 * @param filename file to be read from.
	 * @return String contents of file.
	 * @throws IOException Exception to be thrown.
	 */
	public static String getFileContents(String filename) throws IOException {
		StringBuffer fileContents = new StringBuffer();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String input = br.readLine();
			fileContents.append(input);
			input = br.readLine();

			while (input != null) {
				fileContents.append("\n" + input);
				input = br.readLine();
			}
		}

		return fileContents.toString();
	}

	/**
	 * Output message as a sequence of bits to file.
	 * @param message  to be output.
	 * @param filename file where message is to be output.
	 * @throws IOException Exception to be thrown.
	 */
	public static void writeDecodedMessage(String message, String filename) throws IOException {
		try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
			br.write(message);
		}
	}

	// -------------------------------------------------------------
	// END OF PROVIDED "DO NOT EDIT" SECTION
	// -------------------------------------------------------------

}