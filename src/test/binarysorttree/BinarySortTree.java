package test.binarysorttree;

import test.binarysorttree.enums.ErgodicType;

import java.util.ArrayList;
import java.util.List;

public class BinarySortTree {

    /**
     * 二叉树结点
     */
    private static class BiTNode{
        int data;
        BiTNode rChild,lChild;
        public BiTNode(){

        }
        public BiTNode(int data){
            this.data = data;
        }

        @Override
        public String toString() {
            return "BiTNode{" +
                    "data=" + data
                    +"}";
        }
    }

    private BiTNode biTree;
    private int size;

    public BinarySortTree(){
        init();
    }

    public BinarySortTree(int ...data){
        init();
        for (int datum : data) {
            insert(datum);
        }
    }

    /**
     * 初始化
     */
    public void init(){
        biTree = new BiTNode();
        size = 0;
    }

    /**
     * 清空树
     */
    public void empty(){
        init();
        //gc
    }

    /**
     * 插入数据
     * @param data 要插入的数据
     */
    public void insert(int data){
        //若根节点没有值则插入根节点
        //若根节点有值且比根节点的值大则插入根节点的右子树
        //否则插入左子树
        BiTNode p = biTree;
        if (size == 0){
            p.data = data;
            size++;
            return;
        }
        while (true){
            if (data == p.data){
                throw new RuntimeException("插入失败，不能插入相同结点");
            }
            else if (data > p.data){
                if (p.rChild == null){
                    p.rChild = new BiTNode(data);
                    break;
                }
                p = p.rChild;
            }
            else {
                if (p.lChild == null){
                    p.lChild = new BiTNode(data);
                    break;
                }
                p = p.lChild;
            }
        }
        size++;
    }

    /**
     * 获取遍历序列，因为不想自己实现一个动态数组，就使用了java的api
     * @param ergodicType 遍历类型
     * @return 遍历序列
     */
    public List<Integer> ergodic(ErgodicType ergodicType){
        List<Integer> binarySortTreeArray = new ArrayList<>();
        switch (ergodicType){
            case INORDER:
                inorder(binarySortTreeArray, biTree);
                break;
            case PREORDER:
                preorder(binarySortTreeArray, biTree);
                break;
            case POSTORDER:
                postorder(binarySortTreeArray, biTree);
                break;
            default:
                break;
        }
        return binarySortTreeArray;
    }

    /**
     * 判空
     * @return 二叉排序树是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 结点数量
     * @return 二叉排序树结点数量
     */
    public int size(){
        return size;
    }

    /**
     * 查询
     * @param data 查询数据（通常为数据元素的键值）
     * @return 模拟数据,查找成功则返回查找到的结点
     */
    public BiTNode find(int data){
        BiTNode p = biTree;
        while (p != null){
            if (p.data == data){
                break;
            }
            else if (data > p.data){
                p = p.rChild;
            }
            else {
                p = p.lChild;
            }
        }
        return p;
    }

    /**
     * 删除指定键值的结点
     * @param data 键值
     */
    public void remove(int data){
        if (biTree == null){
            return;
        }
        BiTNode p = biTree;
        BiTNode parent = null; //删除结点的双亲结点
        boolean isLeft = false; //标识删除结点是双亲结点的左子树还是右子树
        while (p != null){
            if (p.data == data){
                break;
            }
            else if (data > p.data){
                parent = p;
                isLeft = false;
                p = p.rChild;
            }
            else {
                parent = p;
                isLeft = true;
                p = p.lChild;
            }
        }
        if (p == null){
            return;
        }
        //如果是删除根节点
        if (parent == null){
            //如果根节点是叶节点，直接清空树
            if (isLeaf(p)){
                empty();
                return;
            }
            //如果只有一棵子树，直接让该子树代替根节点
            else if (hasOnlyOneChild(p)){
                biTree = theOnlyChild(biTree);
            }
            //否则将根节点的直接后继代替它并删除直接后继
            else {
                int successor = getDirectSuccessor(biTree);
                remove(successor);
                biTree.data = successor;
            }
        }
        else {
            if (isLeaf(p)){
                //该节点直接删除
                if (isLeft){
                    parent.lChild = null;
                }else {
                    parent.rChild = null;
                }
            }
            else if (hasOnlyOneChild(p)){
                //父结点的孩子结点指向该结点的孩子结点
                if (isLeft){
                    parent.lChild = theOnlyChild(p);
                }else {
                    parent.rChild = theOnlyChild(p);
                }
            }
            else {
                //直接后继代替该节点并且删除直接后继
                int successor = getDirectSuccessor(p);
                remove(successor);
                p.data = successor;
            }
        }
        size--;
    }

    /**
     * 中序遍历
     * @param list 中序遍历序列，用于递归
     * @param p 根节点
     */
    private void inorder(List<Integer> list, BiTNode p){
        if (size > 0 && p != null) {
            inorder(list,p.lChild);
            list.add(p.data);
            inorder(list,p.rChild);
        }
    }

    /**
     * 先序遍历
     * @param list 后序遍历序列，用于递归
     * @param p 根节点
     */
    private void preorder(List<Integer> list, BiTNode p){
        if (size > 0 && p != null) {
            list.add(p.data);
            preorder(list,p.lChild);
            preorder(list,p.rChild);
        }
    }

    /**
     * 后序遍历
     * @param list 后序遍历序列，用于递归
     * @param p 根节点
     */
    private void postorder(List<Integer> list, BiTNode p){
        if (size > 0 && p != null) {
            postorder(list,p.lChild);
            postorder(list,p.rChild);
            list.add(p.data);
        }
    }

    /**
     * 判断是否是叶子节点
     * @param biTNode 结点
     * @return 是否是叶子结点
     */
    private boolean isLeaf(BiTNode biTNode){
        return biTNode != null && biTNode.lChild == null && biTNode.rChild == null;
    }

    /**
     * 判断是否只有一棵子树
     * @param biTNode 结点
     * @return 是否只有一棵子树
     */
    private boolean hasOnlyOneChild(BiTNode biTNode){
        return biTNode !=null && ((biTNode.lChild != null && biTNode.rChild == null) || (biTNode.rChild != null && biTNode.lChild ==null));
    }

    /**
     * 获取结点的唯一一棵子树
     * @return 结点的唯一一棵子树
     */
    private BiTNode theOnlyChild(BiTNode biTNode){
        if (!hasOnlyOneChild(biTNode)){
            throw new RuntimeException("该结点为空，或不止含有一棵子树");
        }
        return biTNode.lChild == null ? biTNode.rChild : biTNode.lChild;
    }

    /**
     * 获取结点的中序遍历的直接后继的键值
     * @param biTNode 结点
     * @return 直接后继
     */
    private int getDirectSuccessor(BiTNode biTNode){
        List<Integer> list = ergodic(ErgodicType.INORDER);
        int index = list.indexOf(biTNode.data);
        if (index == -1){
            throw new RuntimeException("不存在该元素");
        }
        if (index == list.size()){
            throw new RuntimeException("该元素没有直接后继");
        }
        return list.get(index + 1);
    }
}
