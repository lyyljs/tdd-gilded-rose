package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;

public class CommodityFactory {

    public static final int QUALITY_MIN = 0;
    public static final int QUALITY_MAX = 50;

    public static Commodity createGeneralCommodity(String name, int sellIn, int quality) {
        return createCommodity(name, sellIn, quality, CommodityType.GENERAL);
    }

    public static Commodity createCollectableCommodity(String name, int sellIn, int quality) {
        return createCommodity(name, sellIn, quality, CommodityType.COLLECTABLE);
    }

    public static Commodity createImmortalCommodity(String name, int sellIn, int quality) {
        return createCommodity(name, sellIn, quality, CommodityType.IMMORTAL);
    }

    public static Commodity createTicketCommodity(String name, int sellIn, int quality) {
        return createCommodity(name, sellIn, quality, CommodityType.TICKET);
    }

    private static Commodity createCommodity(String name, int sellIn, int quality, CommodityType type) {
        checkQuality(quality);
        return new Commodity(name, sellIn, quality, type);
    }

    private static void checkQuality(int quality) {
        if (quality < QUALITY_MIN || quality > QUALITY_MAX) {
            throw new InvalidCommodityQualityError("quality value should in [0, 50], now quality = " + quality);
        }
    }

}
