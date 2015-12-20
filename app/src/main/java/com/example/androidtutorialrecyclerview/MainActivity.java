package com.example.androidtutorialrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.view_list);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		final String[] items = new String[100];
		for (int i = 0; i < items.length; i++) {
			items[i] = "Item " + i;
		}

		recyclerView.setAdapter(new ListAdapter(this, items));
	}

	private static class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

		private final String[] mData;
		private final LayoutInflater mInflater;

		public ListAdapter(final Context context, final String[] data) {
			mData = data;
			mInflater = LayoutInflater.from(context);
		}

		@Override
		public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
			return new ViewHolder(mInflater.inflate(android.R.layout.simple_list_item_1, parent, false));
		}

		@Override
		public void onBindViewHolder(final ViewHolder holder, final int position) {
			holder.textView.setText(mData[position]);
		}

		@Override
		public int getItemCount() {
			return mData.length;
		}

		public class ViewHolder extends RecyclerView.ViewHolder {

			public TextView textView;

			public ViewHolder(final View itemView) {
				super(itemView);

				textView = (TextView) itemView.findViewById(android.R.id.text1);
			}
		}
	}
}
