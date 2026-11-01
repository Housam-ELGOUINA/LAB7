package challenge;

public interface Mappable {
    String JSON_PROPERTY  = "properties  : {%s}" ;

    enum Geometry {
        LINE("line"),
        POINT("point") ,
        POLYGON("polygon") ;

        private final String label ;

        Geometry(String lable) {
            this.label =  lable ;
        }
        public String getLabel() {
            return this.label ;
        }
    }
    public static void maplt(Mappable mappable) {
        System.out.println(String.format("Properties JSON for %s : " , mappable.getLabel())) ;
        System.out.println(" { " + mappable.toJSON() + " }") ;
    }

    String toJSON() ;
    String getLabel() ;
    String getMarker()  ;
    Geometry getShape() ;


}
