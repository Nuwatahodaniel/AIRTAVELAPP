package com.example.bookflightapp.ui.slideshow

import android.os.Bundle
import android.view.*
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bookflightapp.R

class SlideshowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        val v = inflater.inflate(R.layout.fragment_slideshow, container, false)
        val mWebView = v.findViewById<View>(R.id.discountv) as WebView
        mWebView.loadUrl("https://www.discountflights.com")

        // Enable Javascript
        val webSettings = mWebView.settings
        webSettings.javaScriptEnabled = true

        // Force links and redirects to open in the WebView instead of in a browser
        mWebView.webViewClient = WebViewClient()

        mWebView.canGoBack()
        mWebView.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                && mWebView.canGoBack()
            ) {
                mWebView.goBack()
                return@OnKeyListener true
            }
            false
        })



        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //you can set the title for your toolbar here for different fragments different titles
        activity!!.title = "Discount Flights"
    }
}


