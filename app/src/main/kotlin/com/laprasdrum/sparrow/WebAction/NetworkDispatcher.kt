package com.laprasdrum.sparrow.WebAction

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.laprasdrum.sparrow.inject.Injector
import com.squareup.okhttp.*
import org.json.JSONObject
import java.util.concurrent.Callable
import java.util.concurrent.ExecutionException
import java.util.concurrent.ExecutorService
import java.util.concurrent.Future
import javax.inject.Inject

object NetworkDispatcher {
    var okHttpClient: OkHttpClient? = null
        @Inject set

    val url: String = "http://10.0.3.2:3000/oauth/token.json"

    val mainThread = Handler(Looper.getMainLooper())
    var executorService: ExecutorService? = null
        @Inject set

    init {
        Injector.get().inject(this)
    }

    fun addAction(action: NetworkAction) {
        mainThread.post(action)
    }

    fun tryNetworkRequest(action: NetworkAction): String? {
        var callable: Callable<String> = Callable {
            var params: JSONObject = JSONObject()
            params.put("username", "test@c-fo.com")
            params.put("password", "testtest")
            params.put("grant_type", "password")
            params.put("client_id", "iphone_uid")
            params.put("client_secret", "iphone_secret")
            var body: RequestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString())
            var request: Request = Request.Builder()
                    .url(url)
                    .post(body)
                    .build()
            val response: Response? = okHttpClient?.newCall(request)?.execute()
            val str = response?.body().toString()
            Log.d("REQ", response.toString())
            str
        }
        //
        val future: Future<String>? = executorService?.submit(callable)
        return try {
            return future?.get()
        } catch(e: InterruptedException) {
            e.getMessage() as String
        } catch(e: ExecutionException) {
            e.getMessage() as String
        }
//
        //        addAction(NetworkAction { Log.d("Test", future.get()) })
        //        //        var result = future.get()
        //        //        Log.d("TAG", result)
        //        addAction(action)
    }
}

class NetworkAction(callback: () -> Unit) : Runnable {
    val callback = callback

    override fun run() {
        callback()
    }
}
