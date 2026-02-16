package foi.cverglici.wear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.runtime.Composable
import foi.cverglici.wear.theme.WearAppTheme
import foi.cverglici.wear.ui.MenuScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()

        super.onCreate(savedInstanceState)

        setTheme(android.R.style.Theme_DeviceDefault)

        setContent {
            WearAppTheme {
                MenuScreen()
            }
        }
    }
}

@Composable
fun WearApp() {
    WearAppTheme {
        MenuScreen()
    }
}