package event;

import java.util.EventObject;

/**
 * Created by jinpanpan on 2018/1/8.
 */
public class MyEvent extends EventObject{

    private int value;

    public MyEvent(Object source,int name) {
        super(source);
        this.value=name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
