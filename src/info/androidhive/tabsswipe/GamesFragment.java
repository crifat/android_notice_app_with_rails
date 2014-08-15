package info.androidhive.tabsswipe;

import info.androidhive.tabsswipe.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GamesFragment extends Fragment {
	
	private WebView webView;
	
	@SuppressWarnings("deprecation")
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		// get the url to open
		Bundle args = getArguments();
		String url = "http://10.0.2.2:3000/notices";
		// set up the WebView
		webView = (WebView) getView().findViewById(R.id.webView1);
		webView.setWebViewClient(new MyBrowser());
		webView.setWebChromeClient(new WebChromeClient());
		webView.getSettings().setLoadsImagesAutomatically(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		
		webView.getSettings().setDomStorageEnabled(true);
		webView.getSettings().setAppCacheEnabled(true);
		webView.getSettings().setAppCacheMaxSize(1024*1024*8);
		webView.getSettings().setAppCachePath("/data/data/"+ "chayon" +"/cache");
		webView.getSettings().setAllowFileAccess(true);
		webView.getSettings().setAppCacheEnabled(true);
		webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		
		webView.loadUrl(url);
		
		webView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if(event.getAction() == KeyEvent.ACTION_DOWN)
		        {
		            WebView webView = (WebView) v;

		            switch(keyCode)
		            {
		                case KeyEvent.KEYCODE_BACK:
		                    if(webView.canGoBack())
		                    {
		                        webView.goBack();
		                        return true;
		                    }
		                    break;
		            }
		        }
				return false;
			}
		});
 	}
	
	
	
	

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_games, container, false);
		return rootView;
	}
	
	private class MyBrowser extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	       view.loadUrl(url);
	       return true;
	    }
	}
}
