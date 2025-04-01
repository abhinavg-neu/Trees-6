/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	//Time Complexity:O(n)
	//Space Complexity:O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
        return new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qLevel = new LinkedList<>();
        HashMap <Integer,List<TreeNode>> map = new HashMap <>();

        q.add(root);
        qLevel.add(0);
        int min =0;
        int max =0;

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int level = qLevel.poll();
            if (node != null){
            min = Math.min(min,level);
            max = Math.max(max,level);

            if(!map.containsKey(level)){
                map.put(level, new ArrayList<>());
            }
            map.get(level).add (node);

            if (node.left != null){
                q.add ( node.left);
                qLevel.add (level -1);
            }
             if (node.right != null){
                q.add ( node.right);
                qLevel.add (level +1);
            }
        }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(map.size());
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++){
            List<TreeNode> currLevel = map.get(i);
            List<Integer> l = new ArrayList<>();
            for (TreeNode n : currLevel)
            l.add(n.val);
            res.add(l);
        }
        return res;
    }
}
