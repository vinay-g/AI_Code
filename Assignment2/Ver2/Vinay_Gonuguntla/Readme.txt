

	---------------------------------
	|Name- Vinay Gonuguntla		|
	|Student ID- 4452934991		|			    
	|Email ID- gonagunt@usc.edu	|
	---------------------------------




COMPILE---------------------------------------------------------------------------------------------------

 javac -classpath . AstarSearch.java GreedySearch.java Search.java Utilities.java Node.java Main.java

RUN-------------------------------------------------------------------------------------------------------

 java Main

STRUCTURE--------------------------------------------------------------------------------------------------

MAIN:

It has main method which will call Greedy search and A* Search in a sequence.
Utilities- this class has all the helper functions such as load, display, vector addition, and nodeCompare.
load- creates the 12 nodes and creates the children relationship between them.
display- display the propogation path of the search algorithms.
node Compare - compare the fn function of each node returns the appropriate value
vector addition - adds the corresponding vector values of 2 adjacent nodes and returns the sum.

relationMatrix- Contains the entire movie relation graph in a 2-d matrix format.
heuristic - contains the heuristic of each of the nodes from m1 to m12
childrenRelation- this matix array gives the children relation between each node and their children.


------------------------------------------------------------------------------------------------------------
Greedy Search

GreedySearch()
	
      enqueue sourcenode onto Q
      mark node 
      while Q is not empty:
	sort the Q against fn // fn = heuristic
          t = Q.dequeue()
          if t is dest:
              return true
          for all edges e in adjacent to t do		
             u = G.adjacentVertex(t,e)                 // this is done manually by traversing child nodes
             if u is not marked:
                  mark u
		  assign parent
                  enqueue u onto Q // based on heuristic
     return false
-------------------------------------------------------------------------------------------------------------

A* Star Search

AStar Search()
	
      enqueue sourcenode onto Q
      mark node 
      while Q is not empty:
	sort the Q against fn // fn = heuristic + gn
          t = Q.dequeue()
          if t is dest:
              return true
          for all edges e in adjacent to t do		
             u = G.adjacentVertex(t,e)                 // this is done manually by traversing child nodes
             if u is not marked:
                  mark u
		  calculate gn    //using the formula + parent gn
		  calculate fn    //gn + heuristic 
		  assign parent
                  enqueue u onto Q // based on heuristic
     return false

---------------------------------------------------------------------------------------------------------------
Display

The nodes are displayed using backtracking of the parent node. 
The parent node is stored as part of the child node.


SAMPLE OUTPUT--------------------------------------------------------------------------------------------

Greedy Search
Traversal sequence:
m1,m3,m6,m9,m12
Dissimilarity:37
Propagating path:
m1,m3,m6,m9,m12

A* Search
Traversal sequence:
m1,m3,m4,m7,m9,m2,m8,m12
Dissimilarity:25
Propagating path:
m1,m3,m7,m9,m12
--------------------------------------------------------------------------------------------------------------------------------------------------------------

