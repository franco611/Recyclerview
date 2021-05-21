package com.uvg.listas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var agregar: Button
    var cont =3

    private val adaptador = Adaptador({
        clickListener -> showItemClick(clickListener)
    },
            {
                longClickListener -> changeItemClick(longClickListener)
            })
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        agregar = findViewById(R.id.button2)

        var items: MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setItems(items)

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador

        agregar.setOnClickListener {
            cont ++
            items.add("Prueba "+cont)
            adaptador.setItems(items)
        }

    }

    fun showItemClick(position: Int){
        val item = adaptador.getItem(position)
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()
        adaptador.borrarItem(position)
    }

    fun changeItemClick(position: Int){
        adaptador.cambioItem(position)
    }










}