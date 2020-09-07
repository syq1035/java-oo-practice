package com.twu;

public class Menu {

    public static void startMenu() {
        System.out.println(" 欢迎来到热搜排行榜，你是？ ");
        System.out.println(" 1.用户 ");
        System.out.println(" 2.管理员 ");
        System.out.println(" 3.退出 ");
    }

    public static void userMenu(String username) {
        System.out.println("您好，" + username + "，您可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.给热搜事件投票");
        System.out.println("3.购买热搜");
        System.out.println("4.添加热搜");
        System.out.println("5.退出");
    }

    public static void adminMenu(String adminName) {
        System.out.println("您好，" + adminName + "，您可以：");
        System.out.println("1.查看热搜排行榜");
        System.out.println("2.添加热搜");
        System.out.println("3.添加超级热搜");
        System.out.println("4.退出");
    }
}
