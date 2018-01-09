package event;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by jinpanpan on 2018/1/8.
 * 具体的事件源
 */
public class MySource {

    private Collection listeners;   //存储监听对象

    public void addListener(Listener listener){

       if (listeners==null){
           listeners=new HashSet();
       }
       listeners.add(listener);
    }

    //添加移除事件方法
    public void removeSwitchListener(Listener listener){

        if(listeners == null){
            return;
        }
        listeners.remove(listener);
    }

    public void openDoor(MyEvent myEvent){

        Iterator iter = listeners.iterator();
        while (iter.hasNext()){
            MyEvent myE= (MyEvent) iter.next();

            //listeners

        }


    }

}
