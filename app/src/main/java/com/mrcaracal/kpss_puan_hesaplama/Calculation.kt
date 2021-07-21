package com.mrcaracal.kpss_puan_hesaplama

import android.widget.Toast

class Calculation {

    var s_sapma_a : Double = 0.0

    // FORMÜL
    /*
    Doğru Sayısı - Yanlış Sayısı / 4 = Net Sayısı

    // Kişinin bilgileri
    k_net_gk = 55
    k_net_gy = 47,5

    // 2018 birincisi verileri
    tb_net_gk = 56,25
    tb_net_gy = 56,25

    // 2018 verileri
    s_sapma_gk = 10,262
    s_sapma_gy = 10,312

    // 2018 verileri
    o_net_gk = 19,187
    o_net_gk = 23,506

    k_spuan_gk = ((k_net_gk - o_net_gk)/s_sapma_gk) * 10 + 50
    k_spuan_gy = ((k_net_gy - o_net_gy)/s_sapma_gy) * 10 + 50

    b_spuan_gk = ((b_net_gk - o_net_gk)/s_sapma_gk) * 10 + 50
    b_spuan_gy = ((b_net_gy - o_net_gy)/s_sapma_gy) * 10 + 50

    // Sadece GK ve GY girenler için
    kisi_asp_gk_gy = k_spuan_gk * (0,5) + k_spuan_gy * (0,5)

    // + Eğitim girenler için
    k_spuan_gk * (0,3) + k_spuan_gy * (0,3) + k_spuan_egitim(0,4)

    // + Alan girenler için
    k_spuan_gk * (0,15) + k_spuan_gy * (0,15) + k_spuan_egitim * (0,2) + k_spuan_alan * (0,5)

    tahmini_s_sapma_ort_gk_gy = 8,125
    tahmini_asp_ort_gk_gy = 49,992

    P3 Puan = 70 + ((30 * (2 * (kisi_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy)) /
     (2 * (birinci_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy))
     */

    fun lisansForMemur(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int): Double{
        val k_net_gk = gk_dogru-(gk_yanlis/4)
        val k_net_gy = gy_dogru-(gy_yanlis/4)

        // 2018 verisi
        val tb_net_gk = 56.25
        val tb_net_gy = 56.25

        // 2018 verisi
        val s_sapma_gk = 10.262
        val s_sapma_gy = 10.312

        // 2018 verisi
        val o_net_gk = 19.187
        val o_net_gy = 23.506

        val k_spuan_gk = ((k_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val k_spuan_gy = ((k_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val b_spuan_gk = ((tb_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val b_spuan_gy = ((tb_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50

        val k_asp_gk_gy = k_spuan_gk * (0.5) + k_spuan_gy * (0.5)
        val b_asp_gk_gy = b_spuan_gk * (0.5) + b_spuan_gy * (0.5)

        val tahmini_s_sapma_ort_gk_gy = 8.125
        val tahmini_asp_ort_gk_gy = 49.992

        val p3_puan = 70 + ((30 * (2 * (k_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy)) /
                (2 * (b_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy))

        return p3_puan
    }

    fun lisansForOgretmen(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int, eb_dogru: Int, eb_yanlis: Int): Double{
        val k_net_gk = gk_dogru-(gk_yanlis/4)
        val k_net_gy = gy_dogru-(gy_yanlis/4)
        val k_net_eb = eb_dogru-(eb_yanlis/4)

        // 2018 verisi
        val tb_net_gk = 56.25
        val tb_net_gy = 56.25
        val tb_net_eb = 56.25

        // 2018 verisi
        val s_sapma_gk = 10.262
        val s_sapma_gy = 10.312
        val s_sapma_eb = 14.554

        // 2018 verisi
        val o_net_gk = 19.187
        val o_net_gy = 23.506
        val o_net_eb = 38.986

        val k_spuan_gk = ((k_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val k_spuan_gy = ((k_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val k_spuan_eb = ((k_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50
        val b_spuan_gk = ((tb_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val b_spuan_gy = ((tb_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val b_spuan_eb = ((tb_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50

        val k_asp_gk_gy = k_spuan_gk * (0.3) + k_spuan_gy * (0.3) + k_spuan_eb * (0.4)
        val b_asp_gk_gy = b_spuan_gk * (0.3) + b_spuan_gy * (0.3) + b_spuan_eb * (0.4)

        val tahmini_s_sapma_ort_gk_gy = 8.125
        val tahmini_asp_ort_gk_gy = 49.992

        val p10_puan = 70 + ((30 * (2 * (k_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy)) /
                (2 * (b_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy))

        return p10_puan
    }

    fun lisansForOabt(gk_dogru: Int, gk_yanlis: Int, gy_dogru: Int, gy_yanlis: Int, eb_dogru: Int, eb_yanlis: Int, a_dogru: Int, a_yanlis: Int, itemStatu: String): Double{
        val k_net_gk = gk_dogru-(gk_yanlis/4)
        val k_net_gy = gy_dogru-(gy_yanlis/4)
        val k_net_eb = eb_dogru-(eb_yanlis/4)
        val k_net_a = a_dogru-(a_yanlis/4)

        // 2018 verisi
        val tb_net_gk = 56.25
        val tb_net_gy = 56.25
        val tb_net_eb = 56.25
        val tb_net_a = 56.25

        // 2018 verisi
        val s_sapma_gk = 10.262
        val s_sapma_gy = 10.312
        val s_sapma_eb = 14.554

        //Türkçe için
        when(itemStatu){
            "Türkçe" -> s_sapma_a = 7.138
            "Matematik (İlköğretim)" -> s_sapma_a = 5.219
            "Fen Bilimleri ve Teknoloji" -> s_sapma_a = 5.595
            "Sosyal Bilimler" -> s_sapma_a = 7.060
            "Türk Dili ve Edebiyatı" -> s_sapma_a = 8.414
            "Tarih" -> s_sapma_a = 8.868
            "Coğrafya" -> s_sapma_a = 7.762
            "Matematik (Lise)" -> s_sapma_a = 6.883
            "Fizik" -> s_sapma_a = 10.067
            "Kimya" -> s_sapma_a = 7.304
            "Biyoloji" -> s_sapma_a = 7.685
            "Din Kültürü ve Ahlak Bilgisi" -> s_sapma_a = 6.368
            "Yabancı Dil (İngilizce)" -> s_sapma_a = 9.277
            "Rehber Öğretmen" -> s_sapma_a = 7.491
            "Sınıf Öğretmenliği" -> s_sapma_a = 5.705
            "Okul Öncesi Öğretmenliği" -> s_sapma_a = 6.567
        }

        // 2018 verisi
        val o_net_gk = 19.187
        val o_net_gy = 23.506
        val o_net_eb = 38.986
        val o_net_a = 27.435

        val k_spuan_gk = ((k_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val k_spuan_gy = ((k_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val k_spuan_eb = ((k_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50
        val k_spuan_a = ((k_net_a - o_net_a) / s_sapma_a) * 10 + 50

        val b_spuan_gk = ((tb_net_gk - o_net_gk) / s_sapma_gk) * 10 + 50
        val b_spuan_gy = ((tb_net_gy - o_net_gy) / s_sapma_gy) * 10 + 50
        val b_spuan_eb = ((tb_net_eb - o_net_eb) / s_sapma_eb) * 10 + 50
        val b_spuan_a = ((tb_net_a - o_net_a) / s_sapma_a) * 10 + 50

        val k_asp_gk_gy = k_spuan_gk * (0.15) + k_spuan_gy * (0.15) + k_spuan_eb * (0.2) + k_spuan_a * (0.4)
        val b_asp_gk_gy = b_spuan_gk * (0.15) + b_spuan_gy * (0.15) + b_spuan_eb * (0.2) + b_spuan_a * (0.4)

        val tahmini_s_sapma_ort_gk_gy = 8.125
        val tahmini_asp_ort_gk_gy = 49.992

        val p121_puan = 70 + ((30 * (2 * (k_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy)) /
                (2 * (b_asp_gk_gy - tahmini_asp_ort_gk_gy) - tahmini_s_sapma_ort_gk_gy))

        return p121_puan
    }

    fun onlisans(){

    }

    fun ortaogretim(){

    }
}