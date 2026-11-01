package problem2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HelpDesk desk = new HelpDesk();
        int choice;

        do {
            System.out.println("\n===== HELP DESK MENU =====");
            System.out.println("1. Add employee");
            System.out.println("2. Add ticket");
            System.out.println("3. Complete ticket");
            System.out.println("4. Waiting ticket count");
            System.out.println("5. Completed tickets total point");
            System.out.println("6. Tickets total point by category");
            System.out.println("7. Tickets total point by employee");
            System.out.println("8. Run custom testing input (n, m, k format)");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            try {
                switch (choice) {
                    case 1: {
                        System.out.print("Full name: ");
                        String name = sc.nextLine().trim();
                        System.out.print("Point level: ");
                        int level = Integer.parseInt(sc.nextLine().trim());
                        System.out.println("Categories: " + Arrays.toString(Category.values()));
                        System.out.print("Assigned categories (separated by space): ");
                        List<Category> cats = new ArrayList<>();
                        for (String s : sc.nextLine().trim().split("\\s+"))
                            cats.add(Category.valueOf(s));
                        desk.addEmployee(new Employee(name, level, cats));
                        System.out.println("Employee added.");
                        break;
                    }
                    case 2: {
                        System.out.print("Ticket id: ");
                        int id = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Ticket name: ");
                        String name = sc.nextLine().trim();
                        System.out.println("Categories: " + Arrays.toString(Category.values()));
                        System.out.print("Category: ");
                        Category cat = Category.valueOf(sc.nextLine().trim());
                        System.out.print("Points: ");
                        int points = Integer.parseInt(sc.nextLine().trim());
                        desk.addTicket(new Ticket(id, name, cat, points));
                        System.out.println("Ticket added.");
                        break;
                    }
                    case 3: {
                        System.out.print("Employee full name: ");
                        String who = sc.nextLine().trim();
                        System.out.print("Ticket id: ");
                        int ticketId = Integer.parseInt(sc.nextLine().trim());
                        int waitingBefore = desk.getWaitingTicketCount();
                        desk.completeTicket(who, ticketId);
                        System.out.println(desk.getWaitingTicketCount() < waitingBefore
                                ? "Completed" : "Not completed");
                        break;
                    }
                    case 4:
                        System.out.println("WaitingTicketCount:" + desk.getWaitingTicketCount());
                        break;
                    case 5:
                        System.out.println("CompletedTicketsTotalPoint:" + desk.getCompletedTicketsTotalPoint());
                        break;
                    case 6:
                        System.out.println("TicketsTotalPointByCategory:");
                        for (CategoryNode c : desk.getTicketsTotalPointByCategory())
                            System.out.println(c.category + ":" + c.totalPoint);
                        break;
                    case 7:
                        System.out.println("TicketsTotalPointByEmployee:");
                        for (EmployeeNode e : desk.getTicketsTotalPointByEmployee())
                            System.out.println(e.employee.getFullName() + ":" + e.totalPoint);
                        break;
                    case 8: {
                        desk = new HelpDesk();
                        System.out.println("Paste the input:");

                        int n = Integer.parseInt(sc.nextLine().trim());
                        for (int i = 0; i < n; i++) {
                            String[] p = sc.nextLine().split(",");
                            List<Category> cats = new ArrayList<>();
                            for (String s : p[2].trim().split("\\s+"))
                                cats.add(Category.valueOf(s));
                            desk.addEmployee(new Employee(p[0].trim(), Integer.parseInt(p[1].trim()), cats));
                        }

                        int m = Integer.parseInt(sc.nextLine().trim());
                        for (int i = 0; i < m; i++) {
                            String[] p = sc.nextLine().split(",");
                            desk.addTicket(new Ticket(Integer.parseInt(p[0].trim()), p[1].trim(),
                                    Category.valueOf(p[2].trim()), Integer.parseInt(p[3].trim())));
                        }

                        int k = Integer.parseInt(sc.nextLine().trim());
                        for (int i = 0; i < k; i++) {
                            String[] p = sc.nextLine().split(",");
                            desk.completeTicket(p[0].trim(), Integer.parseInt(p[1].trim()));
                        }

                        System.out.println("WaitingTicketCount:" + desk.getWaitingTicketCount());
                        System.out.println("CompletedTicketsTotalPoint:" + desk.getCompletedTicketsTotalPoint());
                        System.out.println("TicketsTotalPointByCategory:");
                        for (CategoryNode c : desk.getTicketsTotalPointByCategory())
                            System.out.println(c.category + ":" + c.totalPoint);
                        System.out.println("TicketsTotalPointByEmployee:");
                        for (EmployeeNode e : desk.getTicketsTotalPointByEmployee())
                            System.out.println(e.employee.getFullName() + ":" + e.totalPoint);
                        break;
                    }
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (RuntimeException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        } while (choice != 0);
    }
}