class Event{
    private int day;
    private String name;
    public Event(int d, String n){
        day = d;
        name = n;
    }
    public String getName(){
        return name;
    }
    public int getDay(){
        return day;
    }
    public void setName(String s){
        name = s;
    }
    public void setDay(int d){
        day = d;
    }
}
