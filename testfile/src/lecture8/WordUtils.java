package lecture8;

import lecture4.SLList;
import lecture5.AList;

import java.util.List;

public class WordUtils {
    /** Return the length of the longest word. */
    public static String longest(List61B<String> list){
        int maxDex = 0;
        for (int i = 0; i < list.size(); i++){
            String longestString = list.get(maxDex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public static void main(String[] args){
        List61B<String> x = new SLList<>();
        x.addFirst("Rad");
        x.addFirst("Cute");
        x.addLast("is");
        x.addLast("writing");
        x.insert("a",4);
        x.insert("program",5);
        x.print();
    }
}
