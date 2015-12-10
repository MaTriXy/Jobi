package com.example.ilyes.jobi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.ilyes.jobi.R;
import com.example.ilyes.jobi.models.Worker;
import com.example.ilyes.jobi.others.Util;
import com.gc.materialdesign.views.ButtonFlat;

import java.util.List;

/**
 * Created by ilyes on 24/11/15.
 */
public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.MyHolder> {

    private List<Worker> mData;
    private Context mContext;

    // Provide a suitable constructor (depends on the kind of dataset)
    public WorkerAdapter(Context context,List<Worker> data) {
        this.mData = data;
        mContext = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.worker_list_item, parent, false);
        return new MyHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Worker worker = mData.get(position);

        // Parse the data here
        holder.workerName.setText(worker.getName());
        int age = Util.calculateAge(worker.getBirthDate());
        holder.workerAge.setText(age + " ans");
        holder.workerFunction.setText(worker.getFunction());

        // Setup the dialog box
        final MaterialDialog dialog = new MaterialDialog.Builder(mContext)
                .title("Contact")
                .customView(R.layout.contact, false)
                .build();

        View conactView = dialog.getCustomView();


        // When the user click on Contact a dialog show's up
        // ask how to conact the with mail or with phone number
        holder.conactWorkerFlatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyHolder extends RecyclerView.ViewHolder {
        // Your View ref
        TextView workerName;
        TextView workerAge;
        TextView workerFunction;
        ButtonFlat conactWorkerFlatBtn;

        public MyHolder(View itemView) {
            super(itemView);

            // Instance of the view here with findViewById(R.id.view_id)
            workerName = (TextView) itemView.findViewById(R.id.worker_name_tv);
            workerAge = (TextView) itemView.findViewById(R.id.worker_age_tv);
            workerFunction = (TextView) itemView.findViewById(R.id.worker_function_tv);
            conactWorkerFlatBtn = (ButtonFlat) itemView.findViewById(R.id.contac_worker_btn);
        }


    }


}
