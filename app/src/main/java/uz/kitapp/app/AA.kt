package uz.kitapp.app

/*
package com.example.fileencryption

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.util.*
import javax.crypto.Cipher


class MainActivity : AppCompatActivity() {

    var publicKey: PublicKey? = null
    var privateKey: PrivateKey? = null

    val REQUEST_CODE_WRITE_EXTERNAL = 101
    private val  TAG = "TAG"
    private var openBytes:ByteArray? = null
    private var encryptedBytes:ByteArray? = null
    private var decryptedBytes:ByteArray? = null
    private var AES:Aes256Class? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CreatePublicPrivateKeys()

        AES = Aes256Class()

        btn_open.setOnClickListener {
            try {
                val inputStream: InputStream = assets.open("rasm.jpg")

                val buffer = ByteArray(1024)
                var bytesRead: Int
                val output = ByteArrayOutputStream()
                bytesRead = inputStream.read(buffer)
                while (bytesRead != -1) {
                    output.write(buffer, 0, bytesRead)
                    bytesRead = inputStream.read(buffer)
                }
                val filebytearray: ByteArray = output.toByteArray()
                openBytes = filebytearray
                val bmp = BitmapFactory.decodeByteArray(filebytearray, 0, filebytearray.size)

                iv.setImageBitmap(
                    Bitmap.createScaledBitmap(
                        bmp, iv.getWidth(),
                        iv.getHeight(), false
                    )
                )

                //                //saveAsEncrypt(filebytearray, itemId)
            } catch (ex: Exception) {
                Log.e(TAG, ex.message)
            }

        }

        btn_encrypt.setOnClickListener {
            encryptedBytes = AES!!.encryptdecrypt(openBytes!!, Cipher.ENCRYPT_MODE)
            val str = String(encryptedBytes!!, Charsets.UTF_8)
            tv_encrypted.text = str
        }
        btn_decrypt.setOnClickListener {
            decryptedBytes = AES!!.encryptdecrypt(encryptedBytes!!, Cipher.DECRYPT_MODE)
            val bmp = BitmapFactory.decodeByteArray(decryptedBytes, 0, decryptedBytes!!.size)

            iv_decrypted.setImageBitmap(
                Bitmap.createScaledBitmap(
                    bmp, iv.getWidth(),
                    iv.getHeight(), false
                )
            )
        }
    }

    fun randomName(): String? {
        val generator = Random()
        val randomStringBuilder = StringBuilder()
        val randomLength: Int = 25
        var tempChar: Char
        for (i in 0 until randomLength) {
            tempChar = ((generator.nextInt(26) + 97).toChar())
            randomStringBuilder.append(tempChar)
        }
        return randomStringBuilder.toString()
    }

    private fun saveAsEncrypt(filebytearray: ByteArray, itemId: Int) {
        if (isExternalStorageAvailable()) {
            val writeExternalStoragePermission = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE_WRITE_EXTERNAL
                )
            } else {
                saveToExternalStorage(encryptedBytes, itemId.toString())
            }
        }


    }

    private fun saveToExternalStorage(encryptedBytes: ByteArray?, filename: String) {
        val f = File(Environment.getExternalStorageDirectory(), "NewFolder")
        if (!f.exists()) {
            f.mkdirs()
        }
        var myExternalFile = File(f, filename)
        try {
            val fileOutPutStream = FileOutputStream(myExternalFile)
            fileOutPutStream.write(encryptedBytes)
            fileOutPutStream.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun CreatePublicPrivateKeys(){
        try {
            val kpg = KeyPairGenerator.getInstance("RSA")
            kpg.initialize(2048)
            val kp = kpg.genKeyPair()
            publicKey = kp.public
            privateKey = kp.private
        } catch (e: java.lang.Exception) {
            Log.e(TAG, "RSA key pair error")
        }
    }



    private fun isExternalStorageReadOnly(): Boolean {
        val extStorageState: String = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            true
        } else false
    }

    private fun isExternalStorageAvailable(): Boolean {
        val extStorageState: String = Environment.getExternalStorageState()
        return if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            true
        } else false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_WRITE_EXTERNAL->{
                if(grantResults.isEmpty() || grantResults[0]!= PackageManager.PERMISSION_GRANTED){
                    Log.i(TAG, "Permission berilmadi")
                }else{
                    Log.i(TAG, "Permission berildi")
                }
            }
        }
    }



}*/
