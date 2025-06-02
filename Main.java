import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        ArrayList<ImportantEvent> importantEventList = new ArrayList<ImportantEvent>();

        while (true){

            Scanner s = new Scanner(System.in);
            System.out.println("What would you like to do?: ");
            String request = s.nextLine();

            if(request.equals("make a new event")){
                Scanner a = new Scanner(System.in);
                System.out.println("month: ");
                int month = a.nextInt();
                Scanner b = new Scanner(System.in);
                System.out.println("day:");
                int day = b.nextInt();
                Scanner c = new Scanner(System.in);
                System.out.println("year:");
                int year = c.nextInt();
                Scanner d = new Scanner(System.in);
                System.out.println("name:");
                String name = d.nextLine();
                Event ev = new Event(month, day, year, name);
                if (eventList.size() == 0)eventList.add(ev);
                else{
                    int index = eventList.size();
                    for(int i = 0; i < eventList.size(); i++){
                        if(eventList.get(i).getYear() < ev.getYear()){

                        index = i;
                    }
                    else if(eventList.get(i).getMonth() < ev.getMonth()){

                        index = i;
                    }
                    else if(eventList.get(i).getDay() < ev.getDay()){
                        index = i;
                    }
                    }
                    eventList.add(index, ev);
                }
            }

            if(request.equals("make a new important event")){
                Scanner a = new Scanner(System.in);
                System.out.println("month: ");
                int month = a.nextInt();
                Scanner b = new Scanner(System.in);
                System.out.println("day:");
                int day = b.nextInt();
                Scanner c = new Scanner(System.in);
                System.out.println("year:");
                int year = c.nextInt();
                Scanner d = new Scanner(System.in);
                System.out.println("name:");
                String name = d.nextLine();
                Scanner e = new Scanner(System.in);
                System.out.println("reason:");
                String reason = e.nextLine();
                ImportantEvent ev = new ImportantEvent(month, day, year, name, reason);
                if (importantEventList.size() == 0)importantEventList.add(ev);
                else{
                    int index = importantEventList.size()-1;
                    for(int i = 0; i < importantEventList.size(); i++){
                        if(importantEventList.get(i).getYear() < ev.getYear()){

                        index = i;
                    }
                    else if(importantEventList.get(i).getMonth() < ev.getMonth()){

                        index = i;
                    }
                    else if(importantEventList.get(i).getDay() < ev.getDay()){
                        index = i;
                    }
                    }
                    importantEventList.add(index, ev);
                }
            }

            if (request.equals("search event")){
                Scanner a = new Scanner(System.in);
                System.out.println("how would you like to search: ");
                String method = a.nextLine();
                if(method.equals("name")){
                    Scanner n = new Scanner(System.in);
                    System.out.println("what is the name of the event?: ");
                    String name = n.nextLine();
                    boolean dne = true;
                    for (Event e:eventList){
                        if (e.getName().equals(name)){
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
                else{
                    Scanner m = new Scanner(System.in);
                    System.out.println("what is the month of the event?: ");
                    int month = m.nextInt();
                    Scanner d = new Scanner(System.in);
                    System.out.println("what is the day of the event?: ");
                    int day = d.nextInt();
                    Scanner y = new Scanner(System.in);
                    System.out.println("what is the year of the event?: ");
                    int year = y.nextInt();
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
                Scanner i = new Scanner(System.in);
                System.out.println("which element would you like to remove: ");
                int index = i.nextInt();
                eventList.remove(i);
            }

            if(request.equals("remove important")){
                Scanner i = new Scanner(System.in);
                System.out.println("which element would you like to remove: ");
                int index = i.nextInt();
                importantEventList.remove(i);
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
