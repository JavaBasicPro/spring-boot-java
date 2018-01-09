package pattern.composite;

/**
 * Created by jinpanpan on 2018/1/9.
 * 组合部件类,对应 部分类
 */
public class Leaf extends Component {


    //叶子节点不具备添加的能力，所以不实现
    @Override
    public void add(Component c) {

    }

    //叶子节点不具备添加的能力，所以不实现
    @Override
    public void remove(Component c) {

    }

    //叶子节点没有子节点所以显示自己的执行结果
    @Override
    public void eachChild() {

        System.out.println(getName()+"执行了");
    }
}
