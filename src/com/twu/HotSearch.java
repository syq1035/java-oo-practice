package com.twu;

public class HotSearch {
    private String description;
    private int votes;
    //购买的排名
    private int rank;
    //购买的价钱
    private int price;
    private boolean isSuperHotSearch;

    public HotSearch(String description, boolean isSuperHotSearch) {
        this.description = description;
        this.isSuperHotSearch = isSuperHotSearch;
        this.votes = 0;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSuperHotSearch() {
        return isSuperHotSearch;
    }

    public void setSuperHotSearch(boolean superHotSearch) {
        isSuperHotSearch = superHotSearch;
    }
}
