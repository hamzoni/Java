
package Utility;

import java.util.ArrayList;

public class Pagination {
    
    private String next;
    private String current;
    private String prev;
    private String first;
    private String last;
    private ArrayList<String> gaps;
    private int[] gapsIndex;
    
    private int currentIndex;
    private int totalIndex;
    private int gapIndex;
   
    public Pagination(String baseUrl, int crr, int total, int gap) {
        
        this.currentIndex = crr;
        this.totalIndex = total;
        this.gapIndex = gap;
        
        if (total <= 0) return;
        
        current = baseUrl + "=" + crr;
        
        if (crr < total) 
            next = baseUrl + "=" + (crr + 1);

        if (crr - 1 > 0)
            prev = baseUrl + "=" + (crr - 1);
        
        if (crr != 1)
            first = baseUrl + "=" + 1;
        
        if (crr != total)
            last = baseUrl + "=" + total;
        
        int j = 0;
        gaps = new ArrayList<String>();
        gapsIndex = new int[gap * 2 + 1];
        for (int i = -gap; i <= gap; i++) {
            if ((crr + i) > total || (crr + i) <= 0) continue;
            
            gapsIndex[j++] = crr + i;
            String url = baseUrl + "=" + (crr + i);
            gaps.add(url);
        }
    }

    public String getNext() {
        return next;
    }

    public String getCurrent() {
        return current;
    }

    public String getPrev() {
        return prev;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public ArrayList<String> getGaps() {
        return gaps;
    }

    public int[] getGapsIndex() {
        return gapsIndex;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getTotalIndex() {
        return totalIndex;
    }

    public int getGapIndex() {
        return gapIndex;
    }
    
}
