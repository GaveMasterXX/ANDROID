package com.example.tiago.aula3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.list);

        this.adpter = new ContactAdpter(ContactDataSorce.getContact(2000));

       LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        //StaggeredGridLayoutManager staggeredGridLayoutManager =new StaggeredGridLayoutManager(2,1);

        this.recyclerView.setAdapter(this.adpter);

       this.recyclerView.setLayoutManager(layoutManager);
        //this.recyclerView.setLayoutManager(gridLayoutManager);
        //this.recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView email;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
           this.name = itemView.findViewById(R.id.name);
            this.email = itemView.findViewById(R.id.email);
        }

        public void bind(ContactDataSorce.Contact contact){

            this.name.setText(contact.getName());
            this.email.setText(contact.getEmail());

        }
    }

    public class ContactAdpter extends RecyclerView.Adapter<ContactViewHolder>{

        private List<ContactDataSorce.Contact> data;

        public ContactAdpter(List<ContactDataSorce.Contact>data) {
            this.data = data;
        }

        public void setData(List<ContactDataSorce.Contact> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_item, viewGroup, false);
            return new ContactViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int position) {
            ContactDataSorce.Contact contact = this.data.get(position);
            contactViewHolder.bind(contact);
        }

        @Override
        public int getItemCount() {
            return this.data.size();
        }
    }
}
