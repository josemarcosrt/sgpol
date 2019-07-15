package br.gov.df.pm.sgpol.sgpol.utils

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.style.ImageSpan
import android.widget.TextView

import java.util.HashSet
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by twiceYuan on 2017/5/6.
 *
 *
 * 使用 Spannable 让 TextView 文字两端对齐。
 *
 *
 * 原理是测量原始行中空格占用的宽度总和，让行尾的空白平均到所有空格中去。使用 Span 来代替空格保证空格的宽度不受字体影响。
 */
object TextJustification {

    fun justify(textView: TextView) {

        // 标记是否已经进行过处理，因为 post 回调会在处理后继续触发
        val isJustify = AtomicBoolean(false)

        // 处理前原始字符串
        val textString = textView.text.toString()

        // 用于测量文字宽度，计算分散对齐后的空格宽度
        val textPaint = textView.paint

        val textViewText = textView.text

        // 分散对齐后的文字
        val builder = textViewText as? Spannable ?: SpannableString(textString)

        // 在 TextView 完成测量绘制之后执行
        textView.post {
            // 判断是否已经处理过
            if (!isJustify.get()) {

                // 获取原始布局总行数
                val lineCount = textView.lineCount
                // 获取 textView 的宽度
                val textViewWidth = textView.width

                for (i in 0 until lineCount) {

                    // 获取行首字符位置和行尾字符位置来截取每行的文字
                    val lineStart = textView.layout.getLineStart(i)
                    val lineEnd = textView.layout.getLineEnd(i)

                    val lineString = textString.substring(lineStart, lineEnd)

                    // 最后一行不做处理
                    if (i == lineCount - 1) {
                        break
                    }

                    // 行首行尾去掉空格以保证处理后的对齐效果
                    val trimSpaceText = lineString.trim { it <= ' ' }
                    val removeSpaceText = lineString.replace(" ".toRegex(), "")

                    val removeSpaceWidth = textPaint.measureText(removeSpaceText)
                    val spaceCount = (trimSpaceText.length - removeSpaceText.length).toFloat()

                    // 两端对齐时每个空格的重新计算的宽度
                    val eachSpaceWidth = (textViewWidth - removeSpaceWidth) / spaceCount

                    // 两端空格需要单独处理
                    val endsSpace = spacePositionInEnds(lineString)
                    for (j in 0 until lineString.length) {
                        val c = lineString[j]

                        // 使用透明的 drawable 来填充空格部分
                        val drawable = ColorDrawable(0x00ffffff)

                        if (c == ' ') {
                            if (endsSpace.contains(j)) {
                                // 如果是两端的空格，则宽度置为 0
                                drawable.setBounds(0, 0, 0, 0)
                            } else {
                                drawable.setBounds(0, 0, eachSpaceWidth.toInt(), 0)
                            }
                            val span = ImageSpan(drawable)
                            builder.setSpan(span, lineStart + j, lineStart + j + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                    }
                }

                textView.text = builder
                // 标记处理完毕
                isJustify.set(true)
            }
        }
    }

    /**
     * 返回两端的空格坐标，例如字符串 " abc  "（前面一个空格，后面两个空格）就返回 [0, 5, 6]
     */
    private fun spacePositionInEnds(string: String): Set<Int> {
        val result = HashSet<Int>()
        for (i in 0 until string.length) {
            val c = string[i]
            if (c == ' ') {
                result.add(i)
            } else {
                break
            }
        }

        if (result.size == string.length) {
            return result
        }

        for (i in string.length - 1 downTo 1) {
            val c = string[i]
            if (c == ' ') {
                result.add(i)
            } else {
                break
            }
        }

        return result
    }
}