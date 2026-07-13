package sol_rdp.cpn;

public class Lugar {
    private String id;
    private String name;
    private String colorSet;
    private String initialMarking;
    private boolean isOracle;

    public Lugar(String id, String name, String colorSet, String initialMarking) {
        this.id = id;
        this.name = name;
        this.colorSet = colorSet;
        this.initialMarking = initialMarking;
        this.isOracle = false;
    }

    public Lugar(String id, String name, String colorSet, String initialMarking, boolean isOracle) {
        this.id = id;
        this.name = name;
        this.colorSet = colorSet;
        this.initialMarking = initialMarking;
        this.isOracle = isOracle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorSet() {
        return colorSet;
    }

    public void setColorSet(String colorSet) {
        this.colorSet = colorSet;
    }

    public String getInitialMarking() {
        return initialMarking;
    }

    public void setInitialMarking(String initialMarking) {
        this.initialMarking = initialMarking;
    }

    public boolean isOracle() {
        return isOracle;
    }

    public void setOracle(boolean oracle) {
        isOracle = oracle;
    }

    @Override
    public String toString() {
        return String.format("Lugar{id='%s', name='%s', colorSet='%s', initialMarking='%s', isOracle=%s}",
                id, name, colorSet, initialMarking, isOracle);
    }
}