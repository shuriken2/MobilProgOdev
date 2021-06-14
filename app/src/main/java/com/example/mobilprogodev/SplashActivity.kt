@file:Suppress("DEPRECATION")

package com.example.mobilprogodev
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import android.widget.Toast

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var context:Context=this


        window.requestFeature(Window.FEATURE_NO_TITLE)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)


        setContentView(R.layout.activity_splash)


        Handler().postDelayed({

       startActivity(Intent(this@SplashActivity,MainActivity::class.java))

         finish()
        },3000)

if (checkConnection(context)){

    Toast.makeText(this,"iNTERNET BAĞLANDI",Toast.LENGTH_LONG).show()
}else{


    Toast.makeText(this,"İnternet Bağlantısı Bulunamadı",Toast.LENGTH_LONG).show()
}

    }

    fun checkConnection(context: Context):Boolean {


        val connectivityManager=context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo =connectivityManager.activeNetworkInfo
        return networkInfo!=null && networkInfo.isConnected


    }

}