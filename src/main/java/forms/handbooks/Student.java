package forms.handbooks;

public class Student {
    private String FIO;
    private String group;
    private int index;

  /*  public Student(String FIO, String group){
        this.FIO = FIO;
        this.group  = group;
    }*/

    public Student(String FIO){
        this.FIO = FIO;
    }
    public Student(String FIO, int index){
        this.FIO = FIO;
        this.index = index;
    }

    public Student(){
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
