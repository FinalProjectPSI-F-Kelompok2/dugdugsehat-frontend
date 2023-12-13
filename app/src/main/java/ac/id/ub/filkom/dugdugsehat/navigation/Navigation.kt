package ac.id.ub.filkom.dugdugsehat.navigation

import ac.id.ub.filkom.dugdugsehat.Historyscreen
import ac.id.ub.filkom.dugdugsehat.OnboardingPreview
import ac.id.ub.filkom.dugdugsehat.OnboardingScreen
import ac.id.ub.filkom.dugdugsehat.SigninScreen
import ac.id.ub.filkom.dugdugsehat.SignupScreen
import ac.id.ub.filkom.dugdugsehat.check.ecg.EcgCheckScreen
import ac.id.ub.filkom.dugdugsehat.check.hr.HrCheckScreen
import ac.id.ub.filkom.dugdugsehat.home.HomeScreen
import ac.id.ub.filkom.dugdugsehat.home.HomeViewModel
import ac.id.ub.filkom.dugdugsehat.viewmodel.UserViewModel
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ac.id.ub.filkom.dugdugsehat.ProfileScreen
import ac.id.ub.filkom.dugdugsehat.viewModel.MainViewModel


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController , startDestination = Screen.Onboarding.route) {
//        navigation(
//            startDestination = Screen.SignIn.route,
//            route = Screen.HomeScreen.route
//        ) {
//            composable(route = Screen.SignIn.route){
//                val viewModel = it.sharedViewModel<MainViewModel>(navController = navController)
//                SigninScreen(navController, viewModel)
//            }
//            composable(route = Screen.SignUp.route){
////                val viewModel = it.sharedViewModel<MainViewModel>(navController = navController)
//                SignupScreen()
//            }
//        }
        composable(route = Screen.Onboarding.route) {
            OnboardingScreen(navController)
        }
        composable(route = Screen.SignIn.route) {
            val viewModel = it.sharedViewModel<UserViewModel>(navController = navController)
            SigninScreen(navController, viewModel)
        }
        composable(route = Screen.SignUp.route) {
            SignupScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            val viewModel = it.sharedViewModel<UserViewModel>(navController = navController)
            HomeScreen(HomeViewModel(), viewModel)
        }
            composable(route = Screen.HrCheckScreen.route) {
                HrCheckScreen()
            }
            composable(route = Screen.EcgCheckScreen.route) {
                EcgCheckScreen()
            }
            composable(route = Screen.HistoryScreen.route) {
                val viewModel = it.sharedViewModel<UserViewModel>(navController = navController)
                Historyscreen(viewModel)
            }
            composable(route = Screen.ProfileScreen.route){
                ProfileScreen()
            }
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}