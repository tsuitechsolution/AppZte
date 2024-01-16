package com.tech.ztelocker.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun String.isValidHttpAddress(): Boolean {
    return !isNullOrEmpty() && Patterns.WEB_URL.matcher(this).matches()
}

fun String.toDate(
    inputPattern: String = DateUtil.DF_SERVER2,
    outputPattern: String = "dd/MM/yyyy"
): String = SimpleDateFormat(outputPattern, Locale.getDefault()).format(
    SimpleDateFormat(
        inputPattern,
        Locale.getDefault()
    ).parse(this)!!
)

fun String.isValidEmail(): Boolean {
    return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidNumber(): Boolean {
    return TextUtils.isDigitsOnly(this)
}

fun String.makeCall(context: Context) {
    if (this.isEmpty()) {
        return
    }
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("tel:$this"))
    context.startActivity(intent)
}

fun String.showToast(context: Context, length: Int = Toast.LENGTH_SHORT) {
    if (this.isValid().not()) {
        return
    }
    Toast.makeText(context, this, length).show()
}

fun String.showSnack(view: View, length: Int = Snackbar.LENGTH_SHORT) {
    if (this.isValid().not()) {
        return
    }
    Snackbar.make(view, this, length).show()
}

fun String.isValidPhoneNumber(): Boolean {
    if (this.trim() != "" && this.length > 9) {
        return Patterns.PHONE.matcher(this).matches()
    }
    return false
}

fun String.isValidPanNumber(): Boolean {
    val regex = "[A-Z]{5}[0-9]{4}[A-Z]{1}"
    return this.matches(Regex(regex))
}

fun String?.isValid(): Boolean {
    if (this == null) {
        return false
    }
    return this.trim().length > 3
}

fun String?.isValidAndNotEmpty(): Boolean {
    if (this == null) {
        return false
    }
    if (this.trim().isEmpty()) {
        return false
    }
    return this.trim().isNotEmpty()
}

fun String?.isValidName(): Boolean {
    if (this == null) {
        return false
    }
    val regex = "[a-zA-Z ]+"
    return this.matches(Regex(regex))
}

fun String.replaceNoFieldValue(replaceWith: String): String {
    return if (this.isEmpty()) {
        replaceWith
    } else this
}

fun Int.isValid(): Boolean {
    return this > 0
}

fun Double.isValid(): Boolean {
    return this > 0
}

fun String.toFileName(): String {
    val index = this.lastIndexOf("/")
    val separatorIndex = this.lastIndexOf(".")
    return if (index > 0 && separatorIndex > 0 && index < separatorIndex) {
        this.substring(index + 1, this.length)
    } else
        this
}