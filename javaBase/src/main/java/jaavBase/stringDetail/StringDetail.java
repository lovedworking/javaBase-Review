package jaavBase.stringDetail;

/**
 * oracle https://docs.oracle.com/javase/specs/jls/se14/html/index.html
 * String被声明为final 因此不可被继承
 * 使用char数组存储数据
 * java 9使用byte数组存储字符串，同时使用coder标识哪种编码
 * value数组被声明为final,意味着value数组初始化之后就不能再引用其他数组。并且string内部没有改变value数组的方法，
 * 因此可以保证String不可变
 *   不可变的好处
 *   1 可以缓存hash值 因此string常用作hashmap的key,不可变特性使hash值不可变，因此只需要进行一次计算
 *   2 String pool 的需要  如果一个String 对象已经被创建过了，那么就会从String pool 中取得引用，只有string不可变的，才可能使用string pool
 *   3 安全性 String 经常作为参数，String不可变性可以保证参数不可变，
 *   4 线程安全   String不可变性天生具备线程安全，可以在多个线程安全使用
 *
 *   String不可变 StringBuffer和StringBuilder可变
 *   String不可变 线程安全
 *   StringBuilder 不是线程安全
 *   StringBuffer线程安全， 内部使用Synchronized进行同步
 *
 *
 *   String pool
 *      java 7之前，String pool被放在运行时常量池 属于永久代
 *      java 7 String pool 被移到堆中 因为永久代空间有限，大量使用字符串场景容易导致oom
 *
 *
 */
public class StringDetail {
    public static void main(String[] args) {
        //test1();
        test2();
    }
    public static void test1() {
        // false 创建两个对象
        String a = new String("abc");
        String b = new String("abc");
        System.err.println(a==b);

        //true 通过string pool 返回引用
        String c = a.intern();
        String d = a.intern();
        System.err.println(c==d);

        //true 如果字面量的形式创建字符串，会自动将字符串放入String pool中
        String x="abc";
        String y="abc";
        System.err.println(x==y);

    }

    public static void test2(){
        String s=new String("abc");
    }
}


















