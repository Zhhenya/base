package forms.handbooks;

public class Class {
    private String discipline;
    private String group;
    private String teacher;
    private String vid;
    private int index;

    public Class(String discipline, String group, String teacher, String vid){
        this.discipline = discipline;
        this.group = group;
        this.teacher = teacher;
        this.vid = vid;
    }

    public Class(String discipline, String group, String teacher, String vid, int index){
        this.discipline = discipline;
        this.group = group;
        this.teacher = teacher;
        this.vid = vid;
        this.index = index;
    }

    public Class(){
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
