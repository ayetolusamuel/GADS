package com.codingwithset.gads.utils

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.view.Gravity
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.codingwithset.gads.ExitApp
import com.codingwithset.gads.R
import kotlinx.android.synthetic.main.dialog_layout.*


fun Context.checkInternetAccess(): Boolean? {
    try {

        with(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //Device is running on Marshmallow or later Android OS.
                with(getNetworkCapabilities(activeNetwork)) {
                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
                    return this!!.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || hasTransport(
                        NetworkCapabilities.TRANSPORT_CELLULAR
                    )
                }
            } else {
                @Suppress("DEPRECATION")
                activeNetworkInfo?.let {
                    // connected to the internet
                    @Suppress("DEPRECATION")
                    return listOf(
                        ConnectivityManager.TYPE_WIFI,
                        ConnectivityManager.TYPE_MOBILE
                    ).contains(it.type)
                }
            }
        }
        return false
    } catch (exc: NullPointerException) {
        return false
    }


}


//
//fun Context.checkInternetAccess(): Boolean {
//    try {
//
//        with(getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                //Device is running on Marshmallow or later Android OS.
//                with(getNetworkCapabilities(activeNetwork)) {
//                    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
//                    return hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || hasTransport(
//                        NetworkCapabilities.TRANSPORT_CELLULAR
//                    )
//                }
//            } else {
//                @Suppress("DEPRECATION")
//                activeNetworkInfo?.let {
//                    // connected to the internet
//                    @Suppress("DEPRECATION")
//                    return listOf(
//                        ConnectivityManager.TYPE_WIFI,
//                        ConnectivityManager.TYPE_MOBILE
//                    ).contains(it.type)
//                }
//            }
//        }
//        return false
//    } catch (exc: NullPointerException) {
//        return false
//    }
//
//
//}

//
//
//fun Activity.customToast() {
//    val inflater = layoutInflater
//    val layout = inflater.inflate(R.layout.dialog_layout, custom_toast_container) as ViewGroup
//    val displayMessage = layout.findViewById<TextView>(R.id.yes)
//
//    val dialog = ExitApp()
//  dialog.show(supportFragmentManager, "dialog_exit_app")
//
////    val toast = Toast(applicationContext)
////
////   // displayMessage.text = message
////    toast.setGravity(Gravity.BOTTOM, 0, 64)
////    toast.duration = Toast.LENGTH_SHORT
////    toast.view = layout
////    toast.show()
//}