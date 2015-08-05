package com.laprasdrum.sparrow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.MenuItemCompat
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import kotlin.properties.Delegates


class MainFragment : Fragment(), SearchView.OnQueryTextListener, View.OnFocusChangeListener {

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val textLabel: TextView by bindView(R.id.label)
    val helloButton: Button by bindView(R.id.button)

    var searchView: SearchView by Delegates.notNull()
    var friendList: Array<String> by Delegates.notNull()

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super<Fragment>.onActivityCreated(savedInstanceState)

        setupInitValues()
        setupToolbar()
        setupViews()
    }

    private fun setupInitValues() {
        friendList = getResources().getStringArray(R.array.friends)
    }

    private fun setupToolbar() {
        toolbar.setTitle("title")
        toolbar.inflateMenu(R.menu.menu_main)

        val searchItem: MenuItem = toolbar.getMenu().findItem(R.id.action_search)
        val searchView: View = MenuItemCompat.getActionView(searchItem)
        if (searchView is SearchView) {
            this.searchView = searchView
            this.searchView.setQueryHint("enter keyword...")
            this.searchView.setOnQueryTextListener(this)
            this.searchView.setOnQueryTextFocusChangeListener(this)
        }
    }

    private fun setupViews() {
        textLabel.setText("hello")
        helloButton.setOnClickListener {
            Log.i("tag", "hello")
            Log.d("tag", "world")
        }
    }

    private fun filterList(query: String?) {
        if (query.isNullOrEmpty()) return

        textLabel.setText("")
        var filteredList = friendList.filter { it.contains(query!!) }
        if (filteredList.isEmpty()) textLabel.append("no matches")
        else filteredList.forEach { textLabel.append(it + '\n') }

        Log.i("TAG", "filtered")
    }

    private fun clearSearchList() {
        textLabel.setText("aaaaa\nbbbbb\nccccc\n")
        Log.i("TAG", "clear filtering")
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        when (newText.isNullOrEmpty()) {
            true -> clearSearchList()
            false -> filterList(newText)
        }
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onFocusChange(v: View?, hasFocus: Boolean) {
        Log.i("TAG", "focus changed: " + if (hasFocus) {
            "focused"
        } else {
            "not focused"
        })
        if (!hasFocus) textLabel.setText("aaaaa\nbbbbb\nccccc\n")
        else {
            Log.i("TAG", "query: " + searchView.getQuery())
        }
    }

    public fun String.contains(seq: String, ignoreCase: Boolean = false): Boolean =
            this.indexOf(seq, ignoreCase = ignoreCase) >= 0
}