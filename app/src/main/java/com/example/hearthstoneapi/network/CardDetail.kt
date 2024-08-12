package com.example.hearthstoneapi.network

import kotlinx.serialization.Serializable

@Serializable
data class CardDetail(
    val cardId: String = "",
    val dbfId: Int = 0,
    val name: String = "",
    val cardSet: String = "",
    val type: String = "",
    val faction: String = "",
    val rarity: String = "",
    val cost: Int = 0,
    val attack: Int = 0,
    val health: Int = 0,
    val text: String = "",
    val flavor: String = "",
    val artist: String = "",
    val collectible : Boolean = false,
    val elite: Boolean = false,
    val race: String = "",
    val playerClass: String = "",
    val img: String = "",
    val imgGold: String = "",
    val locale: String = ""
)