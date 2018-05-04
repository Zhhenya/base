package forms.handbooks;

import javafx.fxml.FXML;

public class Teacher {

    private String fio;
    private String discipline;

    public Teacher(String fio){
        this.fio = fio;
    }

    public Teacher(String fio, String discipline){
        this.fio = fio;
        this.discipline = discipline;
    }


    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }



    public String getDiscipline() {
        return discipline;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}
