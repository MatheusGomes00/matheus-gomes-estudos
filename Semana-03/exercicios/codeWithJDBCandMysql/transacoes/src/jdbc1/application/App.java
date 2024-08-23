package jdbc1.application;

import jdbc1.db.DB;
import jdbc1.db.DbException;
import jdbc1.db.DbIntegrityException;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/*
  criar uma atividade envolvendo uma operação bancária de deposito
  entre duas contas... a primeira e a segunda conta não podem ser efetivadas
  caso haja um erro durante o fluxo da transação.
 */

public class App {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);  // seta o commit como manual para captar erros de transação

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2100 WHERE DepartmentId = 1");

            //  simulação de erro, a transação não vai ser efetivada
            //  devido o lançamento do erro abaixo na transação
            //  do bloco try atual
//            int x = 1;
//            if(x < 2){
//                throw new SQLException("Fake error");
//            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3100 WHERE DepartmentId = 2");

            conn.commit();  // efetiva a transação caso não houver erros

            System.out.println("rows1: " + rows1);
            System.out.println("rows2: " + rows2);


        } catch(SQLException e){
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch(SQLException e1){
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
