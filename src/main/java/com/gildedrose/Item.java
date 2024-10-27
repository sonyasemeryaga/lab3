package com.gildedrose;

public class Item {

    public String name;

    public ItemSellInQuality itemSellInQuality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.itemSellInQuality = new ItemSellInQuality(sellIn, quality);
    }

    protected void zeroQuality() {
        itemSellInQuality.quality = 0;
    }

    protected void decreaseSellInForNotSulfuras() {
        itemSellInQuality.sellIn -= 1;
    }

    protected void increaseQuality() {
        if (itemSellInQuality.quality < 50) {
            itemSellInQuality.quality += 1;
        }
    }

    protected void decreaseQuality() {
        if (itemSellInQuality.quality > 0) {
            itemSellInQuality.quality -= 1;
        }
    }

    protected void updateItem() {
        decreaseQuality();
        decreaseSellInForNotSulfuras();
        if (itemSellInQuality.sellIn < 0) decreaseQuality();
    }

   @Override
   public String toString() {
        return this.name + ", " + itemSellInQuality.sellIn + ", " + itemSellInQuality.quality;
    }
}
