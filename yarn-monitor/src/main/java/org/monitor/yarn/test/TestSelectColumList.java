package org.monitor.yarn.test;

import org.monitor.yarn.jdbc.JDBCHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/6/19.
 */
public class TestSelectColumList {
    public static void main(String[] args) {
        ArrayList<String> list  =select(2);
        for (String str : list) {
            System.out.println(str);

        }

    }
    public  static ArrayList<String> select(int limit){
        String sql = "SELECT * FROM (SELECT *  FROM  QueueMemUsedCountJson ORDER BY id desc limit "+limit+" ) t ORDER BY id;";
        final ArrayList<String> arrayList = new ArrayList<String>();

        JDBCHelper jdbcHelper = JDBCHelper.getInstance();
        //Object []  o = new Object[1];

        jdbcHelper.executeQuery(sql, null, new JDBCHelper.QueryCallback() {

            @Override
            public void process(ResultSet rs) throws Exception {
                while(rs.next()) {
                    String toJsonString = rs.getString(2);
                   arrayList.add(toJsonString);
                }
            }

        });

        return arrayList;

    }
}
