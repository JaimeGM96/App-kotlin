package com.example.jaime.pruebakotlin.view.activities

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.webkit.URLUtil;
import com.example.jaime.pruebakotlin.R

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import kotlinx.android.synthetic.main.activity_login.*

import java.lang.Thread.sleep


class NFCReaderActivity : AppCompatActivity() {
    private var cameraSource: CameraSource? = null
    private var cameraView: SurfaceView? = null
    private val MY_PERMISSIONS_REQUEST_CAMERA = 1
    private var token = ""
    private var tokenanterior = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nfc_reader)

        initQR()
    }

    fun initQR() {

        val barcodeDetector = BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build()

        cameraSource = CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(1600, 1024)
                .setAutoFocusEnabled(true)
                .build()

        cameraView?.holder?.addCallback(object : SurfaceHolder.Callback {
            override fun surfaceCreated(holder: SurfaceHolder) {

                // verifico si el usuario dio los permisos para la camara
                if (ActivityCompat.checkSelfPermission(this@NFCReaderActivity, Manifest.permission.CAMERA) !== PackageManager.PERMISSION_GRANTED) {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        // verificamos la version de ANdroid que sea al menos la M para mostrar
                        // el dialog de la solicitud de la camara
                        if (shouldShowRequestPermissionRationale(
                                        Manifest.permission.CAMERA))
                        ;
                        requestPermissions(arrayOf(Manifest.permission.CAMERA),
                                MY_PERMISSIONS_REQUEST_CAMERA)
                    }
                    return
                } else {
                    try {
                        cameraSource!!.start(cameraView!!.holder)
                    } catch (ie: Exception) {
                        println(ie)
                    }

                }
            }

            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {}

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource!!.stop()
            }
        })

        barcodeDetector.setProcessor(object : Detector.Processor<Barcode> {
            override fun release() {}


            override fun receiveDetections(detections: Detector.Detections<Barcode>) {
                val barcodes = detections.detectedItems

                if (barcodes.size() > 0) {

                    token = barcodes.valueAt(0).displayValue.toString()

                    if (token != tokenanterior) {
                        tokenanterior = token
                        Log.i("token", token)

                        if (URLUtil.isValidUrl(token)) {
                            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(token))
                            startActivity(browserIntent)
                            /*val intent = Intent(this, UserListActivity::class.java)
                            val datosSalida: String = et_user_name.text.toString()
                            intent.putExtra("login", datosSalida)
                            startActivity(intent)*/
                        } else {
                            val shareIntent = Intent()
                            shareIntent.action = Intent.ACTION_SEND
                            shareIntent.putExtra(Intent.EXTRA_TEXT, token)
                            shareIntent.type = "text/plain"
                            startActivity(shareIntent)
                        }

                        Thread(object : Runnable {
                            override fun run() {
                                try {
                                    synchronized(this) {
                                        sleep(5000)
                                        tokenanterior = ""
                                    }
                                } catch (e: InterruptedException) {
                                    Log.e("Error", "Waiting didnt work!!")
                                    e.printStackTrace()
                                }

                            }
                        }).start()

                    }
                }
            }
        })

    }
}