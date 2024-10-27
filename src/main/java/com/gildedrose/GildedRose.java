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
                if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    decreaseQuality(item.itemSellInQuality);
                }
            } else {
                increaseQuality(item.itemSellInQuality);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.itemSellInQuality.sellIn < 11) {
                            increaseQuality(item.itemSellInQuality);
                        }

                        if (item.itemSellInQuality.sellIn < 6) {
                            increaseQuality(item.itemSellInQuality);
                        }
                    }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.itemSellInQuality.sellIn = item.itemSellInQuality.sellIn - 1;
            }

            if (item.itemSellInQuality.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality(item.itemSellInQuality);
                        }
                    } else {
                        item.itemSellInQuality.quality = 0;
                    }
                } else {
                    increaseQuality(item.itemSellInQuality);
                }
            }
        }
    }

    private void increaseQuality(ItemSellInQuality itemSellInQuality) {
        if (itemSellInQuality.quality < 50) {
            itemSellInQuality.quality += 1;
        }
    }

    private void decreaseQuality(ItemSellInQuality itemSellInQuality) {
        if (itemSellInQuality.quality > 0) {
            itemSellInQuality.quality -= 1;
        }
    }
}
