package sszymanski.co.uk.myhome.utils

import android.content.Context
import android.graphics.*
import sszymanski.co.uk.myhome.R
import kotlin.math.pow

/**
 * Created by rex on 06/02/2018.
 */
class IconUtils {
    companion object {
        fun generateColourBulb(context: Context, colourTemp: Int):Bitmap {
            var bulb = BitmapFactory.decodeResource(context.resources, R.drawable.light_bulb)
            val mutableBulb = bulb.copy(Bitmap.Config.ARGB_8888, true)
            val canvas = Canvas(mutableBulb)
            val tweakedColourTemp = colourTemp/1.6f// Needed to tweak original mired value to represent actual colour of the Philips hue better in the view
            val rgb = miredToRgb(tweakedColourTemp)
            val lightColour = Color.argb(127,rgb[0], rgb[1], rgb[2])
            canvas.drawColor(lightColour, PorterDuff.Mode.SRC_ATOP)
            return mutableBulb;

        }

        fun miredToRgb(ct: Float): ArrayList<Int>{
            return kelvinToRgb(miredToKelvin(ct));
        }

        fun miredToKelvin(miredValue: Float): Float {
            return 1000000 / miredValue
        }
        // This is only working algorithm I could find so far need more research
        fun kelvinToRgb(kelvin: Float): ArrayList<Int> {
            var red: Int
            var green: Int
            var blue: Int
            val tmpKelvin = kelvin / 100
            // RED
            if (tmpKelvin <= 66) red = 255
            else {
                var tmpCalc = tmpKelvin - 60
                tmpCalc = 329.698727446f * (tmpCalc.pow(-0.1332047592f))
                red = tmpCalc.toInt()
                if (red < 0) red = 0
                if (red > 255) red = 255
            }
            // GREEN
            if (tmpKelvin <= 66) {
                var tmpCalc = tmpKelvin
                tmpCalc = 99.4708025861f * Math.log(tmpCalc.toDouble()).toFloat() - 161.1195681661f
                green = tmpCalc.toInt()
                if (green < 0) green = 0
                if (green > 255) green = 255
            } else {
                var tmpCalc = tmpKelvin - 60
                tmpCalc = 288.1221695283f * (tmpCalc.pow(-0.0755148492f))
                green = tmpCalc.toInt()
                if (green < 0) green = 0
                if (green > 255) green = 255
            }
            // BLUE
            if (tmpKelvin >= 66)
                blue = 255
            else if (tmpKelvin <= 19) {
                blue = 0
            } else {
                var tmpCalc = tmpKelvin - 10
                tmpCalc = 138.5177312231f * Math.log(tmpCalc.toDouble()).toFloat() - 305.0447927307f
                blue = tmpCalc.toInt()
                if (blue < 0) blue = 0
                if (blue > 255) blue = 255
            }
            return arrayListOf<Int>(red, green, blue)

        }
    }
}