package sol_rdp.cpn;

public class Transicao {
    private String id;
    private String name;
    private String guard;

    public Transicao(String id, String name, String guard) {
        this.id = id;
        this.name = name;
        this.guard = guard;
    }

    public Transicao(String id, String name) {
        this.id = id;
        this.name = name;
        this.guard = "";
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

    public String getGuard() {
        return guard;
    }

    public void setGuard(String guard) {
        this.guard = guard;
    }

    @Override
    public String toString() {
        return String.format("Transicao{id='%s', name='%s', guard='%s'}", id, name, guard);
    }
}