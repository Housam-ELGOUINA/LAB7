package problem4;

import java.awt.event.ItemEvent;
import java.util.List;

public class MyLinkedList implements NodeList {

    private ListItem root ;


    MyLinkedList(ListItem root) {
        this.root  =  root ;
    }
     @Override
     public ListItem getRoot()  {
         return root;
     }

     @Override
     public boolean addItem(ListItem item)  {
        if ( item == null) {
            return false  ;
        }

        if ( root  == null) {
            root  = item ;

            return true ;
        }


        ListItem current  =  root ;

        while( current != null) {

            int cmp  =  current.compareTo(item) ;
            if ( cmp < 0) {
                if ( current.next() != null)  {
                    current =   current.next();
                } else {
                    current.setNext(item) ;

                    item.setPrevious(current) ;
                    return true ;
                }
            } else if (cmp >0) {
                if ( current.previous() != null) {
                    current.previous().setNext(item) ;
                    item.setPrevious(current.previous()) ;
                } else {
                    root   = item ;
                }

                item.setNext(current) ;
                current.setPrevious(item);

                return true ;

            } else {
                return  false ;
            }

        }

        return  false ;
     }

    @Override
    public boolean removeItem(ListItem item) {
        if (item == null || root == null) return false;

        ListItem current = root;
        while (current != null) {
            int cmp = current.compareTo(item);

            if (cmp == 0) {
                if (current.previous() != null) {
                    current.previous().setNext(current.next());
                } else {
                    root = current.next();          // removing the first item
                }
                if (current.next() != null) {
                    current.next().setPrevious(current.previous());
                }
                return true;
            } else if (cmp > 0) {
                return false;
            }
            current = current.next();
        }
        return false;
    }
     @Override
     public void traverse(ListItem root) {

        if ( root == null) {
            System.out.println("the list is empty!!") ;

            return ;
        }

        while ( root != null) {
            System.out.println(root.getValue()) ;
            root  =  root.next() ;
        }

     }
}
