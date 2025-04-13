package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {

    private lateinit var deskripsiRecyclerView: RecyclerView
    private lateinit var deskripsiList: ArrayList<Image>
    private lateinit var deskripsiAdapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        deskripsiList = ArrayList()

        deskripsiList.add(
            Image(R.drawable.majapahit, "Majapahit",
                "Majapahit, (bahasa Jawa: ꦩꦗꦥꦲꦶꦠ꧀, translit. Måjåpahit; " +
                        "pelafalan dalam bahasa Jawa: [mɔd͡ʒɔpaɪt] (dialek timur dan tengah) " +
                        "atau [mad͡ʒapaɪt] (dialek barat)) juga dikenal sebagai Wilwatikta, " +
                        "adalah sebuah kemaharajaan talasokrasi Hindu-Buddha Jawa yang berbasis " +
                        "di pulau Jawa, sekarang di Indonesia.")
        )

        deskripsiList.add(
            Image(R.drawable.kutai, "Kutai",
                "Kerajaan Martapura atau Kerajaan Martadipura (penamaan yang keliru) " +
                        "dalah kerajaan bercorak Hindu di Nusantara yang memiliki bukti sejarah " +
                        "ertua berupa prasasti Yupa dan berdiri sekitar abad ke-4 Masehi. " +
                        "Pusat kerajaan ini terletak di Muara Kaman, yang saat ini adalah sebuah " +
                        "kecamatan di Kabupaten Kutai Kartanegara, Provinsi Kalimantan Timur. " +
                        "Nama Kutai diberikan oleh para ahli mengambil dari nama tempat ditemukannya " +
                        "prasasti yang menunjukkan eksistensi kerajaan tersebut, nama resmi kerajaan " +
                        "tidak disebutkan dalam prasasti. Informasi nama Martapura diperoleh dari " +
                        "kitab Salasilah Raja dalam Negeri Kutai Kertanegara yang menceritakan " +
                        "pasukan Kerajaan Kutai Kertanegara dari Kutai Lama menyerang ibu kota " +
                        "kerajaan ini. Nama Kutai kemudian disematkankan pada Kerajaan Martapura, " +
                        "padahal nama Kutai berasal nama kerajaan yang relatif lebih baru yaitu " +
                        "Kutai Kertanegara, yang bekas ibu kota awalnya terletak di Kutai Lama, " +
                        "kawasan pesisir timur Pulau Kalimantan.")
        )

        deskripsiList.add(
            Image(R.drawable.tarumanegara, "Tarumanegara",
                "Tarumanagara atau Kerajaan Taruma (bahasa Sunda: ᮒᮛᮥᮙᮔᮌᮛ) adalah kerajaan " +
                        "tertua kedua di Nusantara setelah Kerajaan Kutai, yang meninggalkan bukti arkeologi. " +
                        "Kerajaan ini pernah berkuasa di wilayah barat Dari pulau Jawa pada abad ke-5 sampai abad ke-7 Masehi. " +
                        "Bukti tertua peninggalan arkeologi dari kerajaan ini adalah prasasti Ciaruteun, " +
                        "berupa batu peringatan dari abad ke-5 Masehi yang ditandai dengan bentuk " +
                        "tapak kaki raja Purnawarman.")
        )

        deskripsiList.add(
            Image(R.drawable.sriwijaya, "Sriwijaya",
                "Sriwijaya adalah kedatuan bahari historis yang berasal dari Pulau Sumatra " +
                        "sekitar abad ke-7 sampai abad ke-11. Kehadirannya banyak memberi pengaruh " +
                        "pada perkembangan sejarah Asia Tenggara (terutama dalam kawasan Nusantara barat. " +
                        "Dalam Bahasa bahasa melayu kuno, sri berarti \"bercahaya\" atau \"gemilang\", " +
                        "dan vijaya berarti \"kemenangan\" atau \"kejayaan\";  " +
                        "dengan demikian, nama Sriwijaya bermakna \"kemenangan yang gilang-gemilang\". " +
                        "Lokasi ibukota Sriwijaya dapat dengan akurat disimpulkan berada di Kota Palembang, " +
                        "tepatnya di muara Sungai Musi. Sriwijaya terdiri dari sejumlah pelabuhan " +
                        "yang saling berhubungan di sekitar Selat Malaka.")
        )

        deskripsiList.add(
            Image(R.drawable.mataram_kuno, "Mataram Kuno",
                "Kerajaan Medang (Jawa kuno: \uD807\uDF12\uD807\uDF1E\uD807\uDF21\uD807\uDF42\uD807\uDF2E\uD807\uDF25\uD807\uDF41 \uD807\uDF2A\uD807\uDF42\uD807\uDF23\uD807\uDF01, translit. kaḍatwan mḍaŋ) " +
                        "atau sering disebut juga Mataram Kuno adalah kerajaan agraris sekaligus " +
                        "talasokrasi yang berdiri di Jawa Tengah pada abad ke-8 Masehi, " +
                        "kemudian berpindah ke Jawa Timur pada abad ke-10 Masehi, " +
                        "yang didirikan oleh Sanjaya. Kerajaan ini dipimpin oleh wangsa Syailendra dan wangsa Isyana.")
        )

        deskripsiList.add(
            Image(R.drawable.kediri, "Kediri",
                "Kerajaan Kadiri atau Kerajaan Kediri dikenal juga sebagai Panjalu adalah " +
                        "kerajaan Hindu-Buddha yang terdapat di Jawa Timur, antara tahun 1042–1222. " +
                        "Dan merupakan salah satu kerajaan hasil pembelahan yang juga didirikan " +
                        "Airlangga. Kerajaan ini diperintah oleh Wangsa Isyana dan berpusat di " +
                        "Dahanapura, adalah nama sebuah kota kuno di masa lalu yang sekarang menjadi " +
                        "bagian dari Kota Kediri. Sebelum pembagian kerajaan, Panjalu merupakan wilayah dari Kerajaan Kahuripan.")
        )

        deskripsiList.add(
            Image(R.drawable.singhasari, "Singhasari",
                "Kerajaan Singhasari (Jawa kuno: \uD807\uDF31\uD807\uDF36\uD807\uDF16\uD807\uDF42\uD807\uDF32\uD807\uDF31\uD807\uDF2C\uD807\uDF36) " +
                        "atau Kerajaan Tumapel (Jawa kuno: \uD807\uDF21\uD807\uDF38\uD807\uDF2A\uD807\uDF26\uD807\uDF40\uD807\uDF2D\uD807\uDF41), " +
                        "adalah sebuah kerajaan Hindu-Buddha Jawa yang terletak di timur Pulau Jawa antara tahun 1222 dan 1292. " +
                        "Kerajaan ini menggantikan Kerajaan Kadiri sebagai kerajaan yang berkuasa di Jawa Timur. " +
                        "Nama kerajaan ini serumpun dengan distrik Singosari di Kabupaten Malang, yang terletak beberapa kilometer di utara Kota Malang")
        )

        deskripsiList.add(
            Image(R.drawable.perlak, "Perlak",
                "Kesultanan Peureulak atau Kesultanan Perlak adalah kerajaan Islam di " +
                        "Indonesia dan merupakan kesultanan yang berkuasa di sekitar " +
                        "wilayah Peureulak, Aceh Timur, Aceh sekarang disebut-sebut antara tahun 840 sampai dengan tahun 1292. " +
                        "Peureulak atau Perlak terkenal sebagai suatu daerah penghasil kayu perlak, " +
                        "jenis kayu yang sangat bagus untuk pembuatan kapal, dan karenanya daerah ini dikenal dengan nama \"Negeri Perlak\".")
        )

        deskripsiList.add(
            Image(R.drawable.kalingga, "Kalingga",
                "Kerajaan Kalingga (bahasa Jawa: ꦏꦫꦠꦺꦴꦤ꧀ꦏꦭꦶꦔ꧀ꦒ) ( ꦏꦺꦫꦗꦴꦤ꧀ ꦏꦭꦶꦤ꧀ꦒ꧀ꦒ ) " +
                        "atau kerajaan Keling adalah kerajaan bercorak Hindu-Buddha yang pertama muncul " +
                        "di pantai utara Jawa Tengah pada abad ke-4 Masehi atau tahun (424 - 716 M) " +
                        "Hampir bersamaan dengan Kerajaan Kutai Martapura, Kerajaan Tarumanagara di abad ke 4 dan Kerajaan Sriwijaya abad ke-6")
        )

        deskripsiRecyclerView = findViewById(R.id.imageRecyclerView)
        deskripsiRecyclerView.setHasFixedSize(true)
        deskripsiRecyclerView.layoutManager = LinearLayoutManager(this)

        deskripsiAdapter = ImageAdapter(deskripsiList)
        deskripsiRecyclerView.adapter = deskripsiAdapter
        deskripsiAdapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("deskripsi", it)
            startActivity(intent)
        }


    }
}