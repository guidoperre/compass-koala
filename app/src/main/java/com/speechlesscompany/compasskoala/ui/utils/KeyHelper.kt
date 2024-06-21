package com.speechlesscompany.compasskoala.ui.utils

import android.content.Context
import android.content.pm.PackageManager
import java.security.MessageDigest
import java.security.SignatureException

object KeyHelper {

    @Suppress("DEPRECATION")
    fun getSHA1(context: Context): String {
        var sha1: String? = null
        val info = context.packageManager.getPackageInfo(
            context.applicationInfo.packageName,
            PackageManager.GET_SIGNATURES
        )

        for (signature in info.signatures) {
            val message = MessageDigest.getInstance("SHA1")
            message.update(signature.toByteArray())
            val digest = message.digest()
            val toRet = StringBuilder()

            for (i in digest.indices) {
                if (i != 0) toRet.append(":")
                val b = digest[i].toInt() and 0xff
                val hex = Integer.toHexString(b)
                if (hex.length == 1) toRet.append("0")
                toRet.append(hex)
            }

            sha1 = toRet.toString()
        }

        return sha1 ?: throw SignatureException()
    }
}
