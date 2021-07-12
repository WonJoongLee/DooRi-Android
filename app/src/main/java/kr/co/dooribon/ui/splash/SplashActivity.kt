package kr.co.dooribon.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kr.co.dooribon.R
import kr.co.dooribon.application.MainApplication.Companion.sharedPreferenceModule
import kr.co.dooribon.databinding.ActivitySplashBinding
import kr.co.dooribon.di.SharedPreferenceModule
import kr.co.dooribon.ui.home.HomeActivity
import kr.co.dooribon.utils.getIntent
import kr.co.dooribon.utils.shortToast

class SplashActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted{
            delay(2000)
            if(sharedPreferenceModule.isFirstLaunch){
                shortToast("온보딩이 시작되면 됩니다.")
                startActivity(getIntent<HomeActivity>())
            }else{
                shortToast("온보딩이 시작되지 않으면 됩니다.")
                startActivity(getIntent<HomeActivity>())
            }
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
            finish()
        }


    }
}