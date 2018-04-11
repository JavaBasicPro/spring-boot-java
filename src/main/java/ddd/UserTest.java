package ddd;

import lombok.experimental.var;

import java.util.List;

/**
 * Created by jinpanpan on 2018/2/10.
 */
public class UserTest {
}


/***
 * DDD错误的用法：
 * 命名是User的仓库，其实做了非User的事情
 */
interface IUserRepository{
    List<String> GetRules(int id);
}

/*
* 体现了User作为一个【领域模型】拥有自己的职责和能力
* 做到了高内聚
* **/
class User{
    private List<String> GetRules(){
        return null;
    }

    public void ApproveRequest(int request){
        User user=new User();
        List<String> rules = user.GetRules();
        //......
        //如果有权限就批准
    }
}