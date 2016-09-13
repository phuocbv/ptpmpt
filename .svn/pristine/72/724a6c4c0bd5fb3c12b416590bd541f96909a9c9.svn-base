/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.config;

/**
 *
 * @author DA CUOI
 */
public class SQL {

    public static final String SQL_ = "";
    public static final String GET_LIST_COURSE_OF_ACCOUNT = "SELECT * "
            + " FROM mydb.course C JOIN "
            + "	( SELECT C_A.id_cource AS id_course "
            + "	FROM mydb.account A "
            + "	JOIN mydb.course_account C_A "
            + "	ON A.idaccount = C_A.id_account_create "
            + " WHERE A.idaccount = ? "
            + "	) new_table "
            + " on C.id = new_table.id_course ";
}
