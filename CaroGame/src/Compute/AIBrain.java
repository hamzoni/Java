
package Compute;

public class AIBrain {
    class EVALDEF {
        public final static int MAKE_WIN_SF = -20;
        public final static int BLOCK_WIN_OP = -19;
        public final static int BLOCK_TRAP_OP = -18;
        public final static int MAKE_TRAP_SF = -17;
    }
    public static final int[] EVAL_LIST = {
        EVALDEF.MAKE_WIN_SF,
        EVALDEF.BLOCK_WIN_OP,
        EVALDEF.BLOCK_TRAP_OP,
        EVALDEF.MAKE_TRAP_SF
    };
}
