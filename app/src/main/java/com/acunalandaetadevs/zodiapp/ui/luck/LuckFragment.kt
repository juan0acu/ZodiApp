package com.acunalandaetadevs.zodiapp.ui.luck

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.acunalandaetadevs.zodiapp.R
import com.acunalandaetadevs.zodiapp.databinding.FragmentLuckBinding
import com.acunalandaetadevs.zodiapp.ui.core.listeners.OnSwipeTouchListener
import com.acunalandaetadevs.zodiapp.ui.providers.RandomCardProvider
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random
import javax.inject.Inject

@AndroidEntryPoint
class LuckFragment : Fragment() {

    private var _binding: FragmentLuckBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var randomCardProvider: RandomCardProvider

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        preparePrediction()
        initListener()
    }

    private fun preparePrediction() {
        val currentLuck = randomCardProvider.getLucky()
        currentLuck?.let {luck ->
            val currentPrediction = getString(luck.text)
            binding.tvLucky.text = currentPrediction
            binding.ivLuckyCard.setImageResource(luck.image)
            binding.tvShare.setOnClickListener { shareResult(currentPrediction) }
        }
    }

    private fun shareResult(prediction:String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT,prediction)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent,null)
        startActivity(shareIntent)
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListener() {
        //binding.ivRoulette.setOnClickListener { spinRoulette() }
        binding.ivRoulette.setOnTouchListener(object : OnSwipeTouchListener(requireContext()){
            override fun onSwipeRight() {
                spinRoulette()
            }

            override fun onSwipeLeft() {
                spinRoulette()
            }
        })
    }

    private fun spinRoulette() {

        val random = Random()
        val grados_rotar = random.nextInt(1440) + 360

        val animator =
            ObjectAnimator.ofFloat(binding.ivRoulette, View.ROTATION, 0f, grados_rotar.toFloat())
        animator.duration = 2000
        animator.interpolator = DecelerateInterpolator()
        animator.doOnEnd { slideCard() }
        animator.start()
    }

    private fun slideCard() {
        val slideUpAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.slide_up)
        slideUpAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                binding.reverse.isVisible = true
            }

            override fun onAnimationEnd(p0: Animation?) {
                groupCard()
            }

            override fun onAnimationRepeat(p0: Animation?) {}

        })
        binding.reverse.startAnimation(slideUpAnimation)
    }

    private fun groupCard() {
        val groupAnimation = AnimationUtils.loadAnimation(requireContext(), R.anim.grow)
        groupAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                binding.reverse.isVisible = false
                showPremonitionVire()
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.reverse.startAnimation(groupAnimation)
    }

    private fun showPremonitionVire() {
        val disapperarAnimation = AlphaAnimation(1.0f, 0.0f)
        disapperarAnimation.duration = 200

        val appearAnimation = AlphaAnimation(0.0f,1.0f)
        appearAnimation.duration = 1000

        disapperarAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {}

            override fun onAnimationEnd(p0: Animation?) {
                binding.preview.isVisible = false
                binding.prediction.isVisible = true
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })
        binding.preview.startAnimation(disapperarAnimation)
        binding.prediction.startAnimation(appearAnimation)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLuckBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}