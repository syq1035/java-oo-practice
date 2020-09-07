package com.twu;

import java.util.Scanner;

public class Main {
    private static Scanner scanner;
    private static String inputChoose;
    private static HotSearchList hotSearchList;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        hotSearchList = new HotSearchList();

        while (true) {
            Menu.startMenu();
            inputChoose = scanner.next();
            switch (inputChoose) {
                case "1":
                    user();
                    break;
                case "2":
                    admin();
                    break;
                case "3":
                    return;
            }
        }
    }

    public static void user() {
        System.out.println("请输入您的昵称：");
        String username = scanner.next();
        User user = new User(username);
        while (true) {
            Menu.userMenu(username);
            inputChoose = scanner.next();
            switch (inputChoose) {
                case "1":
                    hotSearchList.showHotSearchList();
                    break;
                case "2":
                    if (hotSearchList.isEmptyList()) {
                        System.out.println("热搜榜暂时为空, 不能投票");
                        break;
                    }
                    if (user.getVotes() == 0) {
                        System.out.println("您的票数已用完");
                        break;
                    }
                    System.out.println("请输入要投票的热搜名称：");
                    String desc = scanner.next();
                    System.out.println("请输入您要投的热搜票数（您目前还有" + user.getVotes() + "票）：");
                    int votes = Integer.parseInt(scanner.next());
                    if (votes > user.getVotes()) {
                        System.out.println("您的票数不够，投票失败");
                    } else {
                        hotSearchList.vote(desc, votes);
                        user.setVotes(user.getVotes() - votes);
                        System.out.println("投票成功");
                    }
                    break;
                case "3":
                    if (hotSearchList.isEmptyList()) {
                        System.out.println("热搜榜暂时为空, 不能购买");
                        break;
                    }
                    System.out.println("请输入您要购买的热搜名称：");
                    String buy = scanner.next();
                    System.out.println("请输入您要购买的热搜排名：");
                    int rank = Integer.parseInt(scanner.next());
                    System.out.println("请输入您要购买的热搜金额：");
                    int price = Integer.parseInt(scanner.next());
                    hotSearchList.buyHotSearch(buy, rank, price);
                    break;
                case "4":
                    System.out.println("请输入热搜名称：");
                    String description = scanner.next();
                    hotSearchList.addHotSearch(description, false);
                    break;
                case "5":
                    return;
                default:
                    System.out.println("选择无效，请重新输入！");
            }
        }
    }

    public static void admin() {
        System.out.println("请输入您的昵称");
        String username = new Scanner(System.in).next();
        System.out.println("请输入您的密码");
        String password = new Scanner(System.in).next();
        Admin admin = new Admin();
        if (!admin.verify(username, password)) {
            System.out.println("用户名或密码输入错误");
            return;
        }

        while (true) {
            Menu.adminMenu(username);
            inputChoose = new Scanner(System.in).next();
            switch (inputChoose) {
                case "1":
                    hotSearchList.showHotSearchList();
                    break;
                case "2":
                    System.out.println("请输入热搜名称：");
                    String desc = scanner.next();
                    hotSearchList.addHotSearch(desc, false);
                    break;
                case "3":
                    System.out.println("请输入热搜名称：");
                    String description = scanner.next();
                    hotSearchList.addHotSearch(description, true);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("选择无效，请重新输入！");
            }
        }
    }
}
