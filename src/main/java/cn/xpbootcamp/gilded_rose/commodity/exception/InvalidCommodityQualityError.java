package cn.xpbootcamp.gilded_rose.commodity.exception;

public class InvalidCommodityQualityError extends RuntimeException {
    public InvalidCommodityQualityError(String message) {
        super(message);
    }
}
