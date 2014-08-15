package info.androidhive.tabsswipe;

import info.androidhive.tabsswipe.R;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnKeyListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MoviesFragment extends Fragment {
	
private WebView webView;
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// get the url to open
		Bundle args = getArguments();
		String url = "http://10.0.2.2:3000";
		// set up the WebView
		webView = (WebView) getView().findViewById(R.id.webView2);
		webView.setWebViewClient(new MyBrowser());
		webView.getSettings().setLoadsImagesAutomatically(true);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
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

		View rootView = inflater.inflate(R.layout.fragment_movies, container, false);
		
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
