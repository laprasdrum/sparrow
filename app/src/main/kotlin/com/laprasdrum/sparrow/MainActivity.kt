package com.laprasdrum.sparrow

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlin.properties.Delegates

public class MainActivity : AppCompatActivity() {

    var pagerAdapter: SectionsPagerAdapter by Delegates.notNull()
    var viewPager: ViewPager by Delegates.notNull()
    var tabLayout: TabLayout by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var toolbar: Toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        pagerAdapter = SectionsPagerAdapter(getSupportFragmentManager())

        viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.setAdapter(pagerAdapter)

        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        tabLayout = findViewById(R.id.tab_layout) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }

    public inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return PlaceholderFragment.newInstance(position + 1)
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return getString(R.string.title_section1)
                1 -> return getString(R.string.title_section2)
                2 -> return getString(R.string.title_section3)
            }
            return null
        }
    }

    public class PlaceholderFragment : Fragment() {

        override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val rootView = inflater!!.inflate(R.layout.fragment_main, container, false)
            val labelView: TextView = rootView.findViewById(R.id.label) as TextView

            val position: Int = getArguments().getInt(ARG_SECTION_NUMBER)
            val label = when (position) {
                1 -> "page 1"
                2 -> "page 2"
                3 -> "page 3"
                else -> {
                    "no position matched"
                }
            }
            labelView.setText(label)
            return rootView
        }

        companion object {
            private val ARG_SECTION_NUMBER = "section_number"

            public fun newInstance(sectionNumber: Int): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                fragment.setArguments(args)
                return fragment
            }
        }
    }

}
