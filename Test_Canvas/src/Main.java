
import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        C c = new C(123, "asd");
    }
    
    public void createCanvas() {
        B b = new B();
        B2 b2 = new B2();
        b2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        A a = new A();
        A2 a2 = new A2();
        b2.getView().setViewportView(a2);
        b2.setSize(400, 400);
        b2.setVisible(true);
    }
}

