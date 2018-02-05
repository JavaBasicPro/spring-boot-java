package pattern;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by jinpanpan on 2018/2/5.
 * \
 * 命令模式：模拟灯泡的开关
 */
public class CommondTest {

    public static void main(String[] args) {

        SimpleRemoteControl remoteControl=new SimpleRemoteControl();

        Light light=new Light();

        LightOnCommand lightOnCommand=new LightOnCommand(light);    //创建命令，将接收者传给他

        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();

        LightOffCommand lightOffCommand=new LightOffCommand(light);
        remoteControl.setCommand(lightOffCommand);   //把命令传给调用者
        remoteControl.buttonWasPressed();

    }
}

//命令接口
interface Command {
    void execute();
}

//实现命令 接口，执行命令
class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command{

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class Light {

    void on() {
        System.out.println("开灯");
    }

    void off() {
        System.out.println("关灯");
    }
}

//使用命令对象
class SimpleRemoteControl{
    Command command;

    public SimpleRemoteControl() {}

    public SimpleRemoteControl(Command command) {
        this.command = command;
    }
    //按下命令，如果客户需要改变遥控器的行为，可以多次调用这个方法
    void buttonWasPressed(){
        command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}

class NoCommand implements Command{

    @Override
    public void execute(){

    }

}


class SimpleRemoteControl1{

    private Command [] onCommands;

    private Command [] offCommands;

    public SimpleRemoteControl1(Command[] onCommands, Command[] offCommands) {
        this.onCommands = new Command[7];
        this.offCommands = new Command[7];

       Command onCommand=new NoCommand();
       for (int i=0;i<7;i++){
           onCommands[i]=onCommand;
           offCommands[i]=onCommand;
       }
    }
}