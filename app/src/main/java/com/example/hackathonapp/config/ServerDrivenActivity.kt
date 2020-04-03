package com.example.hackathonapp.config

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ServerDrivenState
import com.example.hackathonapp.R
import com.google.android.material.snackbar.Snackbar

@BeagleComponent
class ServerDrivenActivity : BeagleActivity() {

    private lateinit var mToolbar: Toolbar
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_server_driven)

        mToolbar = findViewById(R.id.toolbar)
        progressBar = findViewById(R.id.progress_bar)
    }

    override fun getServerDrivenContainerId(): Int =
        R.id.server_driven_container

    override fun getToolbar(): Toolbar = mToolbar

    override fun onServerDrivenContainerStateChanged(state: ServerDrivenState) {
        if (state is ServerDrivenState.Loading) {
            progressBar.visibility = if (state.loading) View.VISIBLE else View.GONE
        } else if (state is ServerDrivenState.Error) {
            progressBar.visibility = View.GONE
            Snackbar.make(findViewById(android.R.id.content), "Error", Snackbar.LENGTH_LONG).show()
        }
    }

}