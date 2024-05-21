package com.example.buscarcep.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.buscarcep.ui.theme.Teal700

@Composable
fun CaixaTexto(
    value: String,
    onValue: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValue,
        label = {
            Text(text = label)
        },
        keyboardOptions = keyboardOptions,
        modifier = modifier,
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Teal700,
            focusedLabelColor = Teal700,
            focusedBorderColor = Teal700,
            cursorColor = Teal700
        )
    )

}