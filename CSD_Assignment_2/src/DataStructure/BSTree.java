package DataStructure;

import java.util.Stack;

public abstract class BSTree<N> {

    public BST_Node root;

    // Count
    public int count() {
        return count(root);
    }

    protected int count(BST_Node p) {
        if (p == null) {
            return 0;
        }
        int c = 0;
        if (p.left != null) {
            c++;
        }
        if (p.right != null) {
            c++;
        }
        c += count(p.left);
        c += count(p.right);
        return c;
    }

    // Insert
    public abstract void insert(BST_Node n);

    public void insertMany(BST_Node[] ns) {
        for (int i = 0; i < ns.length; i++) {
            insert(ns[i]);
        }
    }

    // Tree tranversal
    public void visit(BST_Node n) {
        System.out.print(n.value);
    }

    public void inorder() {
        inorder(root);
    }
    
    protected void inorder(BST_Node p) {
        if (p == null) {
            return;
        }

        inorder(p.left);
        visit(p);
        inorder(p.right);
    }

    protected BST_Node[] inorderIterate() {
        BST_Node nodes[] = new BST_Node[count() + 1];
        int i = 0;
        
        BST_Node p = root;
        Stack travStack = new Stack();
        while (p != null) {
            while (p != null) {
                if (p.right != null)
                    travStack.push(p.right);
                travStack.push(p);
                p = p.left;
            }
            p = (BST_Node) travStack.pop();
            while (!travStack.isEmpty() && p.right == null) {
                nodes[i++] = p;
                p = (BST_Node) travStack.pop();
            }
            nodes[i++] = p;
            p = (!travStack.isEmpty()) ? (BST_Node) travStack.pop() : null;
        }
        return nodes;
    }

    public void postorder() {
        postorder(root);
    }

    protected void postorder(BST_Node p) {
        if (p == null) {
            return;
        }

        postorder(p.left);
        postorder(p.right);
        visit(p);
    }

    public void preorder() {
        preorder(root);
    }

    protected void preorder(BST_Node p) {
        if (p == null) {
            return;
        }

        visit(p);
        preorder(p.left);
        preorder(p.right);
    }

    public void breadthfirst() {
        BST_Node p = root;
        Queue queue = new Queue();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = (BST_Node) queue.dequeue();
                visit(p);
                if (p.left != null) {
                    queue.enqueue(p.left);
                }
                if (p.right != null) {
                    queue.enqueue(p.right);
                }
            }
        }
    }

    // Delete
    public abstract void delcopy(Object v);

    public abstract void delmerge(Object v);

    // Balancing
    public abstract void balancing(N data[], int first, int last);

}
