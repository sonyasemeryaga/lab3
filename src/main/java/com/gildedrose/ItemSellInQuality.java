package com.gildedrose;

public class ItemSellInQuality {

    public int sellIn;

    public int quality;

    public ItemSellInQuality(int sellIn, int quality) {
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void zeroQuality() {
        this.quality = 0;
    }

    public void decreaseSellInForNotSulfuras() {
        this.sellIn -= 1;
    }

    public void increaseQuality() {
        if (this.quality < 50) {
            this.quality += 1;
        }
    }

    public void decreaseQuality() {
        if (this.quality > 0) {
            this.quality -= 1;
        }
    }
}
