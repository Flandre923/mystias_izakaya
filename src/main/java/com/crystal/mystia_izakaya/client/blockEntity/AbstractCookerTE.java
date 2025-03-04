package com.crystal.mystia_izakaya.client.blockEntity;

import com.crystal.mystia_izakaya.network.MealInfoPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class AbstractCookerTE extends RandomizableContainerBlockEntity {
    public int cookTime = 0;
    public boolean isCook = false;
    public boolean lit = false;
    NonNullList<ItemStack> items = NonNullList.withSize(7, ItemStack.EMPTY);

    protected AbstractCookerTE(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public static void serverTick(Level pLevel, BlockPos pPos, BlockState pState, AbstractCookerTE pBlockEntity) {
        if (pBlockEntity.lit) {
            pBlockEntity.lit = false;
            pBlockEntity.isCook = true;
            for (int i = 0; i < 5; i++) {
                pBlockEntity.items.set(i, ItemStack.EMPTY);
            }
            pState = pState.setValue(AbstractFurnaceBlock.LIT, true);
            pLevel.setBlock(pPos, pState, 3);
        }
        if (pBlockEntity.isCook) {
            pBlockEntity.cookTime--;
            if (pBlockEntity.cookTime <= 0) {
                pBlockEntity.isCook = false;
                pState = pState.setValue(AbstractFurnaceBlock.LIT, false);
                pLevel.setBlock(pPos, pState, 3);
                pBlockEntity.items.set(5, pBlockEntity.getItem(6));
                pBlockEntity.setItem(6, ItemStack.EMPTY);
                setChanged(pLevel, pPos, pState);
                PacketDistributor.sendToAllPlayers(new MealInfoPacket(0,pBlockEntity.items.stream().map(ItemStack::getItem).collect(Collectors.toCollection(ArrayList::new)),pPos));
            }
        }
    }

    @Override
    protected void loadAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(pTag)) {
            ContainerHelper.loadAllItems(pTag, this.items, pRegistries);
            pTag.putInt("CookTime", this.cookTime);
            pTag.putBoolean("IsCook", this.isCook);
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag pTag, HolderLookup.@NotNull Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        if (!this.trySaveLootTable(pTag)) {
            ContainerHelper.saveAllItems(pTag, this.items, pRegistries);
            pTag.putInt("CookTime", this.cookTime);
            pTag.putBoolean("IsCook", this.isCook);
        }
    }

    @Override
    @NotNull
    public NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> pItems) {
        this.items = pItems;
    }

    public void setItems(ArrayList<Item> pItems) {
        for (int i = 0; i < pItems.size(); i++) {
            this.setItem(i, pItems.get(i).getDefaultInstance());
        }
    }

    @Override
    public int getContainerSize() {
        return 7;
    }
}
