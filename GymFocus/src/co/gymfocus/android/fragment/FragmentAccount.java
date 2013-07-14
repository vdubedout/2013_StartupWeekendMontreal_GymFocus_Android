package co.gymfocus.android.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.gymfocus.android.R;

import com.actionbarsherlock.app.SherlockFragment;

public class FragmentAccount extends SherlockFragment {
	private View mInflatedView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mInflatedView = inflater.inflate(R.layout.fragment_account, container, false);
		return mInflatedView;
	}

}
