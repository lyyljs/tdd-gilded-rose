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

    @Test
    public void should_update_general_commodity_stat_correct() {
        Commodity commodity = CommodityFactory.createGeneralCommodity(DEFAULT_NAME, 1, 10);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 0);
        assertEquals(commodity.getQuality(), 9);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), -1);
        assertEquals(commodity.getQuality(), 7);

        for (int i = 0; i < 10; i++) {
            commodity.updateStat();
        }
        assertEquals(commodity.getQuality(), 0);
    }
}
