package stringsProgram;

import java.util.*;

public class StringOccurenceInList {
    private static Map<String, Integer> countFrequencies(List<String> list) {
        // Hashmap to store the frequency of element
        Map<String, Integer> hm = new HashMap<>();
        for (String i : list) {
            Integer j = hm.get(i);
            hm.put(i, (j == null) ? 1 : j + 1);
        }
        List<Map.Entry<String, Integer> > entryList =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Collections.reverse(entryList);

        // Put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : entryList) {
            temp.put(aa.getKey(), aa.getValue());
        }
        // Displaying the occurrence of elements in the arraylist
        for (Map.Entry<String, Integer> val : temp.entrySet()) {
            System.out.println("Element " + val.getKey() + " "
                    + "occurs"
                    + ": " + val.getValue() + " times");
        }
        return temp;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Umesh");
        list.add("Umesh");
        list.add("Umesh");
        list.add("Mridul");
        list.add("Mridul");
        list.add("Chawla");
        list.add("Chawla");
        list.add("Chawla");
        list.add("Chawla");
        list.add("Chawla");
        list.add("Kumar");
        list.add("Kumar");
        list.add("Kumar");
        list.add("Kumar");
        Map<String, Integer> hm = countFrequencies(list);
    }

}
