package com.java.springbootjava;

/**
 * Created by jinpanpan on 2018/4/22.
 */
public class Test {

    public void handleException(Exception e){

        releaseResource();   //释放资源

        log();   //打印日志

        notifyUser();   //通知用户

    }

    private void releaseResource(){

    }

    private void log(){

    }

    private void notifyUser(){

    }


    public void readFile(Exception e){

        checkFileExist("");   //第一步

        checkFilePrivilege();   //第二步

        openFile();   //第三步

    }

    private void checkFileExist(String path){

    }

    private void checkFilePrivilege(){

    }

    private void openFile(){

    }

    public String getToy(int type){
        switch (type){
            case 1:
                return "ONE";
            case 2:
                return "TWO";
            case 3:
                return "THREE";
            default:return "";
        }
    }

    class Vict{
        private Integer money=100;

        void makeMoney(Integer delta){
            money += delta;
        }
    }

    class Thief{
        void stoleMoney(Vict vict){
            vict.money -=100;

        }
    }

}
