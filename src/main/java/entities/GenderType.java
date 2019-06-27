package entities;

public enum GenderType {
    MAN("Man"),WOMAN("Woman"),X("?");

    private String description;

    GenderType (String description){
        this.description = description;
    }
}
