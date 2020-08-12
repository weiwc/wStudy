package com.weiwc.study.wstudy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WstudyApplicationTests {

    @Autowired
    DailyTmperatures dailyTmperatures;
    @Autowired
    EvalRPN evalRPN;

    @Test
    void contextLoads() {
//        int [] in = new int[]{73,74,75,71,69,72,76,73};
//        dailyTmperatures.solution1.dailyTemperatures(in);
        String [] in = new String[]{"4","13","5","/","+"};
        evalRPN.solution.evalRPN(in);
    }
}
