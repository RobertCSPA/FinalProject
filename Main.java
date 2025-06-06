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
            System.out.println("type 1 to create a new normal event");
            System.out.println("type 2 to create a new important event");
            System.out.println("type 3 to create search for an event");
            System.out.println("type 4 to remove a normal event");
            System.out.println("type 5 to remove an important event");
            System.out.println("type 6 to print out a list of all normal events");
            System.out.println("type 7 to print out a list of all important events");
            System.out.println("type 8 to end the program");
            System.out.print("What would you like to do?: ");
            String request = s.nextLine();

            if(request.equals("1")){
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

            if(request.equals("2")){
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

            if (request.equals("3")){
                System.out.println("type 1 to search by name");
                System.out.println("type 2 to search by date");
                System.out.print("how would you like to search: ");
                String method = s.nextLine();
                if(method.equals("1")){
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
                else if(method.equals("2")){
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

            if(request.equals("4")){
                System.out.print("which element would you like to remove: ");
                int index = s.nextInt();
                eventList.remove(index);
            }

            if(request.equals("5")){
                System.out.print("which element would you like to remove: ");
                int index = s.nextInt();
                importantEventList.remove(index);
            }

            if(request.equals("6")){
                for(Event e : eventList) System.out.println(e);
            }
            if(request.equals("7")){
                for(ImportantEvent e : importantEventList) System.out.println(e);
            }

            if(request.equals("8")){
                System.out.println("program has ended");
                break;
            }
        }
    }
}
