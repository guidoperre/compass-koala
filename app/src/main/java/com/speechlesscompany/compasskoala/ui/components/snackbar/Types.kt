package com.speechlesscompany.compasskoala.ui.components.snackbar

import androidx.compose.ui.graphics.Color

object Types {

    internal interface SnackbarTypeInterface {

        fun getTextColor(): Color

        fun getButtonColor(): Color

        fun getBackgroundColor(): Color
    }

    internal class SnackbarTypeSuccess : SnackbarTypeInterface {

        override fun getTextColor(): Color = SnackbarColors.SnackbarSuccessTextColor

        override fun getButtonColor(): Color = SnackbarColors.SnackbarSuccessButtonColor

        override fun getBackgroundColor(): Color = SnackbarColors.SnackbarSuccessColor
    }

    internal class SnackbarTypeNeutral : SnackbarTypeInterface {

        override fun getTextColor(): Color = SnackbarColors.SnackbarNeutralTextColor

        override fun getButtonColor(): Color = SnackbarColors.SnackbarNeutralButtonColor

        override fun getBackgroundColor(): Color = SnackbarColors.SnackbarNeutralColor
    }

    internal class SnackbarTypeError : SnackbarTypeInterface {

        override fun getTextColor(): Color = SnackbarColors.SnackbarErrorTextColor

        override fun getButtonColor(): Color = SnackbarColors.SnackbarErrorButtonColor

        override fun getBackgroundColor(): Color = SnackbarColors.SnackbarErrorColor
    }
}
