package com.yous.learningtwo.host.algorithm.tree;

import org.junit.Test;

import java.util.Arrays;

public class VerifyPostorder {

    @Test
    public void test() {
        int[] arr = {1, 6, 3, 2, 5};
        System.out.println(verifyPostorder(arr));

        int[] array = {1, 3, 2, 6, 5};
        System.out.println(verifyPostorder(array));

    }

    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null || postorder.length <= 0) {
            return false;
        }

        int root = postorder[postorder.length - 1];
        // 左子树都是比根小
        int i;
        for (i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] > root) {
                break;
            }
        }

        for (int j = i; j < postorder.length - 1; j++) {
            if (postorder[j] < root) {
                return false;
            }
        }

        boolean left =true;
        if (i > 0) {
            left = verifyPostorder(Arrays.copyOf(postorder, i));
        }
        boolean right = true;
        if (i < postorder.length - 1) {
            right = verifyPostorder(Arrays.copyOfRange(postorder, i, postorder.length - 1));
        }

        return left && right;
    }

}
