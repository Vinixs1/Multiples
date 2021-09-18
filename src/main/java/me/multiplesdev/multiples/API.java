package me.multiplesdev.multiples;


public class API {

    private int level;
    private int xp;
    private int catchTotal;

    public API (int level, int xp, int catchTotal) {
        this.level = level;
        this.xp = xp;
        this.catchTotal = catchTotal;
    }

    // Fishing Data
    public int getLevel() { return level; }

    public int getXp() { return xp; }

    public int getCatchTotal() { return catchTotal; }

    public void setLevel(int level) { this.level = level; }

    public void setXp(int xp) { this.xp = xp; }

    public void setCatchTotal(int catchTotal) { this.catchTotal = catchTotal; }

}
