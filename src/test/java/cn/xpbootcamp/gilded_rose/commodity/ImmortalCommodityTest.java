package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;
import org.junit.jupiter.api.Test;

import static cn.xpbootcamp.gilded_rose.commodity.CommodityFactory.QUALITY_MIN;
import static cn.xpbootcamp.gilded_rose.commodity.CommodityType.IMMORTAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ImmortalCommodityTest {
    private static final String COMMODITY_NAME = "Sulfuras";

    @Test
    public void should_create_immortal_commodity_success() {
        Commodity commodity = CommodityFactory.createImmortalCommodity(COMMODITY_NAME, 2, 10);
        assertEquals(commodity.getName(), COMMODITY_NAME);
        assertEquals(commodity.getSellIn(), 2);
        assertEquals(commodity.getQuality(), 10);
        assertEquals(commodity.getType(), IMMORTAL);
    }

    @Test
    public void should_create_immortal_commodity_failed() {
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createImmortalCommodity(COMMODITY_NAME, 2, -1));
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createImmortalCommodity(COMMODITY_NAME, 2, 52));
    }

    @Test
    public void should_update_immortal_commodity_stat_correct() {
        int quality = 10;
        Commodity commodity = CommodityFactory.createImmortalCommodity(COMMODITY_NAME, 1, quality);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 0);
        assertEquals(commodity.getQuality(), quality);

        for (int i = 0; i < 10; i++) {
            commodity.updateStat();
            assertEquals(commodity.getQuality(), quality);
        }
    }
}
