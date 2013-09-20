
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class GreedySearch implements Search {

    LinkedList<Node> queue = new LinkedList<Node>();

    public boolean action(ArrayList<Node> mainArray) {
        System.out.println("Greedy Search");
        System.out.println("Traversal sequence:");
        //Adding First node to the queue
        Node tempNode = mainArray.get(0);
        tempNode.traversed = true;
        tempNode.fn = tempNode.heuristic;
        queue.addLast(tempNode);
        while (queue.size() != 0) {
            // Sort the queue so that the least cost heuristic is popped
            Collections.sort(queue, new Utilities());
            Node tempNode2 = queue.getFirst();
            queue.removeFirst();
            System.out.print(tempNode2.nodeName);
            //Check if this is the GOAL
            if (tempNode2.heuristic == 0) {
                return true;
            }
            System.out.print(",");
            // check all the child nodes and add them to the queue
            for (int i = 0; i < tempNode2.children.size(); i++) {
                Node tempNode3 = tempNode2.children.get(i);
                if (tempNode3.traversed == false) {
                    tempNode3.parent = tempNode2;
                    tempNode3.traversed = true;
                    tempNode3.fn = tempNode3.heuristic;
                    queue.add(tempNode3);
                }
            }
        }
        return false;
    }
}
