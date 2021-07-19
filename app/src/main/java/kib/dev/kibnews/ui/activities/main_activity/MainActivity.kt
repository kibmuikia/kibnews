package kib.dev.kibnews.ui.activities.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kib.dev.kibnews.R

class MainActivity : AppCompatActivity() {

    companion object {
        val logTag = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(getNavController(), appBarConfiguration)
        getBottomNavView().setupWithNavController(getNavController())
    }

    private fun getNavController(): NavController {
        return findNavController(R.id.nav_host_fragment)
    }

    private fun getBottomNavView(): BottomNavigationView {
        return findViewById(R.id.bottom_nav_view_act_main)
    }

}//: MainActivity