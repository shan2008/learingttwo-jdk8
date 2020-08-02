package com.yous.learningtwo.host.algorithm;

import java.util.*;

public class WeightRandom {

    private Map<String, Integer> serverMap = new HashMap<String, Integer>() {{
        put("192.168.1.100", 1);
        put("192.168.1.101", 1);
        put("192.168.1.102", 4);
        put("192.168.1.103", 1);
        put("192.168.1.104", 1);
        put("192.168.1.105", 3);
        put("192.168.1.106", 1);
        put("192.168.1.107", 2);
        put("192.168.1.108", 1);
        put("192.168.1.109", 1);
        put("192.168.1.110", 1);
    }};

    private List<String> servers = new ArrayList<>(serverMap.keySet());

    public void weightRandom() {
        Set<String> keySet = serverMap.keySet();
        List<String> servers = new ArrayList<String>();
        for (Iterator<String> it = keySet.iterator(); it.hasNext(); ) {
            String server = it.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++) {
                servers.add(server);
            }
        }
        String server = null;
        Random random = new Random();
        int idx = random.nextInt(servers.size());
        server = servers.get(idx);
        System.out.println(server);
    }

}
