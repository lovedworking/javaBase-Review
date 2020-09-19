package jaavBase.stringDetail.typeTrans;

public class TestTrans {
    public static void main(String[] args) {
        //float f=1.1;  //double类型 不能赋值给float变量 ，因为是向下转型
        float f=1.1f;
        short s1=1;
        //s1=s1+1;  //1 是int类型，它比short类型精度要高，因为不能隐式转换为short类型
        s1+=1;  //使用+=或者++运算可以执行隐式类型转换



    }
}

















