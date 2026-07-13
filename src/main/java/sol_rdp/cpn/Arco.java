package sol_rdp.cpn;

public class Arco {
    private String id;
    private String sourceId;
    private String targetId;
    private String expression;

    public Arco(String id, String sourceId, String targetId, String expression) {
        this.id = id;
        this.sourceId = sourceId;
        this.targetId = targetId;
        this.expression = expression;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public String toString() {
        return String.format("Arco{id='%s', source='%s', target='%s', expression='%s'}",
                id, sourceId, targetId, expression);
    }
}