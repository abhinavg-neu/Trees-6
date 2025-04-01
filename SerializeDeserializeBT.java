/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node != null){
            sb.append(node.val);
            sb.append(",");
            q.offer(node.left);
            q.offer(node.right);
        } else {
            sb.append("null,");
        }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       //create String array
             if (data.length() == 0)
      return null;
      String[] arr = data.split(",");
      if (arr.length ==0 || arr[0].equals("null"))
      return null;
      Queue<TreeNode> q = new LinkedList<>(); 
      int i =1;
      TreeNode root =  new TreeNode(Integer.parseInt(arr[0]));
      q.offer(root);
      while(!q.isEmpty()){
        TreeNode node = q.poll();
        if (arr[i].equals("null") ||arr[i].equals("null,")){
            node.left = null;
        } else {
            TreeNode n = new TreeNode(Integer.parseInt(arr[i]));
            node.left = n;
            q.offer(n);
        }
        i++;
        // now do right side
         if (arr[i].equals("null") ||arr[i].equals("null,")){
            node.right = null;
        } else {
            TreeNode n = new TreeNode(Integer.parseInt(arr[i]));
            node.right = n;
            q.offer(n);
        }
        i++;
      }
        return root;
    }
}

