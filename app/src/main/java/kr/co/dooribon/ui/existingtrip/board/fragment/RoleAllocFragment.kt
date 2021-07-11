package kr.co.dooribon.ui.existingtrip.board.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kr.co.dooribon.R
import kr.co.dooribon.databinding.FragmentBoardBottomBinding
import kr.co.dooribon.ui.existingtrip.board.fragment.adapter.BoardAdapter
import kr.co.dooribon.ui.existingtrip.board.fragment.adapter.BoardListData

class RoleAllocFragment : Fragment() {

    private lateinit var binding: FragmentBoardBottomBinding

    //private lateinit var dummyList: List<BoardListData>
    private var dummyList = listOf<BoardListData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_board_bottom, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentDetails()
        //setDummyList()
        setBoardAdapter()
        setBgVisibility()
        onAddBtnClickListener()
    }

    /* 추가하기 버튼 클릭 이벤트 처리 함수 */
    private fun onAddBtnClickListener() {
        binding.btAdd.setOnClickListener {
            val editDlg = Dialog(requireContext())
            editDlg.apply {
                setContentView(R.layout.dialog_edit_travel)
                findViewById<TextView>(R.id.tv_category).text = "역할 분담"
                findViewById<TextView>(R.id.tv_category_detail).text = "이번 여행에서 나는 이런 역할을 담당하게!"
                findViewById<EditText>(R.id.et_add_content).hint = "Ex. 인생사진은 나한테 맡겨!"
                findViewById<ImageView>(R.id.iv_category).setBackgroundResource(R.drawable.ic_icon_board_role_active)
                findViewById<Button>(R.id.bt_edit_travel_cancel).setOnClickListener {
                    dismiss()
                }
                findViewById<Button>(R.id.bt_edit_travel_ok).setOnClickListener {
                    dismiss()
                }
                show()
            }
        }
    }

    /***
     * 한 프래그먼트를 재활용해서 사용하기 때문에
     * 각 탭 레이아웃에 맞는 텍스트와 이미지를 넣어줘야 한다.
     */
    private fun setFragmentDetails() {
        binding.apply {
            tvTopic.text = getString(R.string.our_role)
            ivTopic.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_person_with_cloud
                )
            )
            tvMainTodo.text = getString(R.string.set_role_first)
            tvSubTodo.text = getString(R.string.set_role_first_detail)
        }
    }

    private fun setBgVisibility() {
        if (dummyList.isNotEmpty()) {
            binding.apply {
                ivTopic.visibility = View.GONE
                tvMainTodo.visibility = View.GONE
                tvSubTodo.visibility = View.GONE
            }
        }
    }

    private fun setBoardAdapter() {
        val boardAdapter = BoardAdapter()
        val boardRV = binding.rvTodoList
        boardAdapter.setItemList(dummyList)
        boardRV.adapter = boardAdapter
    }

    private fun setDummyList() {
        dummyList = listOf(
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("제주도 한라산 등산하기! 아침에 일찍 일어나서 꼭 갈거야 한라산...", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영"),
            BoardListData("인생 사진 찍어오기!", "김민영")
        )
    }
}