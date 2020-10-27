package com.wzp.study.sentinel.sentinelNoweb;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelNoWeb {
    public static void main(String[] args) {
        sentinelTest01();

    }

    private static void sentinelTest01() {
        initFlowRules();
        int i = 0;
        while (true) {
            Entry entry = null;
            try {
                entry = SphU.entry("HelloWorld");
                System.out.println("hello world");
            } catch (BlockException e) {
                System.out.println("block");
            } finally {
                if (entry != null) {
                    entry.exit();
                }
            }
            i++;

        }
    }

    private static void sentinelTest02() {
        initFlowRules();
        int i = 0;
        while (true) {
            try (Entry entry = SphU.entry("HelloWorld");) {
                System.out.println("hello world");
            } catch (BlockException e) {
                System.out.println("block");
            }
            i++;
        }
    }

//    @SentinelResource
//    public void sentinelTest03() {
//        System.out.println("hello world");
//    }


    private static void sentinelTest03() {
        initFlowRules();
//        try {
//            AsyncEntry entry = SphU.asyncEntry("HelloWorld");
//
//            // 异步调用.
//            doAsync(userId, result -> {
//                try {
//                    // 在此处处理异步调用的结果.
//                } finally {
//                    // 在回调结束后 exit.
//                    entry.exit();
//                }
//            });
//        } catch (BlockException ex) {
//            // Request blocked.
//            // Handle the exception (e.g. retry or fallback).
//        }
    }

    private static void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
