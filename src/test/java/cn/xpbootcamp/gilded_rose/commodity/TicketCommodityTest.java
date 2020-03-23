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
}
