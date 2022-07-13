package com.example.test3.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.test3.model.CommonItemsModel

class ProfileUtil(
    private val oldList: List<CommonItemsModel>,
    private val newList: List<CommonItemsModel>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize()= newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].name == newList[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when{
            oldList[oldItemPosition].name != newList[newItemPosition].name ->{
                false
            }

            oldList[oldItemPosition].language != newList[newItemPosition].language ->{
                false
            }

            oldList[oldItemPosition].startIcon != newList[newItemPosition].startIcon ->{
                false
            }

            oldList[oldItemPosition].endIcon != newList[newItemPosition].endIcon ->{
                false
            }
            else -> true
        }
    }

}