package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;
import org.junit.jupiter.api.Test;

import static cn.xpbootcamp.gilded_rose.commodity.CommodityFactory.QUALITY_MAX;
import static cn.xpbootcamp.gilded_rose.commodity.CommodityType.COLLECTABLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CollectableCommodityTest {

    private static final String COMMODITY_NAME = "Aged Brie";

    @Test
    public void should_create_collectable_commodity_success() {
        Commodity commodity = CommodityFactory.createCollectableCommodity(COMMODITY_NAME, 2, 10);
        assertEquals(commodity.getName(), COMMODITY_NAME);
        assertEquals(commodity.getSellIn(), 2);
        assertEquals(commodity.getQuality(), 10);
        assertEquals(commodity.getType(), COLLECTABLE);
    }

    @Test
    public void should_create_collectable_commodity_failed() {
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createCollectableCommodity(COMMODITY_NAME, 2, -1));
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createCollectableCommodity(COMMODITY_NAME, 2, 52));
    }

    @Test
    public void should_update_collectable_commodity_stat_correct() {
        Commodity commodity = CommodityFactory.createCollectableCommodity(COMMODITY_NAME, 2, 30);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 1);
        assertEquals(commodity.getQuality(), 31);

        for (int i = 0; i < 50; i++) {
            commodity.updateStat();
        }
        assertEquals(commodity.getQuality(), QUALITY_MAX);
    }
}
