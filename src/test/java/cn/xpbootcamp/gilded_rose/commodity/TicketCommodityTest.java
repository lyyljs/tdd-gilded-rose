package cn.xpbootcamp.gilded_rose.commodity;

import cn.xpbootcamp.gilded_rose.commodity.exception.InvalidCommodityQualityError;
import org.junit.jupiter.api.Test;

import static cn.xpbootcamp.gilded_rose.commodity.CommodityType.TICKET;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketCommodityTest {
    private static final String COMMODITY_NAME = "Backstage pass";

    @Test
    public void should_create_ticket_commodity_success() {
        Commodity commodity = CommodityFactory.createTicketCommodity(COMMODITY_NAME, 2, 10);
        assertEquals(commodity.getName(), COMMODITY_NAME);
        assertEquals(commodity.getSellIn(), 2);
        assertEquals(commodity.getQuality(), 10);
        assertEquals(commodity.getType(), TICKET);
    }

    @Test
    public void should_create_ticket_commodity_failed() {
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createTicketCommodity(COMMODITY_NAME, 2, -1));
        assertThrows(InvalidCommodityQualityError.class, () -> CommodityFactory.createTicketCommodity(COMMODITY_NAME, 2, 52));
    }

    @Test
    public void should_update_ticket_commodity_stat_correct() {
        int quality = 30;
        int sellIn = 11;
        Commodity commodity = CommodityFactory.createTicketCommodity(COMMODITY_NAME, sellIn, quality);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 10);
        assertEquals(commodity.getQuality(), 31);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 9);
        assertEquals(commodity.getQuality(), 33);

        for (int i = 0; i < 4; i++) {
            commodity.updateStat();
        }
        assertEquals(commodity.getQuality(), 41);

        commodity.updateStat();
        assertEquals(commodity.getSellIn(), 4);
        assertEquals(commodity.getQuality(), 44);

        for (int i = 0; i < 5; i++) {
            commodity.updateStat();
        }
        assertEquals(commodity.getQuality(), 0);
    }
}
