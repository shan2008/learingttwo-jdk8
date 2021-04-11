package com.yous.learningtwo.host.algorithm.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class deadLock {


    public int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length <= 0) {
            return -1;
        }

        if (target == null || target.length() <= 0) {
            return -1;
        }

        Set<String> deads = Stream.of(deadends).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String str = queue.poll();
                if (deads.contains(str)) {
                    continue;
                }
                if (target.equals(str)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(str, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    String down = down(str, j);
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }


        return -1;
    }


    public String up(String target, int i) {
        char[] characters = target.toCharArray();
        if (characters[i] == '9') {
            characters[i] = '0';
        } else {
            characters[i] += 1;
        }

        return new String(characters);
    }


    public String down(String target, int i) {
        char[] characters = target.toCharArray();
        if (characters[i] == '0') {
            characters[i] = '9';
        } else {
            characters[i] -= 1;
        }

        return new String(characters);
    }


}
