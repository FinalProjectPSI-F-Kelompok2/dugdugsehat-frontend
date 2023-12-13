package ac.id.ub.filkom.dugdugsehat.navigation

import ac.id.ub.filkom.dugdugsehat.R


sealed class Screen(
    val route: String,
    val unselectedIconId: Int,
    val selectedIconId: Int
) {
    object Onboarding: Screen(route = "Onboarding", unselectedIconId = 0, selectedIconId = 0)
    object SignIn: Screen(route = "Signin", unselectedIconId = 0, selectedIconId = 0)
    object SignUp: Screen(route = "Signup", unselectedIconId = 0, selectedIconId = 0)
    object HomeScreen: Screen(route = "home_screen", unselectedIconId = R.drawable.home_vector, selectedIconId = R.drawable.selected_home_vector)
    object HrCheckScreen: Screen(route = "hr_check_screen", unselectedIconId = R.drawable.ic_heart_icon, selectedIconId = R.drawable.selected_ic_heart_icon)
    object EcgCheckScreen: Screen(route = "ecg_check_screen", unselectedIconId = R.drawable.ic_bolt_icon, selectedIconId = R.drawable.selected_ic_bolt_icon)
    object HistoryScreen: Screen(route = "history_screen", unselectedIconId = R.drawable.ic_clock_icon, selectedIconId = R.drawable.selected_ic_clock_icon)
    object ProfileScreen: Screen(route = "profile_screen", unselectedIconId = R.drawable.profile, selectedIconId = R.drawable.selected_ic_profile)
}