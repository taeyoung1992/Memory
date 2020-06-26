package com.gmail.moontae0317.memory.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.moontae0317.memory.database.MemoryDatabase
import com.gmail.moontae0317.memory.R
import com.nightonke.boommenu.BoomButtons.HamButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var db : MemoryDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_user.text = getSharedPreferences("user", Context.MODE_PRIVATE).getString("userName","null")

        btn_databaseTest.setOnClickListener {
            var intent = Intent(this,
                DatabaseTestActivity::class.java)
            startActivity(intent)
        }

//        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
//            HamButton.Builder builder = new HamButton.Builder()
//                .normalImageRes(R.drawable.butterfly)
//                .normalTextRes("Butter Doesn't fly!")
//                .subNormalTextRes("Little butter Doesn't fly, either!");
//            bmb.addBuilder(builder);
//        }


        val builder = HamButton.Builder().normalImageRes(R.drawable.apple).normalText("apple1").subNormalText("사과")
        bmb.addBuilder(builder)
        val builder1 = HamButton.Builder().normalImageRes(R.drawable.apple).normalText("apple2").subNormalText("사과")
        bmb.addBuilder(builder1)
        val builder2 = HamButton.Builder().normalImageRes(R.drawable.apple).normalText("apple3").subNormalText("사과")
        bmb.addBuilder(builder2)
        val builder3 = HamButton.Builder().normalImageRes(R.drawable.apple).normalText("apple4").subNormalText("사과")
        bmb.addBuilder(builder3)
        val builder4 = HamButton.Builder().normalImageRes(R.drawable.apple).normalText("appl5").subNormalText("사과")
        bmb.addBuilder(builder4)
    }
}
