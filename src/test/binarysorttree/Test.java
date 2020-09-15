package test.binarysorttree;

public class Test {
    public static void main(String[] args) {
        A a = new A("李四");
        Test test = new Test();
        test.test(a);
        System.out.println(a.name);
    }

    private void test(A a){
        a.name = "张三";
    }
}
class A{
    String name;
    public A(String name){
        this.name = name;
    }
}