
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class AstarSearch implements Search {

    LinkedList<Node> queue = new LinkedList<Node>();

    public boolean action(ArrayList<Node> mainArray) {
        System.out.println();
        System.out.println("A* Search");
        System.out.println("Traversal sequence:");
        Node tempNode = mainArray.get(0);
        tempNode.traversed = true;
        //System.out.print(temp.nodeName);
        queue.addLast(tempNode);
        while (queue.size() != 0) {
            // Sort the queue on every iteration to get the least fn
            Collections.sort(queue, new Utilities());
            //Pop the first node
            Node tempNode2 = queue.removeFirst();
            System.out.print(tempNode2.nodeName);
            // If the node popped is the goal node Exit
            if (tempNode2.nodeName.equals("m12")) {
                return true;
            }
            System.out.print(",");
            // Scrolls through the adjacency list to find the children
            for (int i = 0; i < tempNode2.children.size(); i++) {
                Node tempNode3 = tempNode2.children.get(i);
                //calculates the path value
                int gn = ((tempNode3.index + tempNode2.index) % 5 + 1) * (5 - Utilities.vectorAddition(tempNode3.index, tempNode2.index)) + tempNode2.gn;
                int fn = gn + tempNode3.heuristic;
                if (tempNode3.traversed == false) {
                    tempNode3.fn = fn;
                    tempNode3.gn = gn;
                    tempNode3.parent = tempNode2;
                    tempNode3.traversed = true;
                    queue.add(tempNode3);
                }
            }
        }
        return false;
    }
}
