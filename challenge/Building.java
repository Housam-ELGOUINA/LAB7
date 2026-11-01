package challenge;

public class Building implements Mappable{
    private String name ;
    private UsageType type ;

    public Building(String name  , UsageType type) {
        this.name  = name ;
        this.type  =  type ;
    }

    enum UsageType {
        BUISINESS("buisiness"),
        ENTERTAINEMENT("entertainement");

        private final String label ;

        UsageType(String label) {
            this.label =  label ;
        }


    }

    @Override
    public String getLabel() {
        return this.name + " (" + this.type + ")" ;
    }

    @Override
    public String getMarker() {
        if ( this.type == UsageType.BUISINESS) {
            return Color.BLACK + " " + PointMarkers.DIAMOND ;
        }


        return Color.BLACK + " " + PointMarkers.CIRCLE ;
    }

    @Override
    public String toJSON() {
        return " JSON infos  : "  ;
    }

    @Override

    public Geometry getShape() {
        return Geometry.POLYGON ;
    }




}
