package test.binarysorttree;

import test.binarysorttree.enums.ErgodicType;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySortTreeTest {

    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<>();
//        map.put("123","123");
//        String s = map.get("123");
        new BinarySortTreeTest().test01();
//        binarySortTree.remove(1);
//        binarySortTree.ergodic(ErgodicType.INORDER).forEach(System.out::println);
//        System.out.println("长度："+binarySortTree.size());
    }

    private void test01(){
        BinarySortTree binarySortTree = new BinarySortTree(10,7,15,22,9,6,32,57,89,13);
        System.out.println("hashcode："+binarySortTree.hashCode());
        binarySortTree.ergodic(ErgodicType.INORDER).forEach(System.out::println);
        System.out.println("是否为空："+binarySortTree.isEmpty());
        System.out.println("长度："+binarySortTree.size());
        Scanner scanner = new Scanner(System.in);
        int i;
        while (true){
            i = scanner.nextInt();
            if (i == -1){
                break;
            }
            long startTime = System.nanoTime();
            System.out.println("索引"+i+"的数据为："+binarySortTree.find(i));
            System.out.println("运行时间："+(System.nanoTime() - startTime)+"纳秒");
        }
    }

    private void test02(){
        BinarySortTree binarySortTree = new BinarySortTree();
        binarySortTree.insert(1);
        binarySortTree.insert(2);
        binarySortTree.ergodic(ErgodicType.POSTORDER).forEach(System.out::println);
    }
}
