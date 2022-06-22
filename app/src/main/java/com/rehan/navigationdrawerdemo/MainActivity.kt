package com.rehan.navigationdrawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.google.android.material.navigation.NavigationView
import com.rehan.navigationdrawerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //DataBinding
    private lateinit var binding: ActivityMainBinding
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Pass the ActionBarToggle action into the drawerListener
        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, 0, 0)
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)

        //Display the hamburger icon to launch the drawer
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //Call syncState() on the action bar so it'll automatically change to the back button when the drawer layout is open
        actionBarDrawerToggle.syncState()

        //Call setNavigationItemSelectedListener on the NavigationView to detect when items are clicked
        binding.navigationView.setNavigationItemSelectedListener {menuItem ->

            when(menuItem.itemId){
                R.id.nav_home -> {
                    Toast.makeText(this, "Home button is clicked", Toast.LENGTH_LONG).show()
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_contact -> {
                    Toast.makeText(this, "Contact button is clicked", Toast.LENGTH_LONG).show()
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else ->{
                    Toast.makeText(this, "About button is clicked", Toast.LENGTH_LONG).show()
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
            }
        }
    }

    //use shortcut key ctrl+o to open dialog box and search for onSupportNavigateUp
    //override the onSupportNavigateUp() function to launch the Drawer when the hamburger icon is clicked
    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return super.onSupportNavigateUp()
    }

    //use shortcut key ctrl+o to open dialog box and search for onBackPressed
    //override the onBackPressed() function to close the Drawer when the back button is clicked
    override fun onBackPressed() {
        if(this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        super.onBackPressed()
    }
}