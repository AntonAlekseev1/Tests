import java.util.*;
 
class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;
    
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
    
    public int compare(String a, String b) {
        return ( base.get(a) >= base.get(b) ) ? -1 : 1;
    }
}
 
