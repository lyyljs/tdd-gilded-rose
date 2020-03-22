package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommodityTest {

    private static final String DEFAULT_NAME = "G1";

    @Test
    public void should_create_general_commodity_success() {
        int sellIn = 1;
        int quality = 10;
        Commodity commodity = CommodityFactory.createGeneralCommodity(DEFAULT_NAME, 1, 10);
        assertEquals(commodity.getName(), DEFAULT_NAME);
        assertEquals(commodity.getType(), CommodityType.GENERAL);
        assertEquals(commodity.getSellIn(), sellIn);
        assertEquals(commodity.getQuality(), quality);
    }

    @Test
    public void should_create_general_commodity_failed() {
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createGeneralCommodity(DEFAULT_NAME, 1, -1));
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createGeneralCommodity(DEFAULT_NAME, 1, 52));
    }
}
