package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;
import org.junit.jupiter.api.Test;

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
}
