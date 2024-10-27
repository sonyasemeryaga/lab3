package com.gildedrose;

public class BackstagePasses extends Item {

    public BackstagePasses(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateItem() {
        increaseQuality();
        decreaseSellInForNotSulfuras();
        if (itemSellInQuality.sellIn < 11) increaseQuality();
        if (itemSellInQuality.sellIn < 6) increaseQuality();
        if (itemSellInQuality.sellIn < 0) zeroQuality();
    }
}
