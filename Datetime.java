//subclass Datetime
public class Datetime
{
    private int year;
    private int month;
    private int day;
    private String hour;
    private String minutes;
    
    public Datetime(int y, int mth, int d, String h, String min)
    {
        year=y;
        month=mth;
        day=d;
        hour=h;
        minutes=min;
    }
    
    public void setDateTime(int y, int mth, int d, String h, String min){
        year=y;
        month=mth;
        day=d;
        hour=h;
        minutes=min;
    }
    
    public int getYear()
    {
        return year;
    }
    
        public int getMonth()
    {
        return month;
    }
    
        public int getDay()
    {
        return day;
    }
    
        public String getHour()
    {
        return hour;
    }

    public String getMinutes()
    {
        return minutes;
    }
    
    public String displaydate()
    {
        return +day+"/"+month+"/"+year+"\n\t\t  Time : "+hour+" : "+minutes;
    }
}