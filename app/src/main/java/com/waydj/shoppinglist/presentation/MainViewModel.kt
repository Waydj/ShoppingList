package com.waydj.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.waydj.shoppinglist.data.ShopListRepositoryImpl
import com.waydj.shoppinglist.domain.DeleteShopItemUseCase
import com.waydj.shoppinglist.domain.EditShopItemUseCase
import com.waydj.shoppinglist.domain.GetShopListUseCase
import com.waydj.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun changeEnableState(shopItem: ShopItem) {
        val newShopItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newShopItem)
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
}