
package Config;

public class RoleConfig {
    // All rights
    public static final int ADMIN = 0;
    // CRUD all Authors'post , CRUD all category
    public static final int MOD = 1;
    // Only CRUD for Owner's posts
    public static final int AUTHOR = 2;

    public int[] roles = {ADMIN, MOD, AUTHOR};
    
    public int findRole(int role) {
        for (int i = 0; i < roles.length; i++) {
            if (roles[i] == role) return role;
        }
        return -1;
    }
    
}
