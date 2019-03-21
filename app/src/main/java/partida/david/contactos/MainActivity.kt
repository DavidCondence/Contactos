package partida.david.contactos

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.cotactoview.view.*

class MainActivity : AppCompatActivity() {
    var listaContactos = ArrayList<Contacto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        crearContacto()
        var adaptador = AdaptadorContacto(this,listaContactos)
        listview.adapter = adaptador

    }
    fun crearContacto(){

        var contacto1 = Contacto("Clark Kent", "1111111111", "superman@gmail.com", "Metropolis", R.drawable.uno)
        var contacto2 = Contacto("Arthur Curry", "222222222", "aquaman@gmail.com", "Atlantis", R.drawable.dos)
        var contacto3 = Contacto("Barry Allen", "3333333333", "flash@gmail.com", "Central city", R.drawable.tres)
        var contacto4 = Contacto("Diana Prince", "4444444444", "wonderwoman@gmail.com", "Themyscira", R.drawable.cuatro)
        var contacto5 = Contacto("Brunce Wayne", "555555555", "gmail@batman.com", "Gotham city", R.drawable.cinco)
        listaContactos.add(contacto1)
        listaContactos.add(contacto2)
        listaContactos.add(contacto3)
        listaContactos.add(contacto4)
        listaContactos.add(contacto5)
    }
    private class AdaptadorContacto:BaseAdapter{
        var contexto: Context? = null
        var contactos = ArrayList<Contacto>()

        constructor(context: Context, contactos: ArrayList<Contacto>){
            contexto = context
            this.contactos = contactos
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.cotactoview,null)
            var contacto = contactos[position]
            vista.ver_iv_contacto.setImageResource(contacto.imagen)
            vista.ver_tv_nombre.text = contacto.nombre
            vista.setOnClickListener{
                val intent = Intent(contexto, verContacto::class.java)
                intent.putExtra("imagen", contacto.imagen)
                intent.putExtra("nombre", contacto.nombre)
                intent.putExtra("telefono", contacto.telefono)
                intent.putExtra("correo", contacto.correo)
                intent.putExtra("ciudad", contacto.ciudad)
                contexto?.startActivity(intent)

            }
            return vista
        }

        override fun getItem(position: Int): Any {
            return contactos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return contactos.size
        }
    }
}
