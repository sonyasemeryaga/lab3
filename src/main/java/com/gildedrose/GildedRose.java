package com.gildedrose;

import java.util.List;

class GildedRose {
    Item[] items;

    private static final List<String> SPECIAL_ITEMS = List.of(
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert",
            "Sulfuras, Hand of Ragnaros"
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            String name = item.name;
            if (!isSpecialItem(name)) {
                decreaseQuality(item.itemSellInQuality);
            } else {
                increaseQuality(item.itemSellInQuality);

                    if (name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.itemSellInQuality.sellIn < 11) {
                            increaseQuality(item.itemSellInQuality);
                        }

                        if (item.itemSellInQuality.sellIn < 6) {
                            increaseQuality(item.itemSellInQuality);
                        }
                    }
            }

            decreaseSellInForNotSulfuras(item.itemSellInQuality, name);

            if (item.itemSellInQuality.sellIn < 0) {
                if (!name.equals("Aged Brie")) {
                    if (!name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
                            decreaseQuality(item.itemSellInQuality);
                        }
                    } else {
                        zeroQuality(item.itemSellInQuality);
                    }
                } else {
                    increaseQuality(item.itemSellInQuality);
                }
            }
        }
    }

    private boolean isSpecialItem(String name) {
        return SPECIAL_ITEMS.contains(name);
    }

    private void zeroQuality(ItemSellInQuality itemSellInQuality) {
        itemSellInQuality.quality = 0;
    }

    private void decreaseSellInForNotSulfuras(ItemSellInQuality itemSellInQuality, String name) {
        if (!name.equals("Sulfuras, Hand of Ragnaros")) {
            itemSellInQuality.sellIn -= 1;
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
