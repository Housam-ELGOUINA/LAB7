package problem2;

 class Ticket implements ITicket {
    private int id;
    private String name ;
    private Category category ;
    private int Point ;
    private String AssignedEmployee  ;
    private boolean IsCompleted ;

    Ticket(int id , String name , Category category , int Point) {
        this.id  =  id ;
        this.name =  name ;
        this.category =  category ;
        this.Point= Point ;

    }

    public void setId(int id) {
        this.id  =  id ;
    }
    public int getId() {
        return this.id ;
    }
    public void setName(String name) {
        this.name = name ;
    }
    public String getName() {
        return this.name ;
    }
    public void setCategory(Category category) {
        this.category =  category ;
    }
    public Category getCategory() {
        return this.category ;
    }
    public void setPoint(int point) {
        this.Point = point ;
    }
    public int getPoint() {
        return this.Point ;
    }
    public void setIsCompleted(boolean isCompleted) {
        this.IsCompleted = isCompleted ;
    }
    public boolean getIsCompleted() {
        return this.IsCompleted ;

    }
    public void setAssignedEmployee(String assignedEmployee) {
        this.AssignedEmployee = assignedEmployee ;
    }
    public String getAssignedEmployee() {
        return this.AssignedEmployee ;
    }
}
