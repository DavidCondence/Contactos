package partida.david.contactos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ver_contacto.*

class verContacto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_contacto)


        var bundle = intent.extras
        var imagen: Int = bundle.getInt("imagen")
        var nombre: String = intent.getStringExtra("nombre")
        var telefono: String = intent.getStringExtra("telefono")
        var correo: String = intent.getStringExtra("correo")
        var ciudad: String = intent.getStringExtra("ciudad")


        iv_pelicula.setImageResource(imagen)
        tv_nombre_v.text = nombre
        tv_telefono_v.text = "Telefono: "+telefono
        tv_correo_v.text = "Correo: "+correo
        tv_ciudad_v.text = "Ciudad: "+ciudad

        supportActionBar!!.title = nombre
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }
}
