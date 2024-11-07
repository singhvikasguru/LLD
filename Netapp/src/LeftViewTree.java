import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 1
//2   3

//  1
// 2
//3

// 1
//    2
//      3

//  1
//8    2
//      3
//        5
//      4

// 1
//    2
//      3
//    4

public class LeftViewTree {
    Map<Integer, Integer> res;
    List<List<Integer>> paths;

    public LeftViewTree() {
        this.res = new HashMap<>();
        this.paths= new ArrayList<>();
    }

    public void leftView(TreeNode root, int height)
    {
        if(root==null)
            return;
        if(!res.containsKey(height))
            res.put(height, root.val);
        leftView(root.right, height+1);
        leftView(root.left, height+1);

    }
    public void shortestPath(TreeNode node, List<Integer> path, int destination)
    {
        if(node==null)
            return;
        if (node.val==destination)
        {
            path.add(node.val);
            paths.add(new ArrayList<>(path));
            System.out.println(path.toString());
            return;
        }
        path.add(node.val);
        shortestPath(node.left,path, destination);
        shortestPath(node.right,path, destination);
        path.remove(path.size()-1);

    }
    public static void main(String[] args) {
        TreeNode node= new TreeNode(1, null, null);
        TreeNode two=new TreeNode(2, null, null);
        TreeNode three=new TreeNode(3, null, null);
        TreeNode four=new TreeNode(4, null, null);
        TreeNode five=new TreeNode(5, null, null);
        TreeNode eight=new TreeNode(8, null, null);

        node.right=two;
        node.left=eight;
        eight.right=four;
        two.right=three;
//        right.left=four;
        three.right=five;
        five.left=four;

        LeftViewTree obj= new LeftViewTree();
//        obj.leftView(node, 0);
//        System.out.println(obj.res.toString());
        List<Integer> path= new ArrayList<>();
        obj.shortestPath(node,path, 4);
        System.out.println(obj.paths.toString());
    }
}
