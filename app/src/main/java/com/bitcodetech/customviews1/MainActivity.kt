package com.bitcodetech.customviews1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var btnExit: ExitButton
    private lateinit var chkExit : CheckBox
    private lateinit var txtTaskView1 : TaskView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        setupListeners()

        /*btnExit = ExitButton(this)
        btnExit.layoutParams = ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        setContentView(btnExit)*/
    }

    private fun initViews() {
        btnExit = findViewById(R.id.btnExit)
        chkExit = findViewById(R.id.chkExitable)
        txtTaskView1 = findViewById(R.id.taskView1)
    }

    private fun setupListeners() {
        chkExit.setOnCheckedChangeListener(
            object : OnCheckedChangeListener {
                override fun onCheckedChanged(chk : CompoundButton?, isChecked : Boolean) {
                    btnExit.exitable = isChecked
                }
            }
        )


    }
}