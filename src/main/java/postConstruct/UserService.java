package postConstruct;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jinpanpan on 2017/12/11.
 */
@Service
public class UserService {

    public List<String> getUser(){
        List<String> list=new ArrayList<>();

        list.add("张三");
        list.add("里斯");
        return list;
    }
}
