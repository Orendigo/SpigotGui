package me.killje.spigotgui.character;

import me.killje.spigotgui.guielement.GuiElement;
import me.killje.spigotgui.util.GuiSetting;
import me.killje.spigotgui.util.InventoryUtil;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Patrick Beuks (killje) <patrick.beuks@gmail.com>
 */
public abstract class SetStringButton implements GuiElement {

    private KeyBoardStringStorage keyBoardStringStorage;

    protected KeyBoardStringStorage getKeyBoardStringStorage() {
        return keyBoardStringStorage;
    }

    public void setKeyBoardStringStorage(KeyBoardStringStorage keyBoardStringStorage) {
        this.keyBoardStringStorage = keyBoardStringStorage;
    }

    @Override
    public void onInventoryClickEvent(InventoryUtil currentInventoryUtils, InventoryClickEvent event) {
        if (keyBoardStringStorage.getCurrent().equals("")) {
            event.getWhoClicked().sendMessage(textForEmpty(currentInventoryUtils.getGuiSettings()));
            return;
        }
        executeSet(currentInventoryUtils, event);
    }

    @Override
    public ItemStack getItemStack(GuiSetting guiSettings) {
        if (keyBoardStringStorage.getCurrent().equals("")) {
            return noNameYetItem(guiSettings);
        }
        return confirmItem(guiSettings);
    }

    protected abstract ItemStack confirmItem(GuiSetting guiSettings);

    protected abstract ItemStack noNameYetItem(GuiSetting guiSettings);

    protected abstract String textForEmpty(GuiSetting guiSettings);

    protected abstract void executeSet(InventoryUtil currentInventoryUtils, InventoryClickEvent event);
}
