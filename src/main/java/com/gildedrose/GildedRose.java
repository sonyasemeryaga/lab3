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
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        String name = item.name;
        if (!isSpecialItem(name)) {
            updateUsualItems(item.itemSellInQuality);
            return;
        }
        updateBackstagePasses(item.itemSellInQuality, name);
        updateAgedBrie(item.itemSellInQuality, name);
    }

    private void updateUsualItems(ItemSellInQuality itemSellInQuality) {
        decreaseQuality(itemSellInQuality);
        decreaseSellInForNotSulfuras(itemSellInQuality);
        if (itemSellInQuality.sellIn < 0) {
            decreaseQuality(itemSellInQuality);
        }
    }

    private void updateAgedBrie(ItemSellInQuality itemSellInQuality, String name) {
        if (name.equals("Aged Brie")) return;
        increaseQuality(itemSellInQuality);
        decreaseSellInForNotSulfuras(itemSellInQuality);
        if (itemSellInQuality.sellIn < 0) increaseQuality(itemSellInQuality);
    }

    private void updateBackstagePasses(ItemSellInQuality itemSellInQuality, String name) {
        if (name.equals("Backstage passes to a TAFKAL80ETC concert")) return;
        increaseQuality(itemSellInQuality);
        decreaseSellInForNotSulfuras(itemSellInQuality);
        if (itemSellInQuality.sellIn < 11) increaseQuality(itemSellInQuality);
        if (itemSellInQuality.sellIn < 6) increaseQuality(itemSellInQuality);
        if (itemSellInQuality.sellIn < 0) zeroQuality(itemSellInQuality);
    }

    private boolean isSpecialItem(String name) {
        return SPECIAL_ITEMS.contains(name);
    }

    private void zeroQuality(ItemSellInQuality itemSellInQuality) {
        itemSellInQuality.quality = 0;
    }

    private void decreaseSellInForNotSulfuras(ItemSellInQuality itemSellInQuality) {
        itemSellInQuality.sellIn -= 1;
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
