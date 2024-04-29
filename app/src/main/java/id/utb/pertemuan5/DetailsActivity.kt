package id.utb.pertemuan5

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val nama = intent.getStringExtra("NAMA")
        val jenisKelamin = intent.getStringExtra("JENIS_KELAMIN")
        val noHp = intent.getStringExtra("NO_HP")
        val tanggal = intent.getStringExtra("TANGGAL")
        val rute = intent.getStringExtra("RUTE")

        val iniNama2: TextView = findViewById(R.id.iniNama2)
        val iniJenisKelamin2: TextView = findViewById(R.id.iniJenisKelamin2)
        val iniNoHp2: TextView = findViewById(R.id.iniNoHp2)
        val iniTanggal2: TextView = findViewById(R.id.iniTanggal2)
        val iniRute2: TextView = findViewById(R.id.iniRute2)

        iniNama2.text = "Nama                   : $nama"
        iniJenisKelamin2.text = "Jenis Kelamin    : $jenisKelamin"
        iniNoHp2.text = "No. Handphone : $noHp"
        iniTanggal2.text = "Tanggal                : $tanggal"
        iniRute2.text = "Rute                      : $rute"
    }

}