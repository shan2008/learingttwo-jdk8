package com.yous.learningtwo.host.algorithm.StringAlg;

import com.yous.learningtwo.host.algorithm.LinkedNode.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author syou
 * @date 2019/12/3.
 */
public class StringTest {

    @Test
    public  void wordBreak() {
        String a="hh hsa";

        a.replaceAll(" ","%20");


        new StringAlg().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));

    }



}
