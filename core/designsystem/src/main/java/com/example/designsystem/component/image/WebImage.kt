package com.example.designsystem.component.image

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.designsystem.R

@Composable
fun WebImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentScale: ContentScale = ContentScale.Fit
) {
    val context = LocalContext.current
    var isLoadingSuccessful by remember { mutableStateOf(false) }

    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .run {
                if (isLoadingSuccessful) this
                else this
                // ここでURLのロード中画像やエラー画像を指定
            }
            .build(),
        contentDescription = null,
        contentScale = contentScale,
        onSuccess = { isLoadingSuccessful = true },
        imageLoader = ImageLoader(context)
    )
    
}