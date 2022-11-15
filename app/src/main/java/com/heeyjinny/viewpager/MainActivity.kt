package com.heeyjinny.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.heeyjinny.viewpager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)

        //1
        //탭 메뉴와 함께 뷰페이저에서 프래그먼트 사용방법
        //프래그먼트 화면4개 만들기
        //app - java디렉터리 밑 패키지명 우클릭 - New - Fragment - Fragment(Blank)
        //FragmentA.kt 생성
        //자동으로 같이 생성된 fragment_a.xml 수정
        //나머지 B,C,D도 똑같이 생성함

        //2
        //뷰페이저와 어댑터 생성하기
        //메인 레이아웃에 뷰페이저 배치 -> 액티비티 소스코드로 연결 -> 뷰페이저와 프래그먼트연결(프래그먼트어댑터)
        //뷰페이저: 리사이클러와 구현 방식이 비슷하지만 한 화면에 하나의 아이템만 보이는 뷰임
        //페이저어댑터: 뷰페이저는 페이저 어댑터를 통해서 뷰페이저에서 보일 화면들을 연결함
        //먼저 메인 레이아웃(activity_manin.xml)에 뷰페이저 배치

        //3
        //어댑터를 이용하여 프래그먼트와 뷰페이저 연결하기
        //여러개의 화면을 스와이프하여 넘길 수 있음

        //3-1
        //프래그먼트 목록 생성하여 변수 fragmentList에 담기
        val fragmentList = listOf( FragmentA(), FragmentB(), FragmentC(), FragmentD() )

        //3-2
        //어댑터 생성 후 어댑터에 프래그먼트 목록(fragmentList)변수 저장
        //어댑터 첫 번쨰 파라미터는 항상 supportFragmentManger fragmentActivity=this 사용...
        val adapter = FragmentAdapter(this)
        adapter.fragmentList = fragmentList

        //3-3
        //레이아웃의 뷰페이저의 어댑터 속성에 프래그먼트목록을 가지고 있는 프래그먼트어댑터 적용
        binding.viewPager.adapter = adapter

        //4
        //스와이프하여 넘길 수 있는 화면 상단에 탭 메뉴배치
        //스와이프 말고 상단 탭 메뉴 클릭 시에도 해당 프래그먼트로 이동할 수 있게 만들기

        //4-1
        //activity_main.xml 에서 탭 레이아웃을 뷰 페이저 위에 배치하고
        //TabLayoutMediator를 사용하여 탭레이아웃과 뷰페이저 연결

        //4-2
        //탭 레이아웃에 보여줄 메뉴명을 배열로 만들어 변수 tabTitles에 저장
        val tabTitles = listOf<String>("A","B","C","D")

        //4-3
        //TabLayoutMediator를 사용해 파라미터로 탭레이아웃과 뷰페이저를 전달하여 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->

            //코드블록으로 전달되는 tab파라미터의 text속성에 만들어둔 현재포지션보여주는 메뉴명변수 입력
            tab.text = tabTitles[position]

            //코드블록 끝에서 attach()메서드를 호출해 적용
        }.attach()

    }//onCreate
}//MainActivity