
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/*
 *This class contains all the utilities required by search and program
 * display---- display the node propogating path by using parent node 
 *              present in each node
 * load------- Used to populate the array with nodes and their children
 * vectorAddition- Used to add the columsn vector wise as used in the dissimilarity formula
 * compare---- used to compare the evaluating function to choose the right path
 * @author vinay
 */
public class Utilities implements Comparator<Node> {

    public static int[] heuristic = {00, 12, 10, 9, 10, 7, 6, 7, 6, 4, 4, 3, 0};
    public static int relationMatrix[][] = {{},
        {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
        {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
        {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1}};
    public static int childRelation[][] = {{}, {2, 3, 4}, {1, 5, 6, 8}, {1, 5, 6, 7}, {1, 5, 7, 8}, {2, 3, 4, 9}, {2, 3, 9, 10}, {3, 4, 9, 11}, {2, 4, 10}, {5, 6, 7, 12}, {6, 8, 12}, {7, 12}, {9, 10, 11}};
    public ArrayList<Node> mainArray = new ArrayList<Node>();

    public void load() {
        try {
            for (int i = 1; i < 13; i++) {
                Node newNode = new Node();
                newNode.index = i;
                newNode.nodeName = "m" + i;
                newNode.heuristic = heuristic[i];
                newNode.traversed = false;
                mainArray.add(newNode);
            }
            for (int i = 1; i < 13; i++) {
                ArrayList<Node> tempChildren = new ArrayList<Node>();
                int length = childRelation[i].length;
                for (int j = 0; j < length; j++) {
                    tempChildren.add(mainArray.get(childRelation[i][j] - 1));
                }
                Node tempNode = mainArray.get(i - 1);
                tempNode.children = tempChildren;
            }
            //Use for debug to print the nodes
		/*for(int k=1;k<13;k++){
            Node temp2=mainArray.get(k-1);
            System.out.println("Index: "+temp2.nodeName+" -"+temp2.heuristic);
            for(int j=0;j<temp2.children.size();j++){
            
            System.out.print(temp2.children.get(j).nodeName);
            System.out.print("  ");
            }
            System.out.println();
            }*/
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            System.exit(0);
        }
    }

    public void display() {
        Node temp5 = mainArray.get(11);
        System.out.println();
        LinkedList<Node> rev = new LinkedList<Node>();
        int dissimlarity = 0;
        while (true) {
            //	System.out.print(temp5.nodeName);
            rev.addFirst(temp5);
            if (temp5.nodeName.equals("m1")) {
                //	rev.addFirst(main.get(0));
                break;
            }
            String w = temp5.parent.nodeName;
            Node tempPar = temp5;
            temp5 = mainArray.get(Integer.parseInt(w.substring(1)) - 1);
            dissimlarity = dissimlarity + (((temp5.index + tempPar.index) % 5 + 1) * (5 - vectorAddition(temp5.index, tempPar.index)));
        }
        int sz = rev.size();
        System.out.println("Dissimilarity:" + dissimlarity);
        System.out.println("Propagating path:");
        for (int i = 0; i < sz - 1; i++) {
            System.out.print(rev.removeFirst().nodeName);
            System.out.print(",");
        }

        System.out.print(rev.removeFirst().nodeName);
    }

    public static int vectorAddition(int a1, int a2) {
        int vectorSum = 0;
        for (int i = 0; i < 30; i++) {
            vectorSum += relationMatrix[a1][i] * relationMatrix[a2][i];
        }
        return vectorSum;
    }

    public int compare(Node n1, Node n2) {
        if (n1.fn > n2.fn) {
            return 1;
        } else if (n1.fn < n2.fn) {
            return -1;
        } else if (n1.fn == n2.fn) {
            return 0;
        }
        return 0;
    }
}

