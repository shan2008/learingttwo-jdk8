package com.yous.learningtwo.host.algorithm.StringAlg;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author syou
 * @date 2019/12/3.
 */
public class StringTest {

    @Test
    public  void wordBreak() {

        new StringAlg().wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"));

    }
}
