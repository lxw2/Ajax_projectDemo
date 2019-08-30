package userinfo;


import JDBCutils.jdbcutils;

public class demo {

    public static void main(String[] args) {
        userInfo user= jdbcutils.getUserinfo("宁玲珑");
        System.out.println(user);

    }
}
