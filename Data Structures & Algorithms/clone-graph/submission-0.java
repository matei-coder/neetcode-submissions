/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    //DataStructures one Map from original to copy and a visited set for the second dfs
    private  Map<Node ,Node> map; //original Node -> clone Node
    private final Set<Node> visited = new HashSet<>();


    public Node cloneGraph(Node node) {
        //edge cases
        if(node == null) return null;


        map = new HashMap<>();

        //generation of the clone graph
        dfsGenerator(node);
        dfsEdgeAdder(node);

        return map.get(node);

    }
    
    //adder of the nodes int the map
    private void dfsGenerator(Node node){
        map.put(node , new Node(node.val));
        for(Node next : node.neighbors){
            if(!map.containsKey(next)){
                dfsGenerator(next);
            }           
        }
    }
    //adder of edges from the original nodes onto the clone nodes
    private void dfsEdgeAdder(Node node){
        visited.add(node);
        for(Node next : node.neighbors){
            map.get(node).neighbors.add(map.get(next));
            if(!visited.contains(next)){
                dfsEdgeAdder(next);
            }           
        }
    }















}