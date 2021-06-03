package hr.ferit.lloina.lv5_soundboard

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.lloina.lv5_soundboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding;
    val soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
        val attributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build()
        SoundPool.Builder()
                .setAudioAttributes(attributes)
                .setMaxStreams(5)
                .build()
    } else {
        SoundPool(5, AudioManager.STREAM_MUSIC, 0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val sounds = mapOf(
                "airhorn" to soundPool.load(this.applicationContext, R.raw.airhorn, 1),
                "bike" to soundPool.load(this.applicationContext, R.raw.bikehorn, 1),
                "doorbell" to soundPool.load(this.applicationContext, R.raw.doorbell, 1),
                "foghorn" to soundPool.load(this.applicationContext, R.raw.foghorn, 1)
        )

        binding.imgBtnAir.setOnClickListener {
            val sound = sounds["airhorn"] ?: return@setOnClickListener
            soundPool.play(sound, 1.0f, 1.0f, 1, 0, 1f)
        }

        binding.imgBtnBike.setOnClickListener {
            val sound = sounds["bike"] ?: return@setOnClickListener
            soundPool.play(sound, 1.0f, 1.0f, 1, 0, 1f)
        }

        binding.imgBtnDoor.setOnClickListener {
            val sound = sounds["doorbell"] ?: return@setOnClickListener
            soundPool.play(sound, 1.0f, 1.0f, 1, 0, 1f)
        }

        binding.imgBtnFog.setOnClickListener {
            val sound = sounds["foghorn"] ?: return@setOnClickListener
            soundPool.play(sound, 1.0f, 1.0f, 1, 0, 1f)
        }

        setContentView(binding.root)
    }

}