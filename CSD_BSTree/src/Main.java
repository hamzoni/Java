
public class Main {

    public static void main(String[] args) {

        int a[] = {8,6,9,4,7,2,5,1,3};
        BSTree t = new BSTree();
        t.insertMany(a);
        
        System.out.println("1. Test breadth-first tranversal: ");
        t.breadth(t.root);
        System.out.println();
        
        System.out.println("2. Test pre-order tranversal: ");
        t.preOrder(t.root);
        System.out.println();
        
        System.out.println("3. Test in-order tranversal: ");
        t.inOrder(t.root);
        System.out.println();
        
        System.out.println("3. Test post-order tranversal: ");
        t.postOrder(t.root);
        System.out.println();
        
    }
    
}
