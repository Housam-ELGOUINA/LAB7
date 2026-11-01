package problem2;

import java.util.ArrayList;
import java.util.List;

public class Employee implements IEmployee{

    private String FullName ;
    private int PointLevel  ;

    private List<Category> AssignedCategories ;


    Employee(String name , int pointlevel , List<Category> AssignedCategories) {
        this.FullName  =  name ;
        this.PointLevel =  pointlevel ;
        this.AssignedCategories = AssignedCategories ;
    }

    public void setFullName(String fullName) {
        this.FullName  = fullName  ;
    }

    public String getFullName() {
        return this.FullName ;
    }
    public void setPointLevel(int pointLevel) {
        this.PointLevel = pointLevel ;
    }
    public int getPointLevel() {
        return this.PointLevel ;
    }
    public void setAssignedCategories(List <Category> assignedCategories) {
        List<Category> newAssignedCategories  =  new ArrayList<>();
        for ( Category c : assignedCategories) {
            newAssignedCategories.add(c) ;
        }

        this.AssignedCategories =  newAssignedCategories ;
    }
    public List <Category> getAssignedCategories() {
        return this.AssignedCategories ;
    }
}
