class ImportantEvent extends Event{
    private String reason;

    public ImportantEvent(int m, int d, int y, String n, String r){
        super(m, d, y, n);
        reason = r;
    }

    public String getReason(){
        return reason;
    }

    public String toString(){
        return super.toString() + ", reason: " + reason;
    }
}