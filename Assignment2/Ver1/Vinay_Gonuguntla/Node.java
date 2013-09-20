
import java.util.ArrayList;

/*This class defines the node structure used in all the 
 * Search algorithms
 * index-----cotains the value of the index (currently 1 to 12)
 * nodeName--contains the name of the node ex: mX ( x- 1..12)
 * heuristic-cotains the heuristic value
 * traversed-If the node has traversed before
 * children--Contains the child node list
 * fn--------Evaluation function to decide the next traversal( = gn + hn)
 * gn--------cost of the path till now (zero case of greedy)
 * hn--------heuristic value
 * parent----parent of current node
 */

/**
 * @author vinay
 */
public class Node{
	String nodeName;
	int index;
	int heuristic;
	boolean traversed;
	ArrayList<Node> children;
	int fn;
	int gn;
	int hn;
	Node parent;
}
