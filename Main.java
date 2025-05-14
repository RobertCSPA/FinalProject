import java.util.ArrayList;
public class Main{
    public static void main(String[] args) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        ArrayList<Event> sortedEventList = new ArrayList<Event>();
        while(eventList.size() != 0){
            Event nearest = eventList.get(0);
            int index = 0;
            for(int i = 0; i < eventList.size(); i++){
                if(eventList.get(i).getYear() < nearest.getYear()){
                    nearest = eventList.get(i);
                    index = i;
                }
                else if(eventList.get(i).getMonth() < nearest.getMonth()){
                    nearest = eventList.get(i);
                    index = i;
                }
                else if(eventList.get(i).getDay() < nearest.getDay()){
                    nearest = eventList.get(i);
                    index = i;
                }
            }
            sortedEventList.add(nearest);
            eventList.remove(index);
        }
    }
}
