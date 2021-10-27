/*

build.gradle dosyasına aşağıdaki kodu ekliyoruz öncelikle:

dependencies {
	implementation 'com.github.hotchemi:android-rate:1.0.1'
}


* */

package com.example.ratetheapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import hotchemi.android.rate.AppRate;

public class MainActivity
        extends AppCompatActivity {

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Burada 0, kurulum tarihini ifade etmektedir.
        AppRate.with(this)


                // iletişim kutusunun uygulamanın
                // yüklendiği günden belirli bir gün sonra görünmesine olanak tanır.
                // default 10
                .setInstallDays(1)
                //uygulamanın kullanıcı tarafından minimum kaç
                // kez başlatılması gerektiği
                // default 10
                .setLaunchTimes(3)

                //kullanıcı tarafsız seçeneği (Daha sonra hatırlat) seçtikten sonra
                // iletişim kutusunun gelmesi için geçen gün sayısıdır.
                // default 1
                .setRemindInterval(1).
                monitor();

        // Koşulları karşılıyor ise bir diyalog göster.
        AppRate.showRateDialogIfMeetsConditions(this);
    }
}
