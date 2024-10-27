package com.gildedrose;

public class Item {

    public String name;

    public ItemSellInQuality itemSellInQuality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.itemSellInQuality = new ItemSellInQuality(sellIn, quality);
    }

    private void zeroQuality() {
        itemSellInQuality.quality = 0;
    }

    private void decreaseSellInForNotSulfuras() {
        itemSellInQuality.sellIn -= 1;
    }

    private void increaseQuality() {
        if (itemSellInQuality.quality < 50) {
            itemSellInQuality.quality += 1;
        }
    }

    private void decreaseQuality() {
        if (itemSellInQuality.quality > 0) {
            itemSellInQuality.quality -= 1;
        }
    }

   @Override
   public String toString() {
        return this.name + ", " + itemSellInQuality.sellIn + ", " + itemSellInQuality.quality;
    }
}
