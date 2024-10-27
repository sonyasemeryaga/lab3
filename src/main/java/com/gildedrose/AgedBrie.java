package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateItem() {
        increaseQuality();
        decreaseSellInForNotSulfuras();
        if (itemSellInQuality.sellIn < 0) increaseQuality();
    }
}
