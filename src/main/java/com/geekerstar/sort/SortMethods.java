package com.geekerstar.sort;

/**
 * @author geekerstar
 * date: 2019/3/2 11:06
 * description:
 */
public class SortMethods {

    public static void main(String[] args) {
        int a[] = {8,3,2,5,9,3,6};
        Print(a);
        //bubbleSort2(a);
        selectSort(a);
        Print(a);
    }

    /**
     * 冒泡排序 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * @param a
     */
    private static void bubbleSort(int[] a){
        for(int i = 0; i < a.length-1; i++){
            for(int j = 0; j< a.length - i - 1; j++){
                if (a[j] > a[i]){
                    swap(a,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] a,int i,int j){
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void Print(int[] a){
        for(int num : a ){
            System.out.print(num + "\t");

        }
        System.out.println();

    }


    /**
     * 优化后的冒泡排序
     *
     * @param a
     */
    private static void bubbleSort2(int[] a){
        for(int i =0;i < a.length -1; i++){
            boolean flag = true;
            for(int j = 0; j < a.length - i -1; j++){
                if(a[j] > a[j+1]){
                    swap(a,j,j+1);
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    /**
     * 选择排序 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * @param a
     */
    private static void selectSort(int[] a){
        for(int i = 0; i <a.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[k]) {
                    k = j;
                }
            }
            if (k != i) {
                swap(a, i, k);
            }
        }
    }
}
