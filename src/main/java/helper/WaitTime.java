package helper;

public class WaitTime
{
    public static void SpecifyWaitTime( int WaitTimeInMilliSeconds)
    {
        try {
            Thread.sleep(WaitTimeInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
