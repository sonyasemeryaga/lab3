package com.gildedrose;

public class Item {

    public String name;

    public ItemSellInQuality itemSellInQuality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.itemSellInQuality = new ItemSellInQuality(sellIn, quality);
    }

   @Override
   public String toString() {
        return this.name + ", " + itemSellInQuality.sellIn + ", " + itemSellInQuality.quality;
    }
}
