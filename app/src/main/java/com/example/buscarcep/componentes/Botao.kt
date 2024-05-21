package com.example.buscarcep.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.buscarcep.ui.theme.Teal700
import com.example.buscarcep.ui.theme.WHITE

@Composable
fun Botao(
    onClick: () -> Unit,
    texto: String,
    modifier: Modifier
) {

    androidx.compose.material.Button(
        onClick = onClick,
        colors = androidx.compose.material.ButtonDefaults.buttonColors(
            backgroundColor = Teal700
        ),
        modifier = modifier
    ) {
        Text(
            text = texto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = WHITE
        )
    }

}