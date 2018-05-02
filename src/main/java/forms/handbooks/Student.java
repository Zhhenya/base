package forms.handbooks;

public class Student {
    private String FIO;
    private String group;

    public Student(String FIO, String group){
        this.FIO = FIO;
        this.group  = group;
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
}
