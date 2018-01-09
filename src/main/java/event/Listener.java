package event;

import java.util.EventListener;

/**
 * Created by jinpanpan on 2018/1/8.
 */
public interface Listener extends EventListener{

    //监听的具体 事件对象
    void addLoanApplyTrade(MyEvent e);

    //监听的具体 事件对象
    void updateLoanTrade(MyEvent event);
}
