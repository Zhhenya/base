package Service;

public class Request {
    public static String paraTable = "SELECT DISCIPLINA.NAME, GROUPPA.NAME, VID.VID, PREPODAVATEL.FIO" +
            " FROM PREPODAVATEL  JOIN PARA  on PARA.PREPODAVATEL_PK_PREPOD = PREPODAVATEL.PK_PREPOD" +
            "  JOIN VID on PARA.VID_PK_VID = VID.PK_VID" +
            "  JOIN GROUPPA  on PARA.GROUP_PK_GROUP = GROUPPA.PK_GROUP" +
            "  JOIN DISCIPLINA  on PARA.DISCIPLINA_PK_DISC = DISCIPLINA.PK_DISC";
    public static String studentTable = "select student.fio, grouppa.name from STUDENT join GROUPPA" +
            "  on STUDENT.GROUP_PK_GROUP = GROUPPA.PK_GROUP";


    public static String teacherTable = "select fio from PREPODAVATEL";

    public static String teacherDisciplineTable = "select distinct prepodavatel.fio, DISCIPLINA.name from ocenka join PREPODAVATEL\n" +
            "on ocenka.PREPODAVATEL_PK_PREPOD = PREPODAVATEL.PK_PREPOD join DISCIPLINA\n" +
            "on DISCIPLINA.PK_DISC = OCENKA.DISCIPLINA_PK_DISC ";
    public static String addTeacher = "";

    public static String findTeacher = "select distinct prepodavatel.fio, DISCIPLINA.name from ocenka join PREPODAVATEL\n" +
            "on ocenka.PREPODAVATEL_PK_PREPOD = PREPODAVATEL.PK_PREPOD join DISCIPLINA\n" +
            "on DISCIPLINA.PK_DISC = OCENKA.DISCIPLINA_PK_DISC and PREPODAVATEL.FIO = ";

    public static String findTeacherWithoutDiscipline = "select distinct fio from PREPODAVATEL where PREPODAVATEL.FIO = ";

}
