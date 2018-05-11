package forms.handbooks;

public class Both {
    private String field;
    private int index;

    public Both(String field){
        this.field = field;
    }
    public Both(String field, int index){
        this.field = field;
        this.index = index;
    }
    public Both(){}

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
