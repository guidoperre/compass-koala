package com.speechlesscompany.compasskoala.ui.components.textinput

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import com.speechlesscompany.compasskoala.ui.styles.Dimen
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme

@ExperimentalMaterialApi
@Composable
internal fun PrimaryTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val colors = outlinedTextFieldColors()
    val shape = RoundedCornerShape(Dimen.ui05)
    val textStyle = CompassKoalaTheme.typography.h2
    val textColor = colors.textColor(enabled).value
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    BasicTextField(
        value = value,
        modifier = if (label != null) {
            modifier
                .semantics(mergeDescendants = true) {}
                .padding(top = Dimen.ui2)
        } else {
            modifier
        }
            .background(
                color = colors.backgroundColor(enabled).value,
                shape = shape
            )
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth
            ),
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(colors.cursorColor(isError).value),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = value,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                placeholder = placeholder?.let {{ PlaceholderText(placeholder = it) }},
                label = label?.let {{ LabelText(label = it) }},
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(Dimen.ui1_75),
                colors = colors,
                border = {
                    TextFieldDefaults.BorderBox(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = colors,
                        shape = shape
                    )
                }
            )
        }
    )
}

@ExperimentalMaterialApi
@Composable
fun PrimaryTextField(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions(),
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
) {
    val colors = outlinedTextFieldColors()
    val shape = RoundedCornerShape(Dimen.ui05)
    val textStyle = CompassKoalaTheme.typography.h2
    val textColor = colors.textColor(enabled).value
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    BasicTextField(
        value = value,
        modifier = if (label != null) {
            modifier
                .semantics(mergeDescendants = true) {}
                .padding(top = Dimen.ui2)
        } else {
            modifier
        }
            .background(
                color = colors.backgroundColor(enabled).value,
                shape = shape
            )
            .defaultMinSize(
                minWidth = TextFieldDefaults.MinWidth
            ),
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = mergedTextStyle,
        cursorBrush = SolidColor(colors.cursorColor(isError).value),
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        interactionSource = interactionSource,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        decorationBox = @Composable { innerTextField ->
            TextFieldDefaults.OutlinedTextFieldDecorationBox(
                value = value.text,
                visualTransformation = visualTransformation,
                innerTextField = innerTextField,
                placeholder = placeholder?.let {{ PlaceholderText(placeholder = it) }},
                label = label?.let {{ LabelText(label = it) }},
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                singleLine = singleLine,
                enabled = enabled,
                isError = isError,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(Dimen.ui1_75),
                colors = colors,
                border = {
                    TextFieldDefaults.BorderBox(
                        enabled = enabled,
                        isError = isError,
                        interactionSource = interactionSource,
                        colors = colors,
                        shape = shape
                    )
                }
            )
        }
    )
}

@Composable
private fun LabelText(label: String) {
    Text(
        text = label,
        fontWeight = FontWeight.Medium,
        style = CompassKoalaTheme.typography.h2
    )
}

@Composable
private fun PlaceholderText(placeholder: String) {
    Text(
        text = placeholder,
        fontWeight = FontWeight.Normal,
        style = CompassKoalaTheme.typography.h2
    )
}

@Composable
private fun outlinedTextFieldColors(
    textColor: Color = CompassKoalaTheme.colors.secondary,
    disabledTextColor: Color = CompassKoalaTheme.colors.primaryVariantLight,
    backgroundColor: Color = Color.Transparent,
    cursorColor: Color = CompassKoalaTheme.colors.secondary,
    errorCursorColor: Color = CompassKoalaTheme.colors.secondary,
    focusedBorderColor: Color = CompassKoalaTheme.colors.secondary,
    unfocusedBorderColor: Color = CompassKoalaTheme.colors.primaryVariant,
    disabledBorderColor: Color = CompassKoalaTheme.colors.primaryVariantLight,
    errorBorderColor: Color = CompassKoalaTheme.colors.error,
    leadingIconColor: Color = CompassKoalaTheme.colors.secondary,
    disabledLeadingIconColor: Color = CompassKoalaTheme.colors.primaryVariantLight,
    errorLeadingIconColor: Color = CompassKoalaTheme.colors.error,
    trailingIconColor: Color = CompassKoalaTheme.colors.secondary,
    disabledTrailingIconColor: Color = CompassKoalaTheme.colors.primaryVariantLight,
    errorTrailingIconColor: Color = CompassKoalaTheme.colors.error,
    focusedLabelColor: Color = CompassKoalaTheme.colors.secondary,
    unfocusedLabelColor: Color = CompassKoalaTheme.colors.secondary,
    disabledLabelColor: Color = CompassKoalaTheme.colors.primaryVariant,
    errorLabelColor: Color = CompassKoalaTheme.colors.error,
    placeholderColor: Color = CompassKoalaTheme.colors.secondaryVariantLight,
    disabledPlaceholderColor: Color = CompassKoalaTheme.colors.primaryVariantLight
) = TextFieldDefaults.outlinedTextFieldColors(
    textColor = textColor,
    disabledTextColor = disabledTextColor,
    cursorColor = cursorColor,
    errorCursorColor = errorCursorColor,
    focusedBorderColor = focusedBorderColor,
    unfocusedBorderColor = unfocusedBorderColor,
    errorBorderColor = errorBorderColor,
    disabledBorderColor = disabledBorderColor,
    leadingIconColor = leadingIconColor,
    disabledLeadingIconColor = disabledLeadingIconColor,
    errorLeadingIconColor = errorLeadingIconColor,
    trailingIconColor = trailingIconColor,
    disabledTrailingIconColor = disabledTrailingIconColor,
    errorTrailingIconColor = errorTrailingIconColor,
    backgroundColor = backgroundColor,
    focusedLabelColor = focusedLabelColor,
    unfocusedLabelColor = unfocusedLabelColor,
    disabledLabelColor = disabledLabelColor,
    errorLabelColor = errorLabelColor,
    placeholderColor = placeholderColor,
    disabledPlaceholderColor = disabledPlaceholderColor
)
