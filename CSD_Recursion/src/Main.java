
public class Main {

    public static void main(String[] args) {
        new Main().init();
    }
    
    private void init() {
        int[] arr = {3, 5, 1, 2, -4, 7, 6, 1, 9};
        int[] arr2 = {0, 1, 2, 3, 4, 5, 6, 9, 15};
        char[] chars = {'a', 'b', 'b', 'a'};
        
    }
    
    private int stirling(int n, int m) {
        if (n == 0 && m == 0) return 1;
        if (n > 0 && m == 0) return 0;
        return stirling(n, m - 1) - n * stirling(n, m);
    }
    
    private float addReciprocals(float n) {
        if (n == 1) return 1;
        return 1 / n + addReciprocals(n - 1);
    }
    
    private int fibo(int n) {
        if (n <= 2) return 1;
        return fibo(n - 1) + fibo(n - 2);
    }
    
    private int fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }
    
    private int power(int x, int n) {
        if (n == 0) return 1;
        return x * power(x, n - 1);
    }
    
    private int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }
    
    private int findBinTarget(int a[], int p, int q, int x) {
        int m = (p + q) / 2;
        if (m == p || m == q) return - 1;
        if (x > a[m]) return findBinTarget(a, m, q, x);
        if (x < a[m]) return findBinTarget(a, p, m, x);
        return m;
    }
    
    private boolean ispalindrome(char a[], int n) {
        if (n / 2 == 0) return a[a.length - 1 - n] == a[n];
        return ispalindrome(a, n - 1) && ispalindrome(a, n - 2);
    }
    
    private int findSum(int[] a, int n) {
        if (n <= 0) return 0;
        return a[n - 1] + findSum(a, n - 1);
    }
    
    private int findMin(int[] a, int n) {
        if (n == 0) return n;
        int min = a.length - n;
        int next = findMin(a, n - 1);
        if (a[next] < a[min]) min = next;
        return min;
    }
    
    private int sum(int n) {
        if (n == 1) return n;
        return n + sum(n - 1);
    }
    
}
