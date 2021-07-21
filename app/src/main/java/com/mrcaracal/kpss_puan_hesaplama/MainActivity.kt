package com.mrcaracal.kpss_puan_hesaplama

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mrcaracal.kpss_puan_hesaplama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val calc = Calculation()
        var status = "memur"
        var p3_puan: Double = 0.0
        var p10_puan: Double = 0.0
        var p121_puan: Double = 0.0
        var itemStatu: String = "Türkçe"
        val spinners = arrayOf(
            "Türkçe",
            "Matematik (İlköğretim)",
            "Fen Bilimleri ve Teknoloji",
            "Sosyal Bilimler",
            "Türk Dili ve Edebiyatı",
            "Tarih",
            "Coğrafya",
            "Matematik (Lise)",
            "Fizik",
            "Kimya",
            "Biyoloji",
            "Din Kültürü ve Ahlak Bilgisi",
            "Yabancı Dil (İngilizce)",
            "Rehber Öğretmen",
            "Sınıf Öğretmenliği",
            "Okul Öncesi Öğretmenliği",
        )
        binding.spLisansOabt.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spinners)

        binding.cbMemur.setOnClickListener {
            if (binding.cbMemur.isChecked) {
                binding.cbOgretmen.isChecked = false
                binding.cbOabt.isChecked = false
                binding.llEgitimBilimleri.visibility = View.GONE
                binding.llOabt.visibility = View.GONE
                status = "memur"
            }
        }

        binding.cbOgretmen.setOnClickListener {
            if (binding.cbOgretmen.isChecked) {
                binding.cbMemur.isChecked = false
                binding.cbOabt.isChecked = false
                binding.llEgitimBilimleri.visibility = View.VISIBLE
                binding.llOabt.visibility = View.GONE
                status = "ogretmen"
            }
        }

        binding.cbOabt.setOnClickListener {
            if (binding.cbOabt.isChecked) {
                binding.cbMemur.isChecked = false
                binding.cbOgretmen.isChecked = false
                binding.llEgitimBilimleri.visibility = View.VISIBLE
                binding.llOabt.visibility = View.VISIBLE
                status = "oabt"
            }
        }

        binding.btnLisansHesapla.setOnClickListener {
            if (binding.edtLisansGkTrue.text.isEmpty() || binding.edtLisansGkFalse.text.isEmpty() ||
                binding.edtLisansGyTrue.text.isEmpty() || binding.edtLisansGyFalse.text.isEmpty()
            ) {
                Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT).show()
            } else {
                var gk_dogru = binding.edtLisansGkTrue.text.toString().toInt()
                var gk_yanlis = binding.edtLisansGkFalse.text.toString().toInt()

                var gy_dogru = binding.edtLisansGyTrue.text.toString().toInt()
                var gy_yanlis = binding.edtLisansGyFalse.text.toString().toInt()

                // status control
                if (status.equals("memur")) {
                    p3_puan = calc.lisansForMemur(gk_dogru, gk_yanlis, gy_dogru, gy_yanlis)
                    Toast.makeText(this, "P3 PUAN: " + p3_puan, Toast.LENGTH_SHORT).show()
                }
                if (status.equals("ogretmen")) {
                    if (binding.edtLisansEbTrue.text.isEmpty() || binding.edtLisansEbFalse.text.isEmpty()) {
                        Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        var eb_dogru = binding.edtLisansEbTrue.text.toString().toInt()
                        var eb_yanlis = binding.edtLisansEbFalse.text.toString().toInt()
                        p10_puan = calc.lisansForOgretmen(
                            gk_dogru,
                            gk_yanlis,
                            gy_dogru,
                            gy_yanlis,
                            eb_dogru,
                            eb_yanlis
                        )
                        Toast.makeText(this, "P10 PUAN: " + p10_puan, Toast.LENGTH_SHORT).show()
                    }
                }
                if (status.equals("oabt")) {
                    if (binding.edtLisansEbTrue.text.isEmpty() || binding.edtLisansEbFalse.text.isEmpty() ||
                        binding.edtLisansOabtTrue.text.isEmpty() || binding.edtLisansOabtFalse.text.isEmpty()
                    ) {
                        Toast.makeText(this, "Fill in the required fields", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        var eb_dogru = binding.edtLisansEbTrue.text.toString().toInt()
                        var eb_yanlis = binding.edtLisansEbFalse.text.toString().toInt()
                        var a_dogru = binding.edtLisansOabtTrue.text.toString().toInt()
                        var a_yanlis = binding.edtLisansOabtFalse.text.toString().toInt()
                        binding.spLisansOabt.onItemSelectedListener =
                            object : AdapterView.OnItemSelectedListener {
                                override fun onItemSelected(
                                    parent: AdapterView<*>?,
                                    view: View?,
                                    position: Int,
                                    id: Long
                                ) {
                                    itemStatu = spinners.get(position)
                                }

                                override fun onNothingSelected(parent: AdapterView<*>?) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Please select one item",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        p121_puan = calc.lisansForOabt(
                            gk_dogru,
                            gk_yanlis,
                            gy_dogru,
                            gy_yanlis,
                            eb_dogru,
                            eb_yanlis,
                            a_dogru,
                            a_yanlis,
                            itemStatu
                        )
                        Toast.makeText(
                            applicationContext,
                            "P121 PUAN: " + p121_puan,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

        binding.btnOnlisansHesapla.setOnClickListener {
            calc.onlisans()
        }

        binding.btnOogretimHesapla.setOnClickListener {
            calc.ortaogretim()
        }

    }
}