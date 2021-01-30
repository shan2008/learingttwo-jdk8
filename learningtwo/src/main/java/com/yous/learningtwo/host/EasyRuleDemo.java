package com.yous.learningtwo.host;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.mvel.MVELRule;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class EasyRuleDemo {

    @Test
    public void test() {
        // define facts
        Facts facts = new Facts();
        facts.put("number1", 1);
        facts.put("number2", 2);
        facts.put("number3", 9);
        Map<String, Boolean> map = new HashMap<>();
        map.put("result",false);
        facts.put("map", map);

        String condition="number1==5|| number2*2==8 || number3/3==3";

        // define rules
        Rule weatherRule = new MVELRule()
                .name("weather rule")
                .description("if it rains then take an umbrella")
                .when(condition)
                .then("map.put(\"result\",true)");


        Rules rules = new Rules();
        rules.register(weatherRule);

        // fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        rulesEngine.fire(rules, facts);

        Map<String, Boolean> result = facts.get("map");

        System.out.println(result.get("result"));
    }
}
