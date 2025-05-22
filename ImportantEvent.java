class ImportantEvent extends Event{
    private int day;
    private int month;
    private int year;
    private String name;
    private String reason;
    public ImportantEvent(int m, int d, int y, String n, String r){
        super(m, d, y, n);
        reason = r;
    }

    public String getReason(){
        return reason;
    }

    public void setReason(String c){
        reason = c;
    }

    public String toString(){
        return "event: " + name + ", time: " + month + "/" + day + "/" + year + " reason: " + reason;
    }
}