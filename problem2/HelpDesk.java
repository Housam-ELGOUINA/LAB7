package problem2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HelpDesk {
    private List<Employee> Employees ;
    private List<Ticket> Tickets ;

    public void addTicket(ITicket ticket) {
        Tickets.add((Ticket) ticket) ;

    }
    public void addEmployee(IEmployee employee) {
        Employees.add((Employee) employee) ;
    }
    public void completeTicket(String employeeFullName, int ticketId) {
        for ( int i =0 ; i <this.Tickets.size() ; i++) {
            if ( this.Tickets.get(i).getId() == ticketId && this.Tickets.get(i).getAssignedEmployee() == employeeFullName) {
                this.Tickets.get(i).setIsCompleted(true);
            }
        }
    }
    public int getWaitingTicketCount() {
        int count = 0 ;
        for (Ticket ticket : this.Tickets) {
            if (ticket.getIsCompleted() == false ) {
                count ++  ;
            }
        }

        return count ;
    }
    public int getCompletedTicketsTotalPoint() {
        int totalPoints =  0 ;
        for ( Ticket ticket  :  this.Tickets) {

            totalPoints += ticket.getPoint() ;

        }

        return  totalPoints ;
    }
    public List<CategoryNode> getTicketsTotalPointByCategory() {

        ArrayList<CategoryNode> result  =  new ArrayList<>() ;

        for ( Ticket t : this.Tickets) {
            boolean found = false;
            for ( CategoryNode node  : result) {
                if ( t.getCategory() == node.category) {
                    node.totalPoint  += t.getPoint() ;
                    found  =  true ;
                }
            }

            if (found == false) {
                CategoryNode  newCategory = new CategoryNode(t.getCategory() , t.getPoint()) ;
                result.add(newCategory)  ;
            }


        }
        return result ;


    }
    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
        ArrayList<EmployeeNode> result  =  new ArrayList<>() ;

        for ( Employee e : this.Employees) {
            boolean found = false;
            for ( EmployeeNode node  : result) {
                if ( e.getFullName() == node.employee.getFullName()) {
                    node.totalPoint  += e.getPointLevel() ;
                    found  =  true ;
                }
            }

            if (found == false) {
                EmployeeNode  newCategory = new EmployeeNode(e , e.getPointLevel()) ;
                result.add(newCategory)  ;
            }


        }
        return result ;

    }

}
