package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.NoSuchCommodityTypeUpdateHandlerError;

import static cn.xpbootcamp.gilded_rose.commodity.CommodityFactory.QUALITY_MAX;
import static cn.xpbootcamp.gilded_rose.commodity.CommodityFactory.QUALITY_MIN;

public class CommodityUpdateHandler {
    private static final int DEFAULT_QUALITY_DROP_VALUE = 1;

    public static void updateCommodity(Commodity commodity) {
        switch (commodity.getType()) {
            case GENERAL:
                updateGeneralCommodity(commodity);
                break;
            case COLLECTABLE:
                updateCollectableCommodity(commodity);
                break;
            default:
                throw new NoSuchCommodityTypeUpdateHandlerError(commodity.getType());
        }
    }

    private static void updateCollectableCommodity(Commodity commodity) {
        updateCollectableCommodityQuality(commodity);
        updateSellInValue(commodity);
    }

    private static void updateCollectableCommodityQuality(Commodity commodity) {
        int newQuality = commodity.getQuality() + DEFAULT_QUALITY_DROP_VALUE;
        if (newQuality > QUALITY_MAX) {
            newQuality = QUALITY_MAX;
        }
        commodity.setQuality(newQuality);
    }

    private static void updateGeneralCommodity(Commodity commodity) {
        updateGeneralCommodityQuality(commodity);
        updateSellInValue(commodity);
    }

    private static void updateGeneralCommodityQuality(Commodity commodity) {
        int newQuality = commodity.getQuality();
        if (commodity.getSellIn() > 0) {
            newQuality -= DEFAULT_QUALITY_DROP_VALUE;
        } else {
            newQuality -= DEFAULT_QUALITY_DROP_VALUE * 2;
        }

        if (newQuality < QUALITY_MIN) {
            newQuality = QUALITY_MIN;
        }
        commodity.setQuality(newQuality);
    }

    private static void updateSellInValue(Commodity commodity) {
        commodity.setSellIn(commodity.getSellIn() - 1);
    }
}
