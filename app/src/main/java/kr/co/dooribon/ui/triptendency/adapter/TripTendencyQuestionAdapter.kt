package kr.co.dooribon.ui.triptendency.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.dooribon.R
import kr.co.dooribon.databinding.ViewTestTripTendencyQuestionBinding
import kr.co.dooribon.domain.entity.TripTendency
import kr.co.dooribon.ui.triptendency.viewModel.TripTendencyViewModel

class TripTendencyQuestionAdapter(
    private val onItemClicked: (idx: Int) -> Unit,
    private val viewModel: TripTendencyViewModel
) :
    RecyclerView.Adapter<TripTendencyQuestionAdapter.TripTendencyQuestionViewHolder>() {

    private val problemList = mutableListOf<TripTendency.TripTendencyQuestion>()

    private val lastSelectedPosition
        get() = viewModel.lastQuestionSelectedPosition.value!![viewModel.questionPosition.value!!]

    inner class TripTendencyQuestionViewHolder(private val binding: ViewTestTripTendencyQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.onClick = {
                notifyItemRangeChanged(0, problemList.size)
                onItemClicked(adapterPosition)
            }
        }

        fun bind(item: TripTendency.TripTendencyQuestion) {
            binding.item = item
            if (lastSelectedPosition == adapterPosition) {
                binding.card.setCardBackgroundColor(Color.parseColor("#6B8FF9"))
                binding.tvTestTripTendencyProblemNumber.apply {
                    setBackgroundResource(R.drawable.circle_white)
                    setTextColor(Color.parseColor("#6B8FF9"))
                }
                binding.tvTestTripTendencyProblemSubject.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                binding.card.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
                binding.tvTestTripTendencyProblemNumber.apply {
                    setBackgroundResource(R.drawable.circle_sub_orange1)
                    setTextColor(Color.parseColor("#FFFFFF"))
                }
                binding.tvTestTripTendencyProblemSubject.setTextColor(Color.parseColor("#000000"))
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TripTendencyQuestionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewTestTripTendencyQuestionBinding.inflate(layoutInflater, parent, false)
        return TripTendencyQuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TripTendencyQuestionViewHolder, position: Int) {
        holder.bind(problemList[position])
    }

    override fun getItemCount(): Int = problemList.size

    fun submitItem(list: List<TripTendency.TripTendencyQuestion>) {
        problemList.clear()
        problemList.addAll(list)
        notifyDataSetChanged()
    }
}