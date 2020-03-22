package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;

public class CommodityFactory {

    public static final int QUALITY_MIN = 0;
    public static final int QUALITY_MAX = 50;

    public static Commodity createGeneralCommodity(String name, int sellIn, int quality) {
        checkQuality(quality);
        return new Commodity(name, sellIn, quality, CommodityType.GENERAL);
    }

    private static void checkQuality(int quality) {
        if (quality < QUALITY_MIN || quality > QUALITY_MAX) {
            throw new InvalidCommodityQualityError("quality value should in [0, 50], now quality = " + quality);
        }
    }
}
