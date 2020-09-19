package jaavBase.clonable;

/**
 * 浅拷贝，拷贝对象和原始对象的引用类型引用同一个对象    对象里面的引用类型是相同的
 */
public class ShallowCloneExample  implements  Cloneable{
    private int[] arr;
    public ShallowCloneExample(){
        arr=new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }
    }
    public void set(int index,int value){
        arr[index]=value;
    }
    public int get(int index){
        return arr[index];
    }
    @Override
    protected ShallowCloneExample clone() throws CloneNotSupportedException {
        return (ShallowCloneExample) super.clone();
    }

    public static void main(String[] args) {
        ShallowCloneExample e1 = new ShallowCloneExample();
        ShallowCloneExample e2 = null;
        try {
            e2=e1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        e1.set(2, 666);
        System.out.println(e2.get(2));
    }
}
















