package challenge;

public class UtilityLine implements Mappable{

    private String name ;
    private UtilityType UtilityType ;

    enum UtilityType {
        ELECTRICAL ,
        FIBER_OPTIC
    }


    @Override
    public Geometry getShape() {
        return null;
    }

    @Override
    public String getLabel() {
        return "";
    }

    @Override
    public String getMarker() {
        return "";
    }

    @Override
    public String toJSON() {
        return "JSON infos";
    }
}
