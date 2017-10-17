
import java.awt.Color;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main {
    public static void main(String[] args) {
        new Main().run();
    }
    
    private void run() {
        ButtonFrame frame = new ButtonFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public int f(int a, int n) {
        if (n == 0 ) return 1;
        int t = f(a, n/2);
        if (n % 2 == 0) return t * t;
        else return t * t* a;
    }
    
    class ButtonFrame extends JFrame {
        public ButtonFrame() {
            setTitle("buttonTest");
            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            panel = new JPanel();
            add(panel);
            
            yellowButton = new JButton("Yellow");
            blueButton = new JButton("Blue");
            redButton  = new JButton("Red");
            
            panel.add(yellowButton);
            panel.add(blueButton);
            panel.add(redButton);
            ActionListenerInstaller.processAnnotations(this);
        }
        
        @ActionListenerFor(source="yellowButton")
        public void yellowBackground() {
            panel.setBackground(Color.YELLOW);
        }
        
        @ActionListenerFor(source="blueButton")
        public void blueBackground() {
            panel.setBackground(Color.BLUE);
        }
        
        @ActionListenerFor(source="redButton")
        public void redBackground() {
            panel.setBackground(Color.RED);
        }
        
        public static final int DEFAULT_WIDTH = 300;
        public static final int DEFAULT_HEIGHT = 200;
        
        private JPanel panel;
        private JButton yellowButton;
        private JButton blueButton;
        private JButton redButton;
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

