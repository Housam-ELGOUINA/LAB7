package problem4;

public class Node extends ListItem{

    @Override
    ListItem next()  {
        return this.rightLink ;
    }

    @Override
    ListItem setNext(ListItem r) {
        this.rightLink = r ;
        return this.rightLink ;
    }

    @Override
     ListItem previous()  {
        return this.leftLink ;
    }

    @Override
    ListItem setPrevious(ListItem l)  {
        this.leftLink  =  l ;

        return this.leftLink ;
    }


    @Override
     int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue()) ;
        }

    }
}
