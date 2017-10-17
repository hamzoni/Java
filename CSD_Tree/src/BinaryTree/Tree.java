
package BinaryTree;

import java.util.Stack;

public class Tree {
    
    protected Node root;
    
    public Tree() {
        root = null;
    }
    protected void visit(Node p) {
        System.out.println(p.key + " ");
    }
    public Node search(Node p, int el) {
        return search2(root, el);
    }
    protected Node search2(Node p, int el) {
        while (p != null)
            if (el == p.key)
                return p;
            else if (el < p.key)
                p = p.left;
            else p = p.right;
        return null;
    }
    public void breadthFirst() {
        Node p = root;
        Queue queue = new Queue();
        if (p != null) {
            queue.enqueue(p);
            while (!queue.isEmpty()) {
                p = queue.dequeue();
                visit(p);
                if (p.left != null) queue.enqueue(p.left);
                if (p.right != null) queue.enqueue(p.right);
            }
        }
    }
    public void preorder() {
        preorder(root);
    }
    protected void preorder(Node p) {
        if (p != null) {
            visit(p);
            preorder(p.left);
            preorder(p.right);
        }
    }
    public void inorder() {
        inorder(root);
    }
    protected void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            visit(p);
            inorder(p.right);
        }
    }
    public void postorder() {
        postorder(root);
    }
    protected void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            visit(p);
        }
    }
    public void iterativePreorder() {
        Node p = root;
        Stack travStack = new Stack();
        if (p != null) {
            travStack.push(p);
            while (!travStack.isEmpty()) {
                p = (Node) travStack.pop();
                visit(p);
                if (p.right != null) travStack.push(p.right);
                if (p.left != null) travStack.push(p.left);
            }
        }
    }
    public void iterativePostorder() {
        Node p = root, q = root;
        Stack travStack = new Stack();
        while (p != null) {
            for (; p.left != null; p = p.left) 
                travStack.push(p);
            while (p != null && (p.right == null | p.right == q)) {
                visit(p);
                q = p;
                if (travStack.isEmpty()) return;
                p = (Node) travStack.pop();
            }
            travStack.push(p);
            p = p.right;
        }
    }
    public void iterativeInorder() {
        Node p = root;
        Stack travStack = new Stack();
        while (p != null) {
            while (p != null) {
                if (p.right != null)
                    travStack.push(p.right);
                travStack.push(p);
                p = p.left;
            }
            p = (Node) travStack.pop();
            while (!travStack.isEmpty() && p.right == null) {
                visit(p);
                p = (Node) travStack.pop();
            }
            visit(p);
            if (!travStack.isEmpty()) 
                p = (Node) travStack.pop();
            else p = null;
        }
    }
    public void MorrisInorder() {
        Node p = root, tmp;
        while (p != null) {
            if (p.left == null) {
                visit(p);
                p = p.right;
            } else {
                tmp = p.left;
                while (tmp.right != null && tmp.right != p)
                    tmp = tmp.right;
                if (tmp.right == null) {
                    tmp.right = p;
                    p = p.left;
                } else {
                    visit(p);
                    tmp.right = null;
                    p = p.right;
                }
            }
        }
    }
    public void insert(int el) {
        Node p = root, prev = null;
        
        // Find a place for inserting new node
        while (p != null) {
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
            
        }
        
        if (root == null) {
            root = new Node(el);
        } else if (prev.key < el) {
            prev.right = new Node(el);
        } else {
            prev.left = new Node(el);
        }
    }
    
    public void deleteByMerging(int el) {
        Node tmp, node, p = root, prev = null;
        while (p != null && p.key != el) {
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                tmp = node.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = node.right;
                node = node.left;
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("Key " + el + " is not in the tree");
        } else {
            System.out.println("Tree is empty");
        }
    }
    public void deleteBycopying(int el) {
        Node node, p = root, prev = null;
        while (p != null && p.key != el) {
            prev = p;
            if (p.key < el) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;
        if (p != null && p.key == el) {
            if (node.right == null) {
                node = node.left;
            } else if (node.left == null) {
                node = node.right;
            } else {
                Node tmp = node.left;
                Node previous = node;
                while (tmp.right != null) {
                    previous = tmp;
                    tmp = tmp.right;
                }
                node.key = tmp.key;
                
                if (previous == node) {
                    previous.left = tmp.left;
                } else {
                    previous.right= tmp.left;
                }
                if (p == root) {
                    root = node;
                } else if (prev.left == p) {
                    prev.left = node;
                } else {
                    prev.right = node;
                }
            }
        } else if (root != null) {
            System.out.println("key " + el + " is not in the tree");
        } else {
            System.out.println("Tree is empty");
        }
    }
    public void balance (int data[], int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(data[middle]);
            balance(data, first, middle - 1);
            balance(data, middle + 1, last);
        }
    }
}
