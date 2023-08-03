package com.AutomaticalEchoes.EquipSuit.api.modInterfcae.equipsuit;

import com.AutomaticalEchoes.EquipSuit.api.config.EquipSlotConfig;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface EquipSuit<T extends EquipSuit<T>> {
    NonNullList<Integer> SLOTS_NUMS = toList(EquipSlotConfig.EQUIP_SLOT_LIST.get());
    int SIZE =SLOTS_NUMS.size();
    void save();
    T build();
    static EquipSuitImpl defaultEquipSuit(CompoundTag tag){
        return new EquipSuitImpl(tag);
    }
    default NonNullList<Integer> getSlotsNums(){
        return SLOTS_NUMS;
    }
    NonNullList<ItemStack> getSlotItems() ;

    default CompoundTag defaultSave(CompoundTag tag){
        CompoundTag armorsTag= tag.contains("equips") ? tag.getCompound("equips") : new CompoundTag();
        ContainerHelper.saveAllItems(armorsTag,getSlotItems());
        tag.put("equips",armorsTag);
        return tag;
    }

    default int getSize(){
        return SIZE;
    }

    private static NonNullList<Integer> toList(List<? extends Integer> list){
        NonNullList<Integer> nonNullList = NonNullList.withSize(list.size(), 64);
        for (int i = 0; i < list.size(); i++) {
            nonNullList.set(i,list.get(i));
        }
        return nonNullList;
    }
}
