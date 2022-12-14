package com.esaudev.bottomnavbackstacks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.esaudev.bottomnavbackstacks.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fMain) as NavHostFragment?
        val navController = navHostFragment?.navController

        binding.bnvMainMenu.apply {
            navController?.let { navController ->
                NavigationUI.setupWithNavController(
                    this,
                    navController
                )
                setOnItemSelectedListener { item ->
                    NavigationUI.onNavDestinationSelected(item, navController)
                    true
                }
                setOnItemReselectedListener {
                    val selectedMenuItemNavGraph =
                        navController.graph.findNode(it.itemId) as NavGraph
                    selectedMenuItemNavGraph.let { menuGraph ->

                        navController.popBackStack(menuGraph.startDestinationId, false)
                    }
                }
            }
        }
    }
}