package com.laprasdrum.sparrow

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import butterknife.bindView
import com.laprasdrum.sparrow.flux.actions.SampleActions
import com.laprasdrum.sparrow.flux.stores.SampleStore
import com.laprasdrum.sparrow.inject.Injector
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.subscriptions.CompositeSubscription
import javax.inject.Inject

public class SampleFragment : Fragment() {
    val button1: Button by bindView(R.id.button1)
    val button2: Button by bindView(R.id.button2)
    val button3: Button by bindView(R.id.button3)
    val logView: TextView by bindView(R.id.log_view)

    var sampleActions: SampleActions? = null
        @Inject set
    var sampleStore: SampleStore? = null
        @Inject set

    val subscriptions: CompositeSubscription = CompositeSubscription()

    companion object {
        fun newInstance(): SampleFragment {
            return SampleFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_network_queue, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Injector.get().inject(this)

        sampleActions?.initialize()
        setupReactions()
        setupViews()
    }

    private fun setupReactions() {
        subscriptions.add(
                sampleStore?.editedNameSubject
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe(Action1 { onCompanyNameEdited() })
        )
        subscriptions.add(
                sampleStore?.editedCompanyProfileSubject
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe(Action1 { onCompanyProfileEdited() })
        )
    }

    private fun setupViews() {
        button1.setOnClickListener {
            sampleActions?.editCompanyName("beluga co.ltd,")
        }

        button2.setOnClickListener {
            //            val response = NetworkDispatcher.tryNetworkRequest(NetworkAction({
            //                logView.append("network request sent\n")
            //            }))
            //            logView.append(response + "\n")
            sampleActions?.editCompanyProfile("kitten inc.", "laprasdrum@yuyacat.com")
        }
    }

    fun onCompanyNameEdited() {
        val companyName = sampleStore?.company?.name ?: "null"
        logView.append(companyName + "\n")
    }

    fun onCompanyProfileEdited() {
        val message: String? = "name: ${sampleStore?.company?.name ?: "unregistered"}\nemail: ${sampleStore?.company?.email ?: "unregistered"}"
        logView.append("${message}\n")
    }

    override fun onDestroy() {
        subscriptions.unsubscribe()
        super.onDestroy()
    }
}
