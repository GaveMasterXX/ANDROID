package pdm.ipbeja.pt.chatapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addNewMessageOnCliked(View view) {
    }

    public class ChatViewHolder extends RecyclerView{


        public ChatViewHolder(@NonNull View view) {
            super(view);
        }

        public void bind(/*Chat chat*/){

        }
    }


    public class ChatAdpter extends RecyclerView.Adapter<ChatViewHolder>{

        private List<Chat> data = new ArrayList<>();

        @NonNull
        @Override
        public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return null;
        }

        @Override
        public void onBindViewHolder(@NonNull ChatViewHolder chatViewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }
}
