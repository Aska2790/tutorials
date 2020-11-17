package com.aska.development.mvvmkotlin.model;

data class AttributeValue(val name: String = "", val value: Int = 0) {
    override fun toString() = "$name: $value"
}