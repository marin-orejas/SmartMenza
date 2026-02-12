package foi.cverglici.smartmenza

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import foi.cverglici.navigation.NavigationManager
import foi.cverglici.navigation.Enums.NavigationRole
import foi.cverglici.topbar.TopBarConfig
import foi.cverglici.topbar.TopBarManager
import foi.cverglici.topbar.listeners.OnTopBarActionListener
import foi.cverglici.smartmenza.session.SessionManager
import foi.cverglici.smartmenza.ui.employee.ai.tools.AiToolsFragment
import foi.cverglici.smartmenza.ui.employee.menu.EmployeeMenuListFragment
import foi.cverglici.smartmenza.ui.employee.statistics.StatisticsFragment
import foi.cverglici.smartmenza.ui.student.favorites.FavoritesFragment
import foi.cverglici.smartmenza.ui.student.menu.MenuListFragment
import foi.cverglici.smartmenza.ui.student.goals.GoalsFragment
import foi.cverglici.core.data.model.wear.WearMenuItem
import foi.cverglici.smartmenza.wear.MenuSyncManager

class MainActivity : AppCompatActivity(), OnTopBarActionListener {

    private lateinit var sessionManager: SessionManager
    private lateinit var navigationManager: NavigationManager
    private lateinit var topBarManager: TopBarManager
    private lateinit var bottomNavigation: BottomNavigationView
    private val menuSyncManager by lazy { MenuSyncManager(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sessionManager = SessionManager(applicationContext)

        if (!sessionManager.isLoggedIn()) {
            navigateToLogin()
            return
        }

        // Initialize views
        val topBarView = findViewById<android.view.View>(R.id.topBar)
        bottomNavigation = findViewById(R.id.bottomNavigation)

        // Setup TopBar
        topBarManager = TopBarManager(this, topBarView)
        setupTopBar()

        // Setup Navigation
        navigationManager = NavigationManager(
            activity = this,
            containerId = R.id.fragmentContainer,
            bottomNavigationView = bottomNavigation
        )

        if (savedInstanceState == null) {
            setupNavigationBasedOnRole()
        }
    }

    private fun setupTopBar() {
        val config = when {
            sessionManager.isStudent() -> TopBarConfig(
                title = "Smart Menza - Student",
                backgroundColor = R.color.orange_primary,
                textColor = R.color.white,
                showUserMenu = true,
                showSyncWatch = true
            )
            sessionManager.isEmployee() -> TopBarConfig(
                title = "Smart Menza - Zaposlenik",
                backgroundColor = R.color.soft_teal,
                textColor = R.color.white,
                showUserMenu = true,
                showSyncWatch = false
            )
            else -> TopBarConfig(
                title = getString(R.string.app_name),
                showUserMenu = true,
                showSyncWatch = false
            )
        }

        topBarManager.setup(config, this)
    }

    override fun onLogoutClicked() {
        logout()
    }

    override fun onSyncWatchClicked() {
        if (!sessionManager.isStudent()) {
            Toast.makeText(this, "Opcija dostupna samo studentima", Toast.LENGTH_SHORT).show()
            return
        }

        syncMenuToWatch()
    }

    private fun syncMenuToWatch() {
        val testItems = listOf(
            WearMenuItem(
                title = "Test juha",
                price = 1.5,
                calories = 120,
                description = "Topla povrtna juha"
            ),
            WearMenuItem(
                title = "Test glavno jelo",
                price = 3.8,
                calories = 650,
                description = "Piletina s rižom i salatom"
            )
        )

        if (testItems.isEmpty()) {
            Toast.makeText(this, "Nema menija za slanje.", Toast.LENGTH_SHORT).show()
            return
        }

        menuSyncManager.syncMenuToWatch(testItems)

        Toast.makeText(this, "Meni poslan na sat.", Toast.LENGTH_SHORT).show()
    }

    private fun setupNavigationBasedOnRole() {
        when {
            sessionManager.isStudent() -> {
                navigationManager.setupNavigation(NavigationRole.STUDENT, ::getFragmentForTag)
            }
            sessionManager.isEmployee() -> {
                navigationManager.setupNavigation(NavigationRole.EMPLOYEE, ::getFragmentForTag)
            }
            else -> {
                Toast.makeText(this, "Nepoznata uloga korisnika", Toast.LENGTH_LONG).show()
                logout()
            }
        }
    }

    private fun getFragmentForTag(tag: String): Fragment {
        return when (tag) {
            "menu" -> MenuListFragment()
            "favorites" -> FavoritesFragment()
            "goals" -> GoalsFragment()
            "employee_menu" -> EmployeeMenuListFragment()
            "statistics" -> StatisticsFragment()
            "ai_tools" -> AiToolsFragment()
            else -> MenuListFragment()
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }

    fun logout() {
        sessionManager.logout()
        navigateToLogin()
    }
}