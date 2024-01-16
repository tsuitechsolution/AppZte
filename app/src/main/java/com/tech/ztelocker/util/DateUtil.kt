package com.tech.ztelocker.util

import android.util.Log
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit.MILLISECONDS

object DateUtil {
    const val FORMAT = "dd/MM/yyyy"
    const val FORMAT1 = "dd/MM/yyyy hh:mm:ss a"
    const val FORMAT3 = "dd-MM-yyyy"
    const val DF_LOCAL = "dd MMM hh:mm a"
    const val DF_SERVER = "yyyy-MM-dd HH:mm:ss"
    const val DF_SERVER2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val DF_SERVER3 = "yyyy-MM-dd"

    @JvmStatic
    val dateForLog: String?
        get() {
            val date = Date(System.currentTimeMillis())
            val formatter = SimpleDateFormat(
                "dd-MM-yyyy_HH_mm_ss",
                Locale.getDefault()
            )
            return formatter.format(date)
        }

    fun getConvertedDate(date: String, format: String = FORMAT): Long {
        val f = SimpleDateFormat(format, Locale.getDefault())
        try {
            val d = f.parse(date)
            Log.d("Date is %s", d.toString())
            return d.time
        } catch (e: ParseException) {
            e.printStackTrace()
            e.localizedMessage?.let { Log.e(javaClass.simpleName, it) }
        }
        return 0
    }

    fun getConvertedDate(date: String, format: String = FORMAT, day: Long = 0): Long {
        var f = SimpleDateFormat(format, Locale.getDefault())
        try {
            var d = f.parse(date)
            Log.d("Date is %s", d.toString())
            val futureDay =
                LocalDate.parse(date, DateTimeFormatter.ofPattern(format)).plusDays(day).toString()
            Log.d("On Plus Date is %s", futureDay)
            f = SimpleDateFormat(DF_SERVER3, Locale.getDefault())
            d = f.parse(futureDay)
            return d.time
        } catch (e: ParseException) {
            e.printStackTrace()
            e.localizedMessage?.let { Log.e(javaClass.simpleName, it) }
        }
        return 0
    }

    fun getDate(mills: Long, format: String): String {
        val date = Date(mills)
        val df2 = SimpleDateFormat(
            format,
            Locale.getDefault()
        )
        return df2.format(date)
    }

    /**
     * This will converts given date with required format
     *
     * @param date string which you want to convert
     * @param sourceFormat format of date
     * @param destinationFormat format of date
     * @return converted given date as string with required format
     */
    fun convertDateFormat(
        date: String?,
        sourceFormat: String,
        destinationFormat: String
    ): String {
        var returnDate = ""
        if (date != null && date != "") {
            var formatter = SimpleDateFormat(
                sourceFormat,
                Locale.getDefault()
            )
            try {
                val date1 = formatter.parse(date)
                date1?.let {
                    formatter = SimpleDateFormat(destinationFormat, Locale.getDefault())
                    returnDate = formatter.format(it)
                }
            } catch (e: ParseException) {
                e.localizedMessage?.let { Log.e(javaClass.simpleName, it) }
                e.printStackTrace()
            }
        }
        return returnDate
    }

    /**
     * This will return Date which will taken as string
     *
     * @param dateFormat of given date
     * @param strDate    as String
     * @return Date format of given String date
     */
    @JvmStatic
    fun convertStringIntoDate(dateFormat: String, strDate: String): Date? {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        try {
            return formatter.parse(strDate)
        } catch (e: ParseException) {
            e.localizedMessage?.let { Log.e(javaClass.simpleName, it) }
        }
        return null
    }

    fun getDateDiff(date: Date): String {
        val diff = date.time - Date().time //as given
        val minutes = MILLISECONDS.toMinutes(diff)
        return if (minutes == 0L) {
            "1 min"
        } else "$minutes mins"
    }

    fun getDateDiffInMins(date: Date): String {
        val diff = Date().time - date.time //as given
        val minutes = MILLISECONDS.toMinutes(diff)
        return if (minutes == 0L) {
            "1"
        } else "$minutes"
    }

    fun getDateDiffInMinsReverse(date: Date): String {
        val diff = date.time - Date().time //as given
        val minutes = MILLISECONDS.toMinutes(diff)
        return if (minutes == 0L) {
            "1"
        } else "$minutes"
    }

    fun getDateDiffGreater(
        startDate: String = getDate(System.currentTimeMillis(), FORMAT3),
        endDate: String
    ): Boolean {
        val startTime = convertStringIntoDate(FORMAT3, startDate)?.time
        val endTime = convertStringIntoDate(FORMAT3, endDate)?.time
        return if (startTime != null && endTime != null) {
            val diff = endTime - startTime //as given
            //        val minutes = MILLISECONDS.toMinutes(diff)
            diff >= 0L
        } else {
            false
        }
    }

    fun getBackDays(minusDays:Int) : String {
        // Getting the previous date using minusDays() method
        return LocalDate.now().minusDays(minusDays.toLong()).toString()
    }

    fun getFutureDays(plusDays:Int) : String {
        // Getting the next date using plusDays() method
        return LocalDate.now().minusDays(plusDays.toLong()).toString()
    }


}