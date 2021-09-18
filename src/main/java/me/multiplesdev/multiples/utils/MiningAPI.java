package me.multiplesdev.multiples.utils;

import me.multiplesdev.multiples.Multiples;

public class MiningAPI {

    private int level;
    private int xp;
    private int progress;
    private int blocksMined;

    private boolean hasCoal;
    private boolean hasIron;
    private boolean hasGold;
    private boolean hasLapis;
    private boolean hasRedstone;
    private boolean hasDiamond;
    private boolean hasEmerald;
    private boolean hasNetherGold;
    private boolean hasGildedBlackstone;

    static Multiples plugin;

    public MiningAPI (int level, int xp, int progress, int blocksMined) {
        this.level = level;
        this.xp = xp;
        this.progress = progress;
        this.blocksMined = blocksMined;
    }

    // Mining Data
    public int getLevel() { return level; }

    public int getXp() { return xp; }

    public int getProgress() { return progress; }

    public int getBlocksMined() { return blocksMined; }

    public void setLevel(int level) { this.level = level; }

    public void setXp(int xp) { this.xp = xp; }

    public void setProgress(int progress) {
        int xpNeeded = plugin.getConfig().getInt("Levels." + this.level + ".xp");
        this.progress = (this.xp / xpNeeded * 100);
    }

}
