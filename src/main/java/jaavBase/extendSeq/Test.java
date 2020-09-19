package jaavBase.extendSeq;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        D d = new D();
        // A中存在show(A)直接调用
        a.show(a);  //A.show(A)
        //A 中不存在show(B) 将B转型成其父类 A
        a.show(b);  //A.show(A)
        //在B中存在从A继承来的show(C) 直接调用
        b.show(c); // A.show(C)
        //在B中不存在show(D) 但是存在从A继承来的show(C) 将D转型成其父类C
        b.show(d); // A.show(C)



        //引用的还是B对象，所以ba和b调用效果一样
        A ba=new B();
        ba.show(a);
        ba.show(b);
        ba.show(c);
        ba.show(d);




    }
}


























