package forms.handbooks;

public class Mark {
    private String student;
    private String discipline;
    private String vid;
    private  int mark;
    private String teacher;

    public Mark(String student, String discipline, String vid, int mark, String teacher){
        this.student = student;
        this.discipline = discipline;
        this.vid = vid;
        this.mark = mark;
        this.teacher = teacher;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVid() {
        return vid;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
}
