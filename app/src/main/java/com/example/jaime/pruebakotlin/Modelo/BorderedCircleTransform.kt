package com.example.jaime.pruebakotlin.Modelo

import android.graphics.*
import com.squareup.picasso.Transformation


/**
 * Created by jaime on 22/3/18.
 */
class BorderedCircleTransform(private val borderWidth: Int,
                              private val borderColor: Int) : Transformation {

    override fun transform(source: Bitmap): Bitmap {
        val size = Math.min(source.width, source.height)

        val x = (source.width - size) / 2
        val y = (source.height - size) / 2

        val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
        if (squaredBitmap != source) {
            source.recycle()
        }

        val bitmap = Bitmap.createBitmap(size, size, source.config)

        val canvas = Canvas(bitmap)
        val paint = Paint()
        val shader = BitmapShader(squaredBitmap,
                Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP)
        paint.setShader(shader)
        paint.setAntiAlias(true)

        val r = size / 2f

        // Prepare the background
        val paintBg = Paint()
        paintBg.setColor(borderColor)
        paintBg.setStyle(Paint.Style.FILL_AND_STROKE)
        paintBg.setAntiAlias(true)

        // Draw the background circle
        canvas.drawCircle(r, r, r, paintBg)

        // Draw the image smaller
        // than the background so a little border will be seen
        canvas.drawCircle(r, r, r - borderWidth, paint)

        squaredBitmap.recycle()
        return bitmap
    }

    override fun key(): String {
        return "bordered_circle"
    }
}