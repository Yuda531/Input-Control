package id.utb.pertemuan5

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private var tahun: Int = 0
    private var bulan: Int = 0
    private var tanggal: Int = 0
    private var tahun2: Int = 0
    private var bulan2: Int = 0
    private var tanggal2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val iniNama: EditText = findViewById(R.id.iniNama)
        val iniJenisKelamin: RadioGroup = findViewById(R.id.iniJenisKelamin)
        val iniNoHandphone: EditText = findViewById(R.id.iniNoHandphone)
        val iniTanggal: EditText = findViewById(R.id.iniTanggal)
        val iniRute: RadioGroup = findViewById(R.id.iniRute)
        val btnTanggal: Button = findViewById(R.id.btnTanggal)
        val btnDaftar: Button = findViewById(R.id.btnDaftar)

        btnTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            tahun = calendar.get(Calendar.YEAR)
            bulan = calendar.get(Calendar.MONTH)
            tanggal = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                tahun = year
                bulan = month
                tanggal = dayOfMonth

                iniTanggal.setText("$tanggal - ${bulan + 1} - $tahun")
            }, tahun, bulan, tanggal)
            dialog.show()
        }

        iniTanggal.setOnClickListener {
            val calendar = Calendar.getInstance()
            tahun2 = calendar.get(Calendar.YEAR)
            bulan2 = calendar.get(Calendar.MONTH)
            tanggal2 = calendar.get(Calendar.DAY_OF_MONTH)

            val dialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                tahun2 = year
                bulan2 = month
                tanggal2 = dayOfMonth

                iniTanggal.setText("$tanggal2 - ${bulan2 + 1} - $tahun2")
            }, tahun2, bulan2, tanggal2)
            dialog.show()
        }

        btnDaftar.setOnClickListener {
            val nama = iniNama.text.toString()
            val jenisKelamin = if (iniJenisKelamin.checkedRadioButtonId == R.id.iniPria) "Pria" else "Wanita"
            val noHp = iniNoHandphone.text.toString()
            val tanggal = iniTanggal.text.toString()
            val rute = if (iniRute.checkedRadioButtonId == R.id.iniJakartaBandung) "Jakarta - Bandung" else "Bandung - Jakarta"

            val dialog = AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah data yang kamu isikan sudah benar?")
                .setPositiveButton("Iya") { _, _ ->
                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putExtra("NAMA", nama)
                    intent.putExtra("JENIS_KELAMIN", jenisKelamin)
                    intent.putExtra("NO_HP", noHp)
                    intent.putExtra("TANGGAL", tanggal)
                    intent.putExtra("RUTE", rute)
                    startActivity(intent)
                }
                .setNegativeButton("Batal", null)
                .create()

            dialog.show()
        }
    }
}