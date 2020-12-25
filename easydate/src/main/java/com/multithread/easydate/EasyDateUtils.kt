package com.multithread.easydate

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.telephony.TelephonyManager
import java.text.DateFormatSymbols
import java.util.*


class EasyDateUtils {


    companion object {

        @JvmStatic
        fun getCurrentMilliseconds(): Long? {
            return System.currentTimeMillis()
        }

        @JvmStatic
        fun showAllCountries() {
            val codes = Locale.getISOCountries()
            for (code in codes) {
                println()
            }
        }

        @JvmStatic
        fun getMonthNameByNumber(context: Context, month: Int, locale: Locale?): String? {


            return getLocalizedResources(context,month,locale)
        }

        private fun getLocalizedResources(context: Context,month: Int, desiredLocale: Locale?): String {
            return when(month){
                1 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                2 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                3 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                4 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                5 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                6 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                7 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                8 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                9 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                10 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                11 -> getLocaleStringResource(desiredLocale,R.string.month_name_january,context)
                else ->
                    ""
            }
        }

        @JvmStatic
        open fun getMonth(month: Int): String? {
            return DateFormatSymbols().getMonths().get(month - 1)
        }

        @JvmStatic
        fun getLocaleName(localeName: String?): Boolean {
            return false
        }



        private fun  getLocaleStringResource( requestedLocale:Locale?, resourceId:Int,  context:Context) :String{
            var  result = ""
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) { // use latest api
                val  config :Configuration= Configuration(context.resources.configuration);
                config.setLocale(requestedLocale);
                result = context.createConfigurationContext(config).getText(resourceId).toString();
            }
            else { // support older android versions
                var resources : Resources  = context.resources;
                var conf: Configuration  = resources.configuration;
                var savedLocale :Locale  = conf.locale;
                conf.locale = requestedLocale;
                resources.updateConfiguration(conf, null);

                // retrieve resources from desired locale
                result = resources.getString(resourceId);

                // restore original locale
                conf.locale = savedLocale;
                resources.updateConfiguration(conf, null);
            }

            return result;
        }

    }

}