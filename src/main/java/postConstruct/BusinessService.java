package postConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by jinpanpan on 2017/12/11.
 */
@Service
public class BusinessService {

    @Autowired
    private UserService userService;

    private List<String> list=null;


    public BusinessService(List<String> list) {
       System.out.println("构造方法被调用");
    }

    /*
    * 该注释会在 构造方法之后，init方法之前调用
    * */
    @PostConstruct
    public void init(){

        System.out.println("@PostConstruct方法被调用");

        List<String> list=userService.getUser();

        this.list=list;

        if(list!=null && !list.isEmpty()){
            for (String user:list){
                System.out.println("用户："+user);
            }
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
