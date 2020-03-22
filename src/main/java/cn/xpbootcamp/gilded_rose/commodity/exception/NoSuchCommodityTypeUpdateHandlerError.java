package cn.xpbootcamp.gilded_rose.commodity.exception;

import cn.xpbootcamp.gilded_rose.commodity.CommodityType;

public class NoSuchCommodityTypeUpdateHandlerError extends RuntimeException {
    public NoSuchCommodityTypeUpdateHandlerError(CommodityType type) {
        super("can not update commodity with type: " + type.name());
    }
}
