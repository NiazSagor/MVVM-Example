package com.duodevloopers.myapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

class InputAdapter : RecyclerView.Adapter<InputAdapter.InputViewHolder>() {

    //private var persons: MutableList<Person> = ArrayList()

    private var counter : Int = 1

    private var click: MutableLiveData<Int> = MutableLiveData()


    init {
//        persons.add(
//            Person(0, "", 0)
//        )

        //click.value = 0


    }

    class InputViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: EditText = itemView.findViewById(R.id.name)
        val age: EditText = itemView.findViewById(R.id.age)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InputViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.input_item, parent, false)
        return InputViewHolder(view)
    }

    override fun onBindViewHolder(holder: InputViewHolder, position: Int) {

//        click.observeForever(Observer {
//            Log.i("Adapter", holder.name.text.toString())
//
//
//            persons.add(Person(0, "", 0))
//
//
//        })
    }

    override fun getItemCount(): Int {
        return counter
    }

    fun onAddClick() {
        counter++
        notifyDataSetChanged()
        //click.value = click.value?.plus(1)
        //notifyDataSetChanged()
    }


}