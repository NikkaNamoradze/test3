package com.example.test3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test3.databinding.LanguageItemBinding
import com.example.test3.databinding.ProfileItemsBinding
import com.example.test3.model.CommonItemsModel
import com.example.test3.utils.ProfileUtil

class ProfileAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //ორი სხვადასხვა ვიუ გავაკეთე რადგან ენების ველზე იყო დამატებითი ერთი textView
    //და მაგიტომ შევქმენი მოდელი დეითა კლასი სადაც ის ერთი ტექსტვიუ მაქვს როგორც ნალი და საჭირო დროს
    //როცა მჭირდება ენების ველზე ენის მითითება მაშინ ვუსეტაბ რაიმე ტექსტს

    companion object {
        private const val COMMON_ITEMS = 1
        private const val LANGUAGE_ITEMS = 2
    }

    private var optionsList = mutableListOf<CommonItemsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == COMMON_ITEMS) {
            CommonItemsViewHolder(
                ProfileItemsBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            LanguageItemsViewHolder(
                LanguageItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CommonItemsViewHolder) {
            holder.onBind()
        } else if (holder is LanguageItemsViewHolder) {
            holder.onBind()
        }
    }

    override fun getItemCount() = optionsList.size

    override fun getItemViewType(position: Int): Int {
        return if (optionsList[position].language != null) COMMON_ITEMS else LANGUAGE_ITEMS
    }

    inner class CommonItemsViewHolder(private val binding: ProfileItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: CommonItemsModel

        fun onBind() {
            model = optionsList[adapterPosition]
            binding.startIcon.setImageResource(model.startIcon)
            binding.optionText.text = model.name
            model.endIcon?.let { binding.endIcon.setImageResource(it) }

        }
    }


    inner class LanguageItemsViewHolder(private val binding: LanguageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: CommonItemsModel
        fun onBind() {
            model = optionsList[adapterPosition]
            binding.startIcon.setImageResource(model.startIcon)
            binding.optionText.text = model.name
            binding.language.text = model.language
            model.endIcon?.let { binding.endIcon.setImageResource(it) }
        }
    }

    fun setData(data: MutableList<CommonItemsModel>){
        val diffUtil = ProfileUtil(optionsList,data)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        optionsList = data
        diffResults.dispatchUpdatesTo(this)
    }
}