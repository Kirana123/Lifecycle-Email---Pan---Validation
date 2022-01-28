package com.example.validation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val email: EditText = findViewById(R.id.Email)
        val pan: EditText = findViewById(R.id.Pan)
        val btn: Button = findViewById(R.id.btn_submit)

        email.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: Int, p2: Int, p3: Int
            ) {
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: Int, p2: Int, p3: Int
            ) {
                // check inputted text that it is a valid email address or not
                if (p0.isValidEmail()) {
                    btn.isEnabled = true;
                } else {
                    btn.isEnabled = false;
                    email.error = "Invalid E-mail."
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        pan.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (panValidate(pan.text.toString()))
                    btn.isEnabled = true;
                else {
                    btn.isEnabled = false;
                    pan.setError("Invalid PAN")
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        btn.setOnClickListener {
            Toast.makeText(this, "Email and Pan Saved Successfully.!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "Start!", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Resume!", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Pause!", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Stop!", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Restart!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "Destroy!", Toast.LENGTH_SHORT).show()
    }

    fun CharSequence?.isValidEmail(): Boolean {
        return !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    private fun panValidate(text: String?): Boolean {
        var p = Pattern.compile("(([A-Za-z]{5})([0-9]{4})([a-zA-Z]))")
        var m = p.matcher(text)
        return m.matches()
    }
}
