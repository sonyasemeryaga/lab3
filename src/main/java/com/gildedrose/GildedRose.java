package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.itemSellInQuality.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        item.itemSellInQuality.quality = item.itemSellInQuality.quality - 1;
                    }
                }
            } else {
                if (item.itemSellInQuality.quality < 50) {
                    item.itemSellInQuality.quality = item.itemSellInQuality.quality + 1;

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.itemSellInQuality.sellIn < 11) {
                            if (item.itemSellInQuality.quality < 50) {
                                item.itemSellInQuality.quality = item.itemSellInQuality.quality + 1;
                            }
                        }

                        if (item.itemSellInQuality.sellIn < 6) {
                            if (item.itemSellInQuality.quality < 50) {
                                item.itemSellInQuality.quality = item.itemSellInQuality.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.itemSellInQuality.sellIn = item.itemSellInQuality.sellIn - 1;
            }

            if (item.itemSellInQuality.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.itemSellInQuality.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                item.itemSellInQuality.quality = item.itemSellInQuality.quality - 1;
                            }
                        }
                    } else {
                        item.itemSellInQuality.quality = item.itemSellInQuality.quality - item.itemSellInQuality.quality;
                    }
                } else {
                    if (item.itemSellInQuality.quality < 50) {
                        item.itemSellInQuality.quality = item.itemSellInQuality.quality + 1;
                    }
                }
            }
        }
    }
}
