package JDBC.learning.DBUtils;

public class Actor {
    private String NAME;
    private char SEX;
    private Integer id;

    public Actor() {
    }

    public Actor(String NAME, char SEX, int id) {
        this.NAME = NAME;
        this.SEX = SEX;
        this.id = id;
    }

    public String getNAME() {
        return NAME;
    }

    public char getSEX() {
        return SEX;
    }

    public int getId() {
        return id;
    }
}
