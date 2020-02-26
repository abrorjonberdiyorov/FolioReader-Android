package uz.kitapp.app

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val READ_INTENT_REQUEST_CODE = 1002
    private val READ_WRITE_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_choose.setOnClickListener {
            checkAndRunAsynTask()
        }
    }


    fun checkAndRunAsynTask() {
        if (
            Build.VERSION.SDK_INT > Build.VERSION_CODES.M &&
            (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                READ_WRITE_REQUEST_CODE
            )
        } else {
            chooseFileFromStorage()
        }
    }


    private fun chooseFileFromStorage() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.setType("text/*")
        startActivityForResult(intent, READ_INTENT_REQUEST_CODE)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == READ_INTENT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val uri = data.data
                var path = uri!!.path
                val sss = Environment.getExternalStorageDirectory().absolutePath
                path = sss + "/" + path!!.substring(path.indexOf(":") + 1)

            }
        }
    }
}
