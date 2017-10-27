/*
 * Minecraft Dev for IntelliJ
 *
 * https://minecraftdev.org
 *
 * Copyright (c) 2017 minecraft-dev
 *
 * MIT License
 */

package com.demonwav.mcdev.i18n.lang.colors

import com.demonwav.mcdev.i18n.lang.I18nLexerAdapter
import com.demonwav.mcdev.i18n.lang.gen.psi.I18nTypes
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class I18nSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer() = I18nLexerAdapter()

    override fun getTokenHighlights(tokenType: IElementType?) =
        when (tokenType) {
            I18nTypes.KEY -> KEY_KEYS
            I18nTypes.EQUALS -> EQUALS_KEYS
            I18nTypes.VALUE -> VALUE_KEYS
            I18nTypes.COMMENT, I18nTypes.DUMMY -> COMMENT_KEYS
            else -> EMPTY_KEYS
        }

    companion object {
        val KEY = TextAttributesKey.createTextAttributesKey("I18N_KEY", DefaultLanguageHighlighterColors.KEYWORD)
        val EQUALS = TextAttributesKey.createTextAttributesKey("I18N_EQUALS", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val VALUE = TextAttributesKey.createTextAttributesKey("I18N_VALUE", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = TextAttributesKey.createTextAttributesKey("I18N_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)

        val KEY_KEYS = arrayOf(KEY)
        val EQUALS_KEYS = arrayOf(EQUALS)
        val VALUE_KEYS = arrayOf(VALUE)
        val COMMENT_KEYS = arrayOf(COMMENT)
        val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}
