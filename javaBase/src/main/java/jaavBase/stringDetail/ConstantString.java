package jaavBase.stringDetail;

import java.util.ArrayList;
import java.util.List;

public class ConstantString {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        /**
         * Integer（）每次新建一个对象，Integer.valueOf()每次使用缓存池对象 默认缓存 -128 到127
         */

        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x==y);
        Integer m = Integer.valueOf(1);
        Integer n = Integer.valueOf(1);
        System.out.println(m==n);
        Integer a = Integer.valueOf(1111);
        Integer b = Integer.valueOf(1111);
        System.out.println(a==b);


        List<String> strings = new ArrayList<>();


    }


}











