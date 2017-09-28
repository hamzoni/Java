
public class BSTree {

    Node root;

    BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    Node search(Node p, int x) {
        if (p == null) {
            return null;
        }
        if (p.info == x) {
            return p;
        }
        if (x < p.info) {
            return search(p.left, x);
        } else {
            return search(p.right, x);
        }
    }

    Node insert(Node p, int x) {
        if (p == null) {
            return new Node(x);
        }
        if (p.info == x) {
            System.out.println("Already exist");
            return p;
        }
        if (x < p.info) {
            p.left = insert(p.left, x);
        } else {
            p.right = insert(p.right, x);
        }
        return p;
    }

    void insertV2(Node p, int x) {
        if (root == null) {
            root = new Node(x);
            return;
        }
        while (p != null) {
            if (p.info == x) {
                System.out.println("Already exist");
                return;
            }
            if (x < p.info) {
                if (p.left == null) {
                    p.left = new Node(x);
                    break;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = new Node(x);
                    break;
                }
                p = p.right;
            }

        }
    }

    void insert(int x) {
        root = insert(root, x);
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insertV2(root, a[i]);
        }
    }

    void visit(Node p) {
        if (p != null) {
            System.out.print(p.info + " ");
        }
    }

    void breadth(Node p) {
        if (p == null) {
            return;
        }
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) {
                q.enqueue(r.left);
            }
            if (r.right != null) {
                q.enqueue(r.right);
            }
        }
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void deleByCopy(int x) {
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                break;
            }
            f = p;
            p = x < p.info ? p.left : p.right;
        }
        if (p == null) return; // not found
        
        // p is a leaf node
        if (p.left == null && p.right == null) {
            if (f == null) { // p is the root
                root = null;
            } else {
                if (p == f.left) {
                    f.left = null;
                } else {
                    f.right = null;
                }
            }
            return;
        }
        
        // p has left son only
        if (p.left != null && p.right == null) {
            if (f == null) {
                root = p.left;
            } else {
                if (p == f.left) {
                    f.left = p.left;
                } else {
                    f.right = p.left;
                }
            }
            return;
        }
        
        // p has right son only
        if (p.left == null && p.right != null) {
            if (f == null) {
                root = p.right;
            } else {
                if (p == f.left) {
                    f.left = p.right;
                } else {
                    f.right = p.right;
                }
            }
            return;
        }
        
        // p has both 2 sons
        if (p.left != null && p.right != null) {
            // find the right-most node on the left sub-tree
            Node q = p.left;
            Node frp, rp;
            frp = null;
            rp = q;
            while (rp.right != null) {
                frp = rp;
                rp = rp.right;
            }
            // rp is the right-most node
            p.info = rp.info;
            // delete rp
            if (frp == null) { // q = rp
                p.left = q.left;
                return;
            } else {
                frp.right = rp.left;
            }
        }
        
    }
    public void deleteByCopy() {
    
    }
}