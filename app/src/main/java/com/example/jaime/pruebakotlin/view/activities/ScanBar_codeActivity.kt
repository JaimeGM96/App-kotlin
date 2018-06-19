package com.example.jaime.pruebakotlin.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.content.Intent
import android.widget.Toast
import com.example.jaime.pruebakotlin.R


class ScanBar_codeActivity : AppCompatActivity() {

    var bar_code_id_txt:TextView?=null
    var barcode:String ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_bar_code)

        bar_code_id_txt=findViewById(R.id.bar_code_id_txt) as TextView

        val intent = Intent(this@ScanBar_codeActivity, ScannerViewActivity::class.java)
        startActivityForResult(intent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        barcode = data.extras.getString("BarCode")

        if (barcode.equals("")) {
            Toast.makeText(this@ScanBar_codeActivity,"Bar code not found",Toast.LENGTH_LONG).show()
        } else {
            bar_code_id_txt?.text = barcode
        }
    }

}