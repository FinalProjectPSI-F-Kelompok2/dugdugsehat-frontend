package ac.id.ub.filkom.dugdugsehat

import ac.id.ub.filkom.dugdugsehat.navigation.Navigation
import ac.id.ub.filkom.dugdugsehat.navigation.Screen
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary400
import ac.id.ub.filkom.dugdugsehat.ui.theme.Primary500
import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@RequiresApi(Build.VERSION_CODES.S)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ) {
        Navigation(navController = navController)
    }
}

//@Composable
//fun BottomBar(navController: NavHostController) {
//    val screens = listOf(
//        Screen.HomeScreen,
//        Screen.HrCheckScreen,
//        Screen.EcgCheckScreen
//    )
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentDestination = navBackStackEntry?.destination
//
//    NavigationBar(
//        containerColor = Color.White
//    ) {
//        screens.forEach { screen ->
//            AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
//        }
//    }
//}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Screen.HomeScreen,
        Screen.HrCheckScreen,
        Screen.EcgCheckScreen,
        Screen.HistoryScreen,
        Screen.ProfileScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Check if the current destination is SignIn or SignUp
    val showBottomBar = when (currentDestination?.route) {
        Screen.SignIn.route, Screen.SignUp.route, Screen.Onboarding.route -> false
        else -> true
    }

    if (showBottomBar) {
        NavigationBar(
            containerColor = Color.White
        ) {
            screens.forEach { screen ->
                AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
            }
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: Screen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
   NavigationBarItem(
       icon = {
           if (currentDestination != null) {
               Icon(
                   painter = painterResource(if (currentDestination.route == screen.route) screen.selectedIconId else screen.unselectedIconId),
                   contentDescription = "Navigation Icon"
               )
           }
       },
       selected = currentDestination?.hierarchy?.any {
           it.route == screen.route
       } == true,
       onClick = {
           navController.navigate(screen.route)
       },
       colors = NavigationBarItemDefaults.colors(
           selectedIconColor = Primary400,
           unselectedIconColor = Color.LightGray
       )
   )
}