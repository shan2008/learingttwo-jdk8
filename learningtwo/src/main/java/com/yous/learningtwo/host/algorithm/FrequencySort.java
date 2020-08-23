package com.yous.learningtwo.host.algorithm;

import java.util.*;
import java.util.stream.Collectors;

public class FrequencySort {

    public String frequencySort(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(s.charAt(i));
            } else {
                List<Character> list = new ArrayList<>();
                list.add(s.charAt(i));
                map.put(s.charAt(i), list);
            }
        }

        return map.entrySet().stream().sorted(Map.Entry.comparingByValue((l1, l2) -> {
            if (l1.size() > l2.size()) {
                return -1;
            } else if (l1.size() < l2.size()) {
                return 1;
            } else {
                return 0;
            }
        })).map(o -> o.getValue().stream().map(String::valueOf).collect(Collectors.joining()))
                .reduce((s1, s2) -> s1.concat(s2)).get();

    }

    private  class ValueCompare implements Comparator<List<Character>>{
        private Map<String,List<Character>> map;
        public ValueCompare(Map<String,List<Character>> map){
            this.map=map;
        }
        @Override
        public int compare(List<Character> o1, List<Character> o2) {
            if (o1.size() > o2.size()) {
                return -1;
            } else if (o1.size() < o2.size()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
