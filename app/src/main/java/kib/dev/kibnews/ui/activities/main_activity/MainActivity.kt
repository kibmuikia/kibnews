package kib.dev.kibnews.ui.activities.main_activity

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
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

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setup()
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)
    }

    private fun setup() {
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_search, R.id.navigation_settings
            )
        )
        setupActionBarWithNavController(getNavController(), appBarConfiguration)
        getBottomNavView().setupWithNavController(getNavController())
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.loading.observe(this, {
            showLoading(it)
        })
    }

    private fun getNavController(): NavController {
        return findNavController(R.id.nav_host_fragment)
    }

    private fun getBottomNavView(): BottomNavigationView {
        return findViewById(R.id.bottom_nav_view_act_main)
    }

    fun showLoading(gotLoading: Boolean) {
        if (gotLoading) {
            Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
        }
    }

}//: MainActivity