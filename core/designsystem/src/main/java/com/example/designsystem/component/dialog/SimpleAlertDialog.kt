package com.example.designsystem.component.dialog

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.designsystem.theme.AndroidArchitectureTemplateTheme

@Composable
fun simpleAlertDialog(
    title: String = "",
    message: String,
    onDismissRequest: (state: MutableState<Boolean>) -> Unit,
    positiveButtonText: String,
    negativeButtonText: String? = null,
    onPositiveClicked: () -> Unit,
    onNegativeClicked: (() -> Unit)? = null
): MutableState<Boolean> = remember { mutableStateOf(false) }.also {
    if (it.value) {
        AndroidArchitectureTemplateTheme {
            AlertDialog(
                onDismissRequest = { onDismissRequest(it) },
                title = {
                    Text(
                        text = title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                    )
                },
                text = {
                    Text(
                        text = message,
                        fontSize = 16.sp,
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            onPositiveClicked()
                            onDismissRequest(it)
                        }
                    ) {
                        Text(text = positiveButtonText)
                    }
                },
                dismissButton = negativeButtonText?.let { text ->
                    {
                        TextButton(
                            onClick = {
                                onNegativeClicked?.invoke()
                                onDismissRequest(it)
                            }
                        ) {
                            Text(text = text)
                        }
                    }
                }
            )
        }
    }
}