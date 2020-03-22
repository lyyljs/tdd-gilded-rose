package cn.xpbootcamp.gilded_rose.commodity;

public class Commodity {
    private String name;
    private int sellIn;
    private int quality;
    private CommodityType type;

    Commodity(String name, int sellIn, int quality, CommodityType type){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.type = type;
    }

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
