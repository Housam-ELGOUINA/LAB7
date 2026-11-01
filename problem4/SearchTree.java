package problem4;

public class SearchTree implements  NodeList{
    private ListItem root ;

    SearchTree(ListItem root) {
        this.root  =  root ;
    }
    @Override
    public  ListItem getRoot()  {
        return this.root ;
    }

    @Override
    public boolean addItem(ListItem item)  {
        if ( this.root  == null) {
            this.root  =  item ;
        }
        ListItem  current  =  this.root  ;
        while ( current != null) {
            int cmp = current.compareTo(item) ;

            if ( cmp < 0) {
                if ( current.next() != null) {
                    current = current.next() ;
                } else {
                    current.setNext(item) ;
                    return true ;
                }
            } else if ( cmp > 0) {
                if ( current.previous() != null) {
                    current  =  current.previous() ;
                } else {
                    current.setPrevious(item) ;

                    return true   ;
                }
            } else {
                return false ;
            }
        }

        return false ;
    }

    @Override
    public boolean removeItem(ListItem item )  {
        if  (item == null || root  == null) return false  ;

        ListItem current = root ;
        ListItem parent  =  null ;

        while( current != null) {
            int cmp  =  current.compareTo(item) ;

            if ( cmp == 0) {
                performRemoval(current , parent);

                return true ;
            } else if( cmp < 0) {
                parent  =  current  ;
                current = current.next();
            } else {
                parent =  current  ;

                current  =  current.previous()  ;
            }
        }
        return false ;
    }

    @Override
    public void traverse(ListItem root) {
        if ( root != null) {
            traverse(root.previous()) ;
            System.out.println(root.getValue()) ;
            traverse(root.next()) ;

        }
    }

    private void performRemoval(ListItem item  , ListItem parent ) {
        if ( item.next() == null ) {
            if ( parent == null) {
                root  =  item.previous() ;

            } else if ( parent.next() == item) {
                parent.setNext(item.previous()) ;
            } else {
                parent.setPrevious(item.previous()) ;
            }
        }

        else if ( item.previous() == null) {
            if ( parent == null) {
                root = item.next() ;
            } else if ( parent.next() == item) {
                parent.setNext(item.next()) ;
            } else {
                parent.setPrevious(item.next()) ;
            }
        }
        else {
            ListItem leftMostParent  = item ;

            ListItem LeftMost =  item.next() ;

            while(LeftMost.previous() != null) {
                leftMostParent  =  LeftMost ;

                LeftMost =  LeftMost.previous() ;
            }

            item.setValue(LeftMost.getValue());


            if ( leftMostParent == item) {
                leftMostParent.setNext(LeftMost.next()) ;
            } else {
                leftMostParent.setPrevious(LeftMost.next()) ;
            }
        }

    }
}
