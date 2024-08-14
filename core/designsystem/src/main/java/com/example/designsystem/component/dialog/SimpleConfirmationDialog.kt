package com.example.designsystem.component.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.example.designsystem.R

@Composable
fun simpleConfirmationDialog(
    title: String = "",
    message: String,
    onDismissRequest: (state: MutableState<Boolean>) -> Unit,
    positiveButtonText: String,
    negativeButtonText: String? = stringResource(R.string.cancel),
    onPositiveClicked: () -> Unit,
    onNegativeClicked: (() -> Unit)? = null,
): MutableState<Boolean> =
    simpleAlertDialog(
        title, message, onDismissRequest, positiveButtonText, negativeButtonText, onPositiveClicked, onNegativeClicked
    )