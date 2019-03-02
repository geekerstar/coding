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
//        selectSort(a);
//        insertSort(a);
        insertSort2(a);
        Print(a);
    }

    /**
     * 冒泡排序 时间复杂度O(n^2) 空间复杂度O(1)
     *
     * 算法描述：
     * 1）设待排序序列中的记录的数为 n
     * 2）一般地，第 i 趟起泡排序从1 到 n-i+1
     * 3）依次比较相邻两个记录的关键字，如果发生逆序，则交换之。
     * 4）其结果是这 n-i+1 个记录中，关键字最大的记录被交换到第 n-i+1 的位置上，最多作 n-1 趟。
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
     * 算法描述
     * 1）首先通过n-1次比较，从n个数中找出最小的， 将它与第一个数交换——第一趟选择排序，结果最小的数被安置在第一个元素位置上。
     * 2）再通过n-2次比较，从剩余的n-1个数中找出关键字次小的记录，将它与第二个数交换——第二趟选择排序。
     * 3)重复上述过程，共经过n-1趟排序后，排序结束。
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

    /**
     * 插入排序 稳定
     *
     * 算法描述：
     * 1）数据存放在数组R[0….n-1]中，排序过程的某一中间时刻，R被划分成两个子区间R[0…i-1]和R[i….n-1]，其中：前一个子区间是已排好序的有序区；后一个子区间则是当前未排序的部分。
     * 2）将当前无序区的第1个记录R[i]插入到有序区R[0….i-1]中适当的位置，使R[0…i]变为新的有序区
     * 3）当插入第i(i≥1)个对象时, 前面的r[0], r[1], …, r[i-1]已经排好序。
     *
     * @param a
     */
    private static void insertSort(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int temp = a[i + 1];
            int j = i;
            while (a[j] > temp){
                a[j + 1] = a[j];
                j--;
                if (j < 0){
                    break;
                }
            }
            a[j + 1] = temp;
        }
    }

    /**
     * 二分插入排序（直接插入排序的优化）
     *
     * 算法描述：
     * 在直接插入排序的基础上，利用二分(折半)查找算法决策出当前元素所要插入的位置。
     * 二分查找：
     * 找到中间元素，如果中间元素比当前元素大，则当前元素要插入到中间元素的左侧；否则，中间元素比当前元素小，则当前元素要插入到中间元素的右侧。
     * 找到当前元素的插入位置 i 之后，把 i 和 high 之间的元素从后往前依次后移一个位置，然后再把当前元素放入位置 i。
     *
     * @param a
     */
    private static void insertSort2(int[] a){
        for(int i = 0; i < a.length - 1; i++){
            int temp = a[i + 1];
            int low = 0;
            int high = i;
            int mid;
            while (low <= high){
                mid = (low + high)/2;
                if (a[mid] > temp){
                    high = mid -1;
                } else {
                    low = mid +1;
                }
            }
            for (int j = i; j >= high + 1; j--){
                a[j + 1] = a[j];
            }
            a[high + 1] = temp;
        }
    }
}
