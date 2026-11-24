/*
// Definition for a Node.
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
    private void dfs(Node node  , HashMap<Node , Node> map ){
        Node clone = new Node(node.val);
        map.put(node,clone);

        for(Node ne : node.neighbors)
        {
            if(!map.containsKey(ne))
            {
                
                 dfs(ne,map);
            }
            clone.neighbors.add(map.get(ne));
           
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node , Node> map = new HashMap<>();

        dfs(node,map);

        return map.get(node);



    }
}