package masterung.androidthai.in.th.laosunseen.utility;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import masterung.androidthai.in.th.laosunseen.R;

public class ServiceAdepter extends RecyclerView.Adapter<ServiceAdepter.ServiceViewHolder> {

    private Context context;
    private ArrayList<String>  photoStringsArrayList, nameStringsArrayList, postStringsArrayList;
    private LayoutInflater layoutInflater;

    public ServiceAdepter(Context context, ArrayList<String> photoStringsArrayList, ArrayList<String> nameStringsArrayList, ArrayList<String> postStringsArrayList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.photoStringsArrayList = photoStringsArrayList;
        this.nameStringsArrayList = nameStringsArrayList;
        this.postStringsArrayList = postStringsArrayList;
    }

    @NonNull
    @Override
    public ServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = layoutInflater.inflate(R.layout.recycler_view_service, viewGroup, false);
        ServiceViewHolder serviceViewHolder = new ServiceViewHolder(view);
        return serviceViewHolder;




    }

    @Override
    public void onBindViewHolder(@NonNull ServiceViewHolder serviceViewHolder, int i) {

    String urlPathString = photoStringsArrayList.get(i);
    String namString = nameStringsArrayList.get(i);
    String postString = postStringsArrayList.get(i);


    serviceViewHolder.nameTextView.setText(namString);
    serviceViewHolder.PostTextView.setText(postString);

       Picasso
               .get()
               .load(urlPathString)
               .resize(150,150)
               .into(serviceViewHolder.circleImageView);


    }

    @Override
    public int getItemCount() {

        return nameStringsArrayList.size();

    }

    public class ServiceViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView circleImageView;
        private TextView nameTextView, PostTextView;


        public ServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.circlePhoto);
            nameTextView = itemView.findViewById(R.id.txtName);
            PostTextView= itemView.findViewById(R.id.txtPost);


        }
    }  // Service Class


}  //    Main Class
