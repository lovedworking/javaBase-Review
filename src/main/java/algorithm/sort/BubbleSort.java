package algorithm.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array={9,6,4,1,7,3,5,8,2};
        bubbleSort(array);
//        Arrays.stream(array).forEach(System.out::print);
        testPrint();
    }


    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {//i  目前为止跑了几趟    也就是排出来了几个最大值   每次只能排出来一个
            for (int j = 0; j <arr.length-1-i ; j++) {// j内循环  每次从数组第一个元素开始 从头到尾排
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }

    public static void  testPrint(){
        String[] strArr={"我","爱","你","中","国"};
        for (int j = 0; j < strArr.length - 1; j++) {
            for (int i = 0; i <= strArr.length - 1-j; i++) {
                if(strArr[i].equals("爱")){
                    System.out.println("恭喜您中奖了！！！");
                }else if(strArr[i].equals("中")){
                    System.out.println("中国加油");
                }
            }

        }

    }




}
