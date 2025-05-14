class Event{
    private int day;
    private int month;
    private int year;
    private String name;
    public Event(int d, int m, int y, String n){
        day = d;
        month = m;
        year = y;
        name = n;
    }
    public String getName(){
        return name;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public void setName(String s){
        name = s;
    }
    public void setDay(int d){
        day = d;
    }
    public void setMonth(int m){
        month = m;
    }
    public void setYear(int y){
        year = y;
    }
}
