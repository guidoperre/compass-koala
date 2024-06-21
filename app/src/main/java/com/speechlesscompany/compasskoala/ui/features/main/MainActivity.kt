package com.speechlesscompany.compasskoala.ui.features.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.speechlesscompany.compasskoala.ui.components.navigation.NavigationManager
import com.speechlesscompany.compasskoala.ui.components.snackbar.MainSnackbar
import com.speechlesscompany.compasskoala.ui.components.snackbar.SnackbarManager
import com.speechlesscompany.compasskoala.ui.navigation.directions.Directions
import com.speechlesscompany.compasskoala.ui.navigation.scheme.setNavigationScheme
import com.speechlesscompany.compasskoala.ui.styles.CompassKoalaTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
internal class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var snackbarManager: SnackbarManager

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSplashScreen()
        setScreenContent()
    }

    private fun setSplashScreen() {
        installSplashScreen()
    }

    private fun setScreenContent() {
        setContent {
            CompassKoalaTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val controller = rememberNavController()

                    navigationManager.setHostController(controller)

                    NavHost(
                        navController = controller,
                        startDestination = Directions.Home.destination
                    ) {
                        setNavigationScheme()
                    }

                    MainSnackbar(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .navigationBarsPadding(),
                        manager = snackbarManager
                    )
                }
            }
        }
    }
}
