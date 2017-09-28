
package Config;

public class FeaturesConfig {
    public static class Account {
        public static final int READ = 1;
        public static final int WRITE = 2;
        public static final int UPDATE = 3;
        public static final int DELETE = 4;
        public static final int[] ACCF = {READ, WRITE, UPDATE, DELETE};
    }
}
