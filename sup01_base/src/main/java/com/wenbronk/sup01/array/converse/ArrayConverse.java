package com.wenbronk.sup01.array.converse;

/**
 * 数组元素反转， 其实就是对称位置的元素交换
 * 1. 什么时候停止交换
 * min < max 的时候
 */
public class ArrayConverse {

    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50, 60};

        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
        }

    }

}
