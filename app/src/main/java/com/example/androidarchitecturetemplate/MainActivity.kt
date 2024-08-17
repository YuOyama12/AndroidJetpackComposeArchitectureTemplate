package com.example.androidarchitecturetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidarchitecturetemplate.ui.BaseApp
import com.example.androidarchitecturetemplate.ui.rememberBaseAppState
import com.example.data.util.NetworkMonitor
import com.example.designsystem.theme.AndroidArchitectureTemplateTheme
import com.example.feature.home.HomeScreen
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.plant(Timber.DebugTree())

        setContent {
            AndroidArchitectureTemplateTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val appState = rememberBaseAppState(
                        networkMonitor = networkMonitor
                    )

                   BaseApp(appState = appState)
                }
            }
        }
    }
}
