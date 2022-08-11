package org.example;

import java.util.*;

public class Guiz {

    Map<Map<String, List<String>>, Integer> vic =new HashMap<>();
   // Dictionary<String, List<String>> questions= new Hashtable<>();
    int number;

    public Guiz(){
        List<String> options1 = new ArrayList<>();
        options1.add("11\n");
        options1.add("12\n");
        options1.add("13\n");
        List<String> options2 = new ArrayList<>();
        options2.add("21\n");
        options2.add("22\n");
        options2.add("23\n");
        List<String> options3 = new ArrayList<>();
        options3.add("31\n");
        options3.add("32\n");
        options3.add("33\n");
        Map<String, List<String>> questions1= new HashMap<>();
        questions1.put("questions1\n", options1);
        Map<String, List<String>> questions2= new HashMap<>();
        questions2.put("questions2\n", options2);
        Map<String, List<String>> questions3= new HashMap<>();
        questions3.put("questions3\n", options3);

        vic.put(questions1, 1);
        vic.put(questions2, 2);
        vic.put(questions3, 3);

        number = vic.size();
    }

}
