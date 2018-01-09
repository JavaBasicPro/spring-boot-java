package event;

/**
 * Created by jinpanpan on 2018/1/8.
 */
public class Main {

    public static void main(String[] args) {

        MySource s = new MySource();
        MyListener l = new MyListener();
        s.addListener(l);
        //s.setValue(10);
    }

}

