
public class Main {

    /**Main functon is the start oint to call the 2 search algorithms
     * Utilities function contains the load and display functions
     * Each search gets its own utilities to be independent and prevent overwrite
     */
    public static void main(String[] args) {
        // Call and display Greedy
        Utilities u = new Utilities();
        u.load();
        GreedySearch g = new GreedySearch();
        g.action(u.mainArray);
        u.display();
        
        System.out.println();
        // Call and display AStar
        Utilities u2 = new Utilities();
        u2.load();
        AstarSearch a = new AstarSearch();
        a.action(u2.mainArray);
        u2.display();
        
        System.out.println();

    }
}
