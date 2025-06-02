class Event{
    private int day;
    private int month;
    private int year;
    private String name;
    public Event(int m, int d, int y, String n){
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

    public String toString(){
        return "event: " + name + ", time: " + month + "/" + day + "/" + year;
    }
}
