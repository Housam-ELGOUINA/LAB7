package problem4;



public abstract class ListItem {
    protected ListItem rightLink ;
    protected ListItem leftLink ;
    protected Object value ;


    ListItem(ListItem rightLink , ListItem leftLink , Object value) {
        this.rightLink = rightLink ;
        this.leftLink  =  leftLink ;
        this.value =   value ;
    }

     abstract   ListItem next() ;

     abstract ListItem setNext(ListItem r) ;

     abstract ListItem previous()  ;

     abstract ListItem setPrevious(ListItem l) ;

     abstract int compareTo(ListItem item) ;

     public Object getValue() {
         return this.value ;
     }

     public void setValue(Object value ) {
         this.value =  value ;
     }








}
