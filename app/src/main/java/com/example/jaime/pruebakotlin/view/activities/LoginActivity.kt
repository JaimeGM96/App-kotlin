package com.example.jaime.pruebakotlin.view.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.jaime.pruebakotlin.R
import com.google.android.gms.common.api.CommonStatusCodes
import com.squareup.picasso.Picasso
import com.google.android.gms.vision.barcode.Barcode
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var mResultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        getSupportActionBar()?.hide()

        initialize()
    }

    private fun initialize() {
        btn_login.setOnClickListener {
            //checkLogin()
            val intent = Intent(applicationContext, BarcodeCaptureActivity::class.java)
            startActivityForResult(intent, BARCODE_READER_REQUEST_CODE)
            /*val intent = Intent(applicationContext, ScanBar_codeActivity::class.java)
            startActivity(intent)*/
        }

        Picasso.with(this).load(R.mipmap.main_logo).into(iv_logo)
    }

    private fun checkLogin(){
        if ((!et_user_name.text.toString().equals("jaime")) || (!et_password.text.toString().equals("12345"))){
            Toast.makeText(this, "Login o Password no validos", Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, UserListActivity::class.java)
            val datosSalida: String = et_user_name.text.toString()
            intent.putExtra("login", datosSalida)
            startActivity(intent)
            /*val intent = Intent(applicationContext, NFCReaderActivity::class.java)
            startActivityForResult(intent, BARCODE_READER_REQUEST_CODE)*/
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == BARCODE_READER_REQUEST_CODE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    val barcode = data.getParcelableExtra<Barcode>(BarcodeCaptureActivity.BarcodeObject)
                    val p = barcode.cornerPoints
                    mResultTextView.text = barcode.displayValue
                } else
                    mResultTextView.setText(R.string.no_barcode_captured)
            } else
                Log.e(LOG_TAG, String.format(getString(R.string.barcode_error_format),
                        CommonStatusCodes.getStatusCodeString(resultCode)))
        } else
            super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        private val LOG_TAG = LoginActivity::class.java.simpleName
        private val BARCODE_READER_REQUEST_CODE = 1
    }
}
