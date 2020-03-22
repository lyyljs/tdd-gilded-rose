package cn.xpbootcamp.gilded_rose.commodity;

public class Commodity {
    private String name;
    private int sellIn;
    private int quality;
    private CommodityType type;

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public CommodityType getType() {
        return type;
    }
}
