import java.util.ArrayList; //imported ArrayList library for Events and ImportantEvents
import java.util.Scanner; //imported Scanner library to take in user input
// ArrayList constructor, add, remove, size and get functions used
// Scanner constructor, nextLine and nextInt functions used
public class Main{
    public static void main(String[] args) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        ArrayList<ImportantEvent> importantEventList = new ArrayList<ImportantEvent>();

        while (true){

            Scanner s = new Scanner(System.in);
            System.out.print("What would you like to do?: ");
            String request = s.nextLine();

            if(request.equals("make a new event")){
                System.out.print("month: ");
                int month = s.nextInt();
                System.out.print("day: ");
                int day = s.nextInt();
                System.out.print("year:");
                int year = s.nextInt();
                s.nextLine();
                System.out.print("name: ");
                String name = s.nextLine();
                Event ev = new Event(month, day, year, name);
                if (eventList.size() == 0)eventList.add(ev);
                else{
                    int index = eventList.size();
                    for(int i = 0; i < eventList.size(); i++){
                        if (ev.getYear() < eventList.get(i).getYear() ||
                        (ev.getYear() == eventList.get(i).getYear() && ev.getMonth() < eventList.get(i).getMonth()) ||
                        (ev.getYear() == eventList.get(i).getYear() && ev.getMonth() == eventList.get(i).getMonth() && ev.getDay() < eventList.get(i).getDay())) {
                            index = i;
                            break;
                        }
                    }
                    eventList.add(index, ev);
                }
            }

            if(request.equals("make a new important event")){
                System.out.print("month: ");
                int month = s.nextInt();
                System.out.print("day: ");
                int day = s.nextInt();
                System.out.print("year: ");
                int year = s.nextInt();
                System.out.print("name: ");
                s.nextLine();
                String name = s.nextLine();
                System.out.print("reason: ");
                String reason = s.nextLine();
                ImportantEvent ev = new ImportantEvent(month, day, year, name, reason);
                if (importantEventList.size() == 0)importantEventList.add(ev);
                else{
                    int index = importantEventList.size();
                    for (int i = 0; i < importantEventList.size(); i++) {
                        if (ev.getYear() < importantEventList.get(i).getYear() ||
                            (ev.getYear() == importantEventList.get(i).getYear() && ev.getMonth() < importantEventList.get(i).getMonth()) ||
                            (ev.getYear() == importantEventList.get(i).getYear() && ev.getMonth() == importantEventList.get(i).getMonth() && ev.getDay() < importantEventList.get(i).getDay())) {
                            index = i;
                            break;
                            }
                        }
                        importantEventList.add(index, ev);
                    }
                }

            if (request.equals("search event")){
                System.out.print("how would you like to search: ");
                String method = s.nextLine();
                if(method.equals("name")){
                    System.out.print("what is the name of the event?: ");
                    String name = s.nextLine();
                    boolean dne = true;
                    for (Event e:eventList){
                        if (e.getName().indexOf(name)!=-1){
                            System.out.println(e);
                            dne = false;
                        }
                    }
                    if(dne)System.out.println("no such event exists with that name in the normal events");
                    boolean dne2 = true;
                    for (Event e:importantEventList){
                        if (e.getName().equals(name)){
                            System.out.println(e);
                            dne2 = false;
                        }
                    }
                    if(dne2)System.out.println("no such event exists with that name in the important events");
                }
                else if(method.equals("date")){
                    System.out.print("what is the month of the event?: ");
                    int month = s.nextInt();
                    System.out.print("what is the day of the event?: ");
                    int day = s.nextInt();
                    System.out.print("what is the year of the event?: ");
                    int year = s.nextInt();
                    boolean dne = true;
                    for (Event e:eventList){
                        if (e.getDay() == day){
                            if(e.getMonth() == month){
                                if(e.getYear() == year) System.out.println(e);
                                dne = false;
                            }
                        }
                    }
                    if(dne)System.out.println("no such normal event exists with that date");
                    boolean dne2 = true;
                    for (Event e:importantEventList){
                        if (e.getDay() == day){
                            if(e.getMonth() == month){
                                if(e.getYear() == year) System.out.println(e);
                                dne2 = false;
                            }
                        }
                    }
                    if(dne2)System.out.println("no such important event exists with that date");
                }
            }

            if(request.equals("remove normal")){
                System.out.print("which element would you like to remove: ");
                int index = s.nextInt();
                eventList.remove(index);
            }

            if(request.equals("remove important")){
                System.out.print("which element would you like to remove: ");
                int index = s.nextInt();
                importantEventList.remove(index);
            }

            if(request.equals("print events")){
                for(Event e : eventList) System.out.println(e);
            }
            if(request.equals("print important")){
                for(ImportantEvent e : importantEventList) System.out.println(e);
            }
        }
    }
}
