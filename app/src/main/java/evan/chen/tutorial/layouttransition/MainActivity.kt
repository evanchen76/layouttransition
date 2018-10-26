package evan.chen.tutorial.layouttransition

import android.animation.*
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var i = 0
    lateinit var layoutTransition: LayoutTransition

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addLayout.setOnClickListener {
            addButtonView()
        }

        removeLayout.setOnClickListener {
            removeButtonView()
        }

        initTransition()

    }

    private fun addButtonView() {
        i += 1
        val button = Button(this)
        button.text = "button$i"
        val params = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        resultLayout.addView(button, 0, params)
    }

    private fun removeButtonView() {
        if (resultLayout.childCount > 0)
            resultLayout.removeViewAt(0)
    }

    private fun initTransition() {
        layoutTransition = LayoutTransition()
        resultLayout.layoutTransition = layoutTransition

        //View出現的動畫
        layoutTransition.setAnimator(LayoutTransition.APPEARING, AnimatorInflater.loadAnimator(this, R.animator.anim_scale_x))

        //元素在容器中消失時需要動畫顯示
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, AnimatorInflater.loadAnimator(this, R.animator.anim_color))

        layoutTransition.setAnimator(LayoutTransition.CHANGE_APPEARING, AnimatorInflater.loadAnimator(this, R.animator.layout_change_appearing))

        layoutTransition.setAnimator(LayoutTransition.CHANGE_DISAPPEARING, AnimatorInflater.loadAnimator(this, R.animator.layout_change_disappearing))
    }
}
