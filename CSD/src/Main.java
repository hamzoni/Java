
import LinkList.LinkList;
import LinkList.Person;


public class Main {
  
    public static void main(String[] args) {
        LinkList t = new LinkList();
        String[] a = {"A","B","C","D","E"};
        int[] b = {1, 2, 3, 4, 5};
        
        t.clear();
        t.addLastMany(a,b);  
        t.traverse(); // (A,9) (C,5) (B,17) (E,5) (D,8)
        t.addFirst(new Person("G", 12));
        t.traverse(); // (D,8) (E,5) (B,17) (C,5) (A,9)
    }
    
}
