package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotSearchList {
    private List<HotSearch> hotSearchList = new ArrayList<>();

    public void addHotSearch(String description, boolean isSuperHotSearch) {
        boolean isPresent = hotSearchList.stream().filter((hs -> hs.getDescription() == description)).findFirst().isPresent();
        if (isPresent) {
            System.out.println("该热搜已存在，无需重复添加");
        } else {
            hotSearchList.add(new HotSearch(description, isSuperHotSearch));
            System.out.println("添加成功");
        }
    }

    public void vote(String description, int votes) {
        for (HotSearch hotSearch : hotSearchList) {
            if (hotSearch.getDescription().equals(description)) {
                if (hotSearch.isSuperHotSearch()) {
                    hotSearch.setVotes(hotSearch.getVotes() + votes*2);
                } else {
                    hotSearch.setVotes(hotSearch.getVotes() + votes);
                }
                return;
            }
        }
    }

    public void showHotSearchList() {
        if (hotSearchList.size() == 0) {
            System.out.println("热搜榜暂时为空");
            return;
        }

        List<HotSearch> sortList = hotSearchList.stream().filter(h -> h.getRank() == 0).sorted(new Comparator<HotSearch>() {
            @Override
            public int compare(HotSearch o1, HotSearch o2) {
                return o2.getVotes() - o1.getVotes();
            }
        }).collect(Collectors.toList());
        hotSearchList.stream().filter(h -> h.getRank() > 0).forEach(h -> sortList.add(h.getRank()-1, h));

        for (int index = 0; index < sortList.size(); index++) {
            HotSearch hotSearch = sortList.get(index);
            System.out.println((index+1) + "." + hotSearch.getDescription() + "   " + hotSearch.getVotes());
        }
    }

    public void buyHotSearch(String buy, int rank, int price) {
        HotSearch buyHotSearch = null;
        HotSearch rankHotSearch = null;
        for (HotSearch hotSearch : hotSearchList) {
            if (hotSearch.getDescription().equals(buy)) {
                buyHotSearch = hotSearch;
            }
            if (hotSearch.getRank() == rank) {
                rankHotSearch = hotSearch;
            }
        }
        if (rankHotSearch == null) {
            buyHotSearch.setRank(rank);
            buyHotSearch.setPrice(price);
            System.out.println("购买成功");
        } else if (rankHotSearch.getPrice() < price) {
            hotSearchList.remove(rankHotSearch);
            buyHotSearch.setRank(rank);
            buyHotSearch.setPrice(price);
            System.out.println("购买成功");
        } else {
            System.out.println("金额不够，购买失败，需大于" + rankHotSearch.getPrice());
        }
    }

    public boolean isEmptyList() {
        if (hotSearchList.size() == 0) {
            return true;
        }
        return false;
    }
}
