package pattern.composite;

/**
 * Created by jinpanpan on 2018/1/9.
 */
public class Main {

    public static void main(String[] args) {
        // 构造根节点
        Composite rootComposite = new Composite();
        rootComposite.setName("根节点");

        // 左节点
        Composite compositeLeft = new Composite();
        compositeLeft.setName("左节点");

        // 构建右节点，添加两个叶子几点，也就是子部件
        Composite compositeRight = new Composite();
        compositeRight.setName("右节点");


        Leaf leaf = new Leaf();
        leaf.setName("右-子节点1");

        Leaf leaf2 = new Leaf();

        leaf2.setName("右-子节点2");
        compositeRight.add(leaf);
        compositeRight.add(leaf2);

        // 左右节点加入 根节点
        rootComposite.add(compositeRight);
        rootComposite.add(compositeLeft);
        // 遍历组合部件
        rootComposite.eachChild();
    }
}
