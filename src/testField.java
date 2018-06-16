import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class testField {
    public static void main (String[] args) {
        arraySortChar();
    }
    
    
    public static void arraySortChar () {
        //String[] array = new String[]{"aAa", "AaA", "aaa", "AAA"};
        List<String> list = new ArrayList<String>();
        list.add("AAA");
        list.add("aaa");
        list.add("aAa");
        list.add("AAA");
        list.add("bbb");
        list.add("BBB");
        
        Collections.sort(list);
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        float f = 0;
        System.out.println(f);
    }
}
