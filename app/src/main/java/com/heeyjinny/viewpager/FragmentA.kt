package com.heeyjinny.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//class FragmentB, FragmentC, FragmentD도 새 fragment파일로 생성
class FragmentA : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //프래그먼트 복사+붙여넣기 시 inflate의 레이아웃을 해당 레이아웃으로 변경시켜줘야 함...
        //(ex. FragmentB 생성: R.layout.fragment_a -> R.layout.fragment_b )
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

}