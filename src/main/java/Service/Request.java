package Service;

public class Request {
    public static String paraTable = "SELECT DISCIPLINA.NAME, GROUPPA.NAME, VID.VID, PREPODAVATEL.FIO" +
            " FROM PREPODAVATEL  JOIN PARA  on PARA.PREPODAVATEL_PK_PREPOD = PREPODAVATEL.PK_PREPOD" +
            "  JOIN VID on PARA.VID_PK_VID = VID.PK_VID" +
            "  JOIN GROUPPA  on PARA.GROUP_PK_GROUP = GROUPPA.PK_GROUP" +
            "  JOIN DISCIPLINA  on PARA.DISCIPLINA_PK_DISC = DISCIPLINA.PK_DISC";
    public static String studentTable = "select student.fio, grouppa.name from STUDENT join GROUPPA" +
            "  on STUDENT.GROUP_PK_GROUP = GROUPPA.PK_GROUP";

}
