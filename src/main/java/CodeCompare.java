import java.io.Console;

/**
 * Created by jinpanpan on 2018/2/10.
 * 面向过程开发和 面向对象开发
 */
public class CodeCompare {

    public void delaySchedule()
    {
        /*switch (ScheduleType)
        {
            case ScheduleType.Once:
                System.out.println("Delay one hour");
                break;
            case ScheduleType.Daily:
                System.out.println("Delay one day");
                break;
            case ScheduleType.Weekly:
                System.out.println("Delay one week");
                break;
            default:
                throw new RuntimeException("unsupported schedule");
        }*/
    }
}

abstract class  Schedule{
    public abstract void delaySchedule();
}
class OnceSchedule extends Schedule{

    @Override
    public void delaySchedule() {
        System.out.println("Delay one hour");
    }
}
class DailySchedule extends Schedule{
    @Override
    public void delaySchedule() {
        System.out.println("Delay one day");
    }
}

class WeekilySchedule extends Schedule{
    @Override
    public void delaySchedule() {
        System.out.println("Delay one week");
    }
}