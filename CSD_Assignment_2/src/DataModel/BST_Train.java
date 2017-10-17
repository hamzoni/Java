package DataModel;

import DataStructure.BST_Node;
import DataStructure.BSTree;
import DataStructure.Queue;
import Entities.Train;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

public class BST_Train extends BSTree<Train> {

    public String datafmt(BST_Node p) {
        Train t = (Train) p.value;
        return t.tcode + " | " + t.train_name + " | " + t.seat + " | "
                + t.booked + " | " + t.depart_time + " | " + t.depart_place;
    }

    public void savePreorder(String fn) throws IOException {
        BST_Node p = root;
        Stack s = new Stack();

        FileWriter fw = new FileWriter(fn, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        if (p != null) {
            s.push(p);
            while (!s.isEmpty()) {
                p = (BST_Node) s.pop();
                // append to file
                out.println(datafmt(p));
                if (p.left != null) {
                    s.push(p.left);
                }
                if (p.right != null) {
                    s.push(p.right);
                }
            }
        }
        out.close();
        bw.close();
        fw.close();
    }

    public void saveInorder(String fn) throws IOException {
        FileWriter fw = new FileWriter(fn, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);

        BST_Node p = root;
        Stack s = new Stack();
        while (p != null) {
            while (p != null) {
                if (p.right != null)
                    s.push(p.right);
                s.push(p);
                p = p.left;
            }
            p = (BST_Node) s.pop();
            while (!s.isEmpty() && p.right == null) {
                out.println(datafmt(p));
                p = (BST_Node) s.pop();
            }
            out.println(datafmt(p));
            p = !s.isEmpty() ? (BST_Node) s.pop() : null;
        }

        out.close();
        bw.close();
        fw.close();
    }

    public Train search(String tcode) {
        BST_Node p = root;
        Train t = (Train) p.value;
        while (p != null && !t.tcode.equals(tcode)) {
            t = (Train) p.value;
            if (t.tcode.compareTo(tcode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (t.tcode.equals(tcode)) {
            return t;
        }
        return null;
    }

    public boolean isExist(String tcode) {
        BST_Node p = root;

        if (p == null) {
            return false;
        }

        Train t = (Train) p.value;
        while (p != null && !t.tcode.equals(tcode)) {
            t = (Train) p.value;
            if (t.tcode.compareTo(tcode) > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return t.tcode.equals(tcode);
    }

    @Override
    public void insert(BST_Node n) {
        BST_Node p = root, pn = null;

        Train pv, nv = (Train) n.value;
        while (p != null) {
            pn = p;
            pv = (Train) p.value;

            if (nv.tcode.compareTo(pv.tcode) > 0) {
                // pv.tcode > nv.tcode
                p = p.right;
            } else {
                // pv.tcode < nv.tcode
                p = p.left;
            }
        }

        if (root == null) {
            root = n;
        } else {
            Train pnv = (Train) pn.value;
            if (nv.tcode.compareTo(pnv.tcode) > 0) {
                pn.right = n;
            } else {
                pn.left = n;
            }
        }
    }

    @Override
    public void delcopy(Object v) {
        String tcode = (String) v;

        BST_Node n, p = root, prev = null;
        // Find node n = p with value = v
        while (p != null && !((Train) p.value).tcode.equals(tcode)) {
            prev = p;
            p = (((Train) p.value).tcode.compareTo(tcode) < 0)
                    ? p.right
                    : p.left;
        }

        Train t = (Train) p.value;
        // n should be the copied version of p
        n = p;
        if (p != null && t.tcode.equals(tcode)) {
            if (n.right == null) {
                n = n.left;
            } else if (n.left == null) {
                n = n.right;
            } else {
                // Find rightmost node of the left subtree of n.left
                BST_Node tmp = n.left;
                BST_Node previous = n;
                while (tmp.right != null) {
                    previous = tmp;
                    tmp = tmp.right;
                }
                // Replace node to be delete , n.value with rightmost node value
                n.value = tmp.value;
                // Remove rightmost node. In fact, attach left node to its previous node
                if (previous == n) {
                    previous.left = tmp.left;
                } else {
                    previous.right = tmp.left;
                }
            }
            // Update new node to current node position (from previous node of deleted node perspective)
            if (p == root) {
                root = n;
            } else if (prev.left == p) {
                prev.left = n;
            } else {
                prev.right = n;
            }

        } else if (root != null) {
            System.out.println("key " + tcode + " is not in the tree");
        } else {
            System.out.println("the tree is empty");
        }
    }

    @Override
    public void delmerge(Object v) {
        BST_Node tmp, node, p = root, prev = null;
        String tcode = (String) v;

        // Find node p that has tcode v
        Train pv = (Train) p.value;
        while (p != null && !pv.tcode.equals(tcode)) {
            prev = p;
            pv = (Train) p.value;

            if (tcode.compareTo(pv.tcode) > 0) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        node = p;

        if (p != null && pv.tcode.equals(tcode)) {
            // node has no right child: its left child to be attached to its parent
            if (node.right == null) {
                node = node.left;
            } // node has no left child: its right child is attached to its parent
            else if (node.left == null) {
                node = node.right;
            } // node has both left and right childs: ready for merging subtress
            else {
                // 1. move left
                tmp = node.left;
                // 2. move right as far as possible
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                // 3. establish the link between rightmost node of the left subtree to the right subtree
                tmp.right = node.right;
                // 4.
                node = node.left;
            }
            if (p == root) {
                root = node;
            } else if (prev.left == p) {
                prev.left = node;
            } // 5.
            else {
                prev.right = node;
            }
        } else if (root != null) {
            System.out.println("CCode: " + tcode + " is not existed.");
        } else {
            System.out.println("Tree is empty");
        }
    }

    public void balancing() {
        BST_Node nodes[] = inorderIterate();
        Train trains[] = new Train[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            trains[i] = (Train) nodes[i].value;
        }

        root = null;
        balancing(trains, 0, trains.length - 1);
    }

    @Override
    public void balancing(Train[] data, int first, int last) {
        if (first <= last) {
            int middle = (first + last) / 2;
            insert(new BST_Node(data[middle]));
            balancing(data, first, middle - 1);
            balancing(data, middle + 1, last);
        }
    }

}
