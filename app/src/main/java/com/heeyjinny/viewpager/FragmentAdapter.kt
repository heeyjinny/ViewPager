package com.heeyjinny.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

//1
//마지 리사이클러뷰에서 Adapter를 상속받아 커스텀어댑터를 만든 것처럼...
//프래그먼트는 FragmentStateAdapter를 상속받아 어댑터를 생성함
//상속받을 때 생성자()를 생략하고 상속받은 다음 부모클래스에 option + Enter를 눌러
//add constructor parameters...(FragmentActivity) 선택해 생성자 추가하고
//class FragmentAdapter에 인터페이스를 implement함
class FragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    //2
    //화면에 표시해줄 아이템의 목록 변수로 만들고 초기화
    //메뉴로 사용하는 뷰페이저의 화면 아이템은 중간에 개수가 늘지 않고 처음 개수 그대로 사용(listOf())
    var fragmentList = listOf<Fragment>()

    //3
    //상속하는 FragmentStateAdapter의 필수 메서드
    //createFragment() : 현재 페이지의 포지션이 파라미터로 넘어오고
    //포지션에 해당하는 위치의 프래그먼트를 만들어 안드로이드에 반환
    //getItemCount() : 어탭터가 화면에 보여줄 전체 프래그먼트의 개수 반환
    override fun getItemCount(): Int {
        //3-1
        //페이지의 개수 결정을 위한 프래그먼트 개수 리턴
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        //3-2
        //페이지 요청 시 getItem으로 페이지의 포지션 값이 넘어옴
        //넘어온 포지션 값을 이용하여 프래그먼트 목록 중 현재 포지션 프래그먼트 1개 리턴
        //return fragmentList.get(position)
        //get없이 사용 : fragmentList의 인덱스 값 []을 포지션으로 지정사용
        return fragmentList[position]
    }

    //4
    //어댑터를 이용해 만들어두었던 프래그먼트들을 액티비티에서 연결
    //MainActivity.kt...

}//class...